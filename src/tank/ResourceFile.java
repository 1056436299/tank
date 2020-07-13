package tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceFile {
    public static BufferedImage tankU;
    public static BufferedImage tankD;
    public static BufferedImage tankL;
    public static BufferedImage tankR;

    static{
        try {
            tankU = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankL = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static BufferedImage bulletL;
    public static BufferedImage bulletD;
    public static BufferedImage bulletU;
    public static BufferedImage bulletR;
    static{
        try {
            bulletL = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletD = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletU = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
