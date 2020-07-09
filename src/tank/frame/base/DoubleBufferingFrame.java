package tank.frame.base;

import java.awt.*;
/**
 * 双缓冲
 */
public abstract class DoubleBufferingFrame extends Frame {
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage((int)this.getSize().getWidth(), (int)this.getSize().getHeight());
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,(int)this.getSize().getWidth(), (int)this.getSize().getHeight());
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

}
