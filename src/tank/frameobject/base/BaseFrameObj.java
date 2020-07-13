package tank.frameobject.base;

import tank.frame.TankFrame;

import java.awt.*;

public abstract class BaseFrameObj {
    /**
     * 当前是否生存
     */
    protected boolean live = true;
    /**
     * 当前
     */
    protected TankFrame frame;
    /**
     * 当前所在的位置，x轴
     */
    protected int x = 0;
    /**
     * 当前所在的位置，y轴
     */
    protected int y = 0;

    public TankFrame getFrame() {
        return frame;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void die(){
        this.live = false;
    }
    public boolean isLive(){
        return live;
    }
    /**
     * 将当前物体画出来
     */
    public abstract void paint(Graphics g);
}
