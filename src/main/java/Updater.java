import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jrothlin on 8/29/2016.
 */
public class Updater {
    private static final int MINS_BETWEEN_UPDATE = 15;
    private static final int MILLIS_IN_ONE_MINUTE = 60000;
    private static final Logger LOGGER = Logger.getLogger(Updater.class.getName());
    private static final String IMAGE_URL_STRING = "http://www.washington.edu/cambots/camera1_l.jpg";
    private static final String IMAGE_FILE_LOCATION = "D:/Photos/camera1_1.jpg";

    public static void main(String[] args) {
        URLImage urlImage = new URLImage(IMAGE_URL_STRING);
//        while (true) {
            try {
                urlImage.fetchImage();
                urlImage.scaleImage(.9, .9);
                urlImage.saveImage(IMAGE_FILE_LOCATION);
//                DesktopBackground.setBackground(IMAGE_FILE_LOCATION);
//                Thread.sleep(MINS_BETWEEN_UPDATE * MILLIS_IN_ONE_MINUTE);
            } catch (final Exception e) {
                LOGGER.log(Level.SEVERE, "Found exception", e);
            }
//        }
    }
}
