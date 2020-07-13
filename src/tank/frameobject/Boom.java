package tank.frameobject;

import tank.ResourceFile;
import tank.frameobject.base.BaseFrameObj;

import java.awt.*;

public class Boom extends BaseFrameObj {
    int step = 0;

    public Boom(Tank tank){
        this.x=tank.getX();
        this.y=tank.getY();
        this.frame=tank.getFrame();
    }
    @Override
    public void paint(Graphics g) {
        if(step>=ResourceFile.boomImages.length){
            die();
            return;
        }
        g.drawImage(ResourceFile.boomImages[step++],x,y,null);
    }

    @Override
    public void die() {
        super.die();
        frame.removeBoom(this);
    }
}
