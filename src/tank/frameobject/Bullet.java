package tank.frameobject;

import tank.ResourceFile;
import tank.frameobject.base.FrameObj;
import tank.frameobject.base.TankDir;

import java.awt.*;

/**
 * 炮弹
 */
public class Bullet extends FrameObj {
    private Tank reftank;

    {
        this.width = ResourceFile.bulletD.getWidth();
        this.height = ResourceFile.bulletD.getHeight();
        this.speed = 10;
        this.isMove = true;
    }
    public Bullet(Tank tank) {
        this.reftank = tank;
        this.frame=tank.getFrame();
        this.x = tank.getX() + tank.getWidth() / 2 - getWidth() / 2;
        this.y = tank.getY() + tank.getHeight() / 2 - this.height / 2;
        this.dir = tank.getDir();
    }
    public Bullet(Tank tank,TankDir dir) {
        this.reftank = tank;
        this.frame=tank.getFrame();
        this.x = tank.getX() + tank.getWidth() / 2 - getWidth() / 2;
        this.y = tank.getY() + tank.getHeight() / 2 - this.height / 2;
        this.dir = dir;
    }

    public void setDir(TankDir dir){
        this.dir = dir;
    }
    @Override
    public void paint(Graphics g) {
        if(!isLive()){
            frame.removeBullet(this);
        }
        switch (dir){
            case LEFT:g.drawImage(ResourceFile.bulletL,x,y,null);break;
            case RIGHT:g.drawImage(ResourceFile.bulletR,x,y,null);break;
            case UP:g.drawImage(ResourceFile.bulletU,x,y,null);break;
            case DOWN:g.drawImage(ResourceFile.bulletD,x,y,null);break;
        }
    }

    public void collideWithTank(Tank tank){
//        Rectangle tankRec = new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
//        Rectangle thisRec = new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
        if(this.reftank != tank && this.getRec().intersects(tank.getRec())){
            tank.die();
            this.die();
        }
    }
}
