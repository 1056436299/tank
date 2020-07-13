package tank.frameobject;

import tank.frame.TankFrame;

import java.util.Random;

public class AITank extends Tank {
    {
        this.isMove = true;
    }

    Random random = new Random();

    private void noDir() {
        bd = false;
        br = false;
        bu = false;
        bl = false;
    }

    @Override
    public void move() {
        int rand = random.nextInt(100);
        if (this.x < 0) {
            br = true;
        }
        if (this.x > frame.getWidth() - this.width) {
            bl = true;
        }
        if (this.y < 0) {
            bd = true;
        }
        if (this.y > frame.getHeight() - this.height) {
            bu = true;
        }
        if (rand == 99) {
            file();
        }
        if (rand == 98) {
            noDir();
            bd = true;
        }
        if (rand == 97) {
            noDir();
            br = true;
        }
        if (rand == 96) {
            noDir();
            bu = true;
        }
        if (rand == 95) {
            noDir();
            bl = true;
        }
        setDir();
        super.move();
    }

    public AITank(TankFrame frame) {
        super(frame);
    }

    public AITank(TankFrame frame, int x, int y) {
        super(frame, x, y);
    }
}
