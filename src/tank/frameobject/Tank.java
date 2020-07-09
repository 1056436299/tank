package tank.frameobject;

import tank.frame.TankFrame;
import tank.frameobject.base.TankDir;
import tank.frameobject.base.FrameObj;

import java.awt.*;

/**
 * 坦克
 */
public class Tank extends FrameObj {
    /**
     * 正在移动的四个方向
     */
    private boolean bl = false;
    private boolean bu = false;
    private boolean br = false;
    private boolean bd = false;



    /**
     * 默认坦克移动速度为3
     */
    {
        this.width = 50;
        this.height = 50;
        this.speed = 3;
    }

    /**
     * 默认位置，并将frame传入
     * @param frame
     */
    public Tank(TankFrame frame){
        this(200,200,frame);
    }
    public Tank(Integer x, Integer y, TankFrame frame){
        this.x = x;
        this.y = y;
        this.frame = frame;
    }

    public void setBl(boolean bl) {
        this.bl = bl;
        setDir();
    }

    public void setBu(boolean bu) {
        this.bu = bu;
        setDir();
    }

    public void setBr(boolean br) {
        this.br = br;
        setDir();
    }

    public void setBd(boolean bd) {
        this.bd = bd;
        setDir();
    }


    /**
     * 画出来
     * @param g 画笔
     */
    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.blue);
        g.fillRect(x,y,width,height);
        g.setColor(color);
    }

    /**
     * 移动
     */
    public void move(){
        if(bl || br || bu || bd){
            isMove=true;
        }
        else{
            isMove=false;
        }
        super.move();

    }
    /**
     * 设置当前面朝的方向
     */
    private void setDir(){
        if(bl) dir = TankDir.LEFT;
        if(br) dir = TankDir.RIGHT;
        if(bu) dir = TankDir.UP;
        if(bd) dir = TankDir.DOWN;
    }
    public void file(){
        Bullet bullet = new Bullet(this);
        frame.addBullet(bullet);
    }
}
