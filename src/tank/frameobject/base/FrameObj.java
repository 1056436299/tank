package tank.frameobject.base;

import tank.frame.TankFrame;

import java.awt.*;

/**
 * 所有的物体继承自该类
 */
public abstract class FrameObj extends BaseFrameObj {
    /**
     *  当前面对的方向
     */
    protected TankDir dir = TankDir.UP;
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

    private volatile Rectangle rec;

    private Object recLock = new Object();

    /**
     * 获取矩形碰撞检测工具
     * @return
     */
    public Rectangle getRec(){
        if(rec == null){
            synchronized (recLock){
                if(rec == null){
                    rec = new Rectangle(this.x,this.y,this.width,this.height);
                }
            }
        }
        else{
            synchronized (recLock) {
                rec.x = this.getX();
                rec.y = this.getY();
            }
        }
        return rec;
    }

    public void setDir(TankDir dir) {
        this.dir = dir;
    }


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

}
