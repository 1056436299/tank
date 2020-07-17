package tank;

import tank.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceFile {
    private ResourceFile(){}
    public static BufferedImage[] boomImages = new BufferedImage[16];
    static{
        try{
            for(int i = 0 ;i < 16 ; i++){
                boomImages[i] = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        }
        catch (Exception e){

        }
    }
    public static BufferedImage tankU;
    public static BufferedImage tankD;
    public static BufferedImage tankL;
    public static BufferedImage tankR;

    static{
        try {
            tankU = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageUtil.rotateImage(tankU,180);
            tankL = ImageUtil.rotateImage(tankU,-90);
            tankR = ImageUtil.rotateImage(tankU,90);
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
            bulletU = ImageIO.read(ResourceFile.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageUtil.rotateImage(bulletU,180);
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletR = ImageUtil.rotateImage(bulletU,90);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
