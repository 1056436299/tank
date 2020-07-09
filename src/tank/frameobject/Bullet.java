package tank.frameobject;

import tank.frameobject.base.FrameObj;

import java.awt.*;

/**
 * 炮弹
 */
public class Bullet extends FrameObj {

    {
        this.width = 2;
        this.height = 2;
        this.speed = 10;
        isMove = true;
    }
    public Bullet(Tank tank) {
        this.frame=tank.getFrame();
        this.x = tank.getX() + tank.getWidth() / 2;
        this.y = tank.getY() + tank.getHeight() / 2;
        this.dir = tank.getDir();
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.white);
        g.fillRect(x,y,width,height);
        g.setColor(color);
    }

}
