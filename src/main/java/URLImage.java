import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by jrothlin on 8/29/2016.
 */
public class URLImage {
    private String urlString;
    private BufferedImage image;
    private final static String format = "png";

    public URLImage (final String urlString) {
        this.urlString = urlString;
    }

    public void fetchImage() throws Exception {
        URL url = new URL(urlString);
        this.image = ImageIO.read(url.openStream());
    }

    public void scaleImage(final double width, final double height) {
        BufferedImage resized = new BufferedImage((int) (width * 704), (int) (height * 480), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resized.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(width, height);
        g.drawRenderedImage(image, at);
//        image = resized;
//        image = image.getScaledInstance(width, height, 0);
    }

    public void saveImage(final String location) throws IOException {
        if (image != null) {
            File imageFile = new File(location);
            ImageIO.write(image, format, imageFile);
        }
    }
}
