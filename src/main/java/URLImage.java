import javax.imageio.ImageIO;
import java.awt.Image;
import java.net.URL;

/**
 * Created by jrothlin on 8/29/2016.
 */
public class URLImage {
    private String urlString;
    private Image image;

    public URLImage (final String urlString) {
        this.urlString = urlString;
    }

    public void fetchImage() throws Exception {
        URL url = new URL(urlString);
        this.image = ImageIO.read(url);
    }

    public void scaleImage() {

    }

    public void saveImage() {

    }
}
