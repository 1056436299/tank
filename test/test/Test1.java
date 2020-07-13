package test;

import org.junit.Test;
import static org.junit.Assert.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test1 {
    @Test
    void test(){
        try {
            BufferedImage bufferedInputStream = ImageIO.read(new File(""));
            assertNotNull(bufferedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
