import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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

    public void scaleImage(final double widthScale, final double heightScale) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage after = new BufferedImage((int) (w * widthScale), (int) (h * heightScale), BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(widthScale, heightScale);
        AffineTransformOp scaleOp =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        image = scaleOp.filter(image, after);
    }

    public void saveImage(final String location) throws IOException {
        if (image != null) {
            File imageFile = new File(location);
            ImageIO.write(image, format, imageFile);
        }
    }
}
