package tank.frame;

import org.junit.Test;
import tank.frameobject.Bullet;
import tank.frameobject.Tank;

import static org.junit.Assert.*;

public class TankFrameTest {

    @Test
    public void addBullet() throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        tankFrame.addBullet(new Bullet(new Tank(tankFrame)));
        assertNotNull(new Object());
    }
}