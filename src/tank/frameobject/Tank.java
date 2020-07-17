package tank.frameobject;

import tank.ResourceFile;
import tank.bulletStrategy.FireStrategy;
import tank.frame.TankFrame;
import tank.frameobject.base.TankDir;
import tank.frameobject.base.FrameObj;

import java.awt.*;
import java.util.List;

/**
 * 坦克
 */
public class Tank extends FrameObj {
    /**
     * 正在移动的四个方向
     */
    protected boolean bl = false;
    protected boolean bu = false;
    protected boolean br = false;
    protected boolean bd = false;



    /**
     * 默认坦克移动速度为3
     */
    {
        this.width = ResourceFile.tankD.getWidth();
        this.height = ResourceFile.tankD.getHeight();
        this.speed = 3;
    }

    /**
     * 默认位置，并将frame传入
     * @param frame
     */
    public Tank(TankFrame frame){
        this(frame,200,200);
    }
    /**
     * 传入x,y位置，并将frame传入
     * @param frame
     */
    public Tank(TankFrame frame,int x , int y){
        this.frame = frame;
        this.x = x;
        this.y = y;
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
//        Color color = g.getColor();
//        g.setColor(Color.blue);
        if(!this.isLive()){
            frame.removeTank(this);
            return;
        }
        switch (dir){
            case LEFT:g.drawImage(ResourceFile.tankL,x,y,null);break;
            case RIGHT:g.drawImage(ResourceFile.tankR,x,y,null);break;
            case UP:g.drawImage(ResourceFile.tankU,x,y,null);break;
            case DOWN:g.drawImage(ResourceFile.tankD,x,y,null);break;
        }

//        g.fillRect(x,y,width,height);
//        g.setColor(color);
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
        /**
         * 如果越界，则位置为边界值
         */
        if (this.x < 0) {
            x = 0;
        }
        if (this.x > frame.getWidth() - this.width) {
            x = frame.getWidth() - this.width;
        }
        if (this.y < 0) {
            y = 0;
        }
        if (this.y > frame.getHeight() - this.height) {
            y = frame.getHeight() - this.height;
        }
    }
    /**
     * 设置当前面朝的方向
     */
    protected void setDir(){
        if(bl) dir = TankDir.LEFT;
        if(br) dir = TankDir.RIGHT;
        if(bu) dir = TankDir.UP;
        if(bd) dir = TankDir.DOWN;
    }
    /**
     * 开炮
     */
    public void fire(FireStrategy bulletStrategy){
        List<Bullet> list = bulletStrategy.bulletFire(this);
        frame.addBullets(list);
    }

    @Override
    public void die() {
        super.die();
        frame.addBoom(new Explode(this));
    }
}
