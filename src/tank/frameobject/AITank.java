package tank.frameobject;

import tank.bulletStrategy.OneBullet;
import tank.frame.TankFrame;

import java.util.Random;

/**
 * 电脑自动移动的坦克
 */
public class AITank extends Tank {
    {
        this.isMove = true;
    }

    Random random = new Random();

    /**
     * 清除当前的移动按钮
     */
    private void noDir() {
        bd = false;
        br = false;
        bu = false;
        bl = false;
    }

    @Override
    public void move() {
        int rand = random.nextInt(100);

        /**
         * 模拟随机按下上下左右方向
         */
        if (rand == 99) {
            fire(OneBullet.getins());
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

        setDir();//转向
        super.move();
    }

    public AITank(TankFrame frame) {
        super(frame);
    }

    public AITank(TankFrame frame, int x, int y) {
        super(frame, x, y);
    }
}
