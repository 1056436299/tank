package tank.frameobject;

import tank.Audio;
import tank.ResourceFile;
import tank.frameobject.base.BaseFrameObj;

import java.awt.*;

public class Explode extends BaseFrameObj {
    int step = 0;
    Tank tank = null;
    public Explode(Tank tank){
        this.x=tank.getX();
        this.y=tank.getY();
        this.tank = tank;
        this.frame=tank.getFrame();
        new Audio("audio/explode.wav").start();
    }
    @Override
    public void paint(Graphics g) {
        if(step>=ResourceFile.boomImages.length){
            die();
            return;
        }
        int explodeX = tank.getX()+(tank.getWidth()/2)-(ResourceFile.boomImages[step].getWidth()/2);
        int explodeY = tank.getY()+(tank.getHeight()/2)-(ResourceFile.boomImages[step].getHeight()/2);
        g.drawImage(ResourceFile.boomImages[step],explodeX,tank.getY(),null);
        step++;
    }

    @Override
    public void die() {
        super.die();
        frame.removeBoom(this);
    }
}
