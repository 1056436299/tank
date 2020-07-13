package tank.frameobject.base;

import tank.frame.TankFrame;

import java.awt.*;

/**
 * 所有的物体继承自该类
 */
public abstract class FrameObj {
    /**
     * 当前是否生存
     */
    protected boolean live = true;
    /**
     * 当前
     */
    protected TankFrame frame;
    /**
     *  当前面对的方向
     */
    protected TankDir dir = TankDir.UP;

    /**
     * 当前所在的位置，x轴
     */
    protected int x = 0;
    /**
     * 当前所在的位置，y轴
     */

    /**
     * 物体的宽度
     */
    protected int width = 0;
    /**
     * 物体的高度
     */
    protected int height = 0;
    /**
     * 是否在移动
     */
    protected boolean isMove = false;
    protected int y = 0;
    protected int speed = 0;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public TankDir getDir() {
        return dir;
    }

    public void setDir(TankDir dir) {
        this.dir = dir;
    }

    public TankFrame getFrame() {
        return frame;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * 将当前物体画出来
     */
    public abstract void paint(Graphics g);

    /**
     * 物体的移动方法
     */
    public void move(){
        if(isMove) {
            switch (dir) {
                case LEFT:
                    x -= speed;
                    break;
                case RIGHT:
                    x += speed;
                    break;
                case UP:
                    y -= speed;
                    break;
                case DOWN:
                    y += speed;
                    break;
            }
        }
    }
    public void die(){
        this.live = false;
    }
    public boolean isLive(){
        return live;
    }
}
