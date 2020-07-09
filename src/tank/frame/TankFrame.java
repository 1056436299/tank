package tank.frame;

import tank.frame.base.DoubleBufferingFrame;
import tank.frameobject.Bullet;
import tank.frameobject.Tank;
import tank.frameobject.base.FrameObj;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 坦克大战页面
 */
public class TankFrame extends DoubleBufferingFrame {

    /**
     * 游戏高度
     */
    private final Integer GAME_WIDTH = 800;
    /**
     * 游戏宽度
     */
    private final Integer GAME_HEIGHT = 600;
    /**
     * 主战坦克
     */
    private Tank maintank = new Tank(this);
    /**
     * 坦克所发射的子弹
     */
    private List<Bullet> bulletList = new ArrayList<Bullet>();

    public List<Bullet> getBulletList() {
        return bulletList;
    }
    public void addBullet(Bullet bullet){
        bulletList.add(bullet);
    }

    /**
     * 用于存储所有的物体
     */
    List<FrameObj> objectList = new ArrayList<>();
    {
        //将主战坦克添加到物体列表
        objectList.add(maintank);
    }
    public TankFrame(){
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("world of tank");
        this.setVisible(true);
        this.addKeyListener(new KeyListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    @Override
    public void paint(Graphics g) {
        for(FrameObj obj : objectList){
            obj.move();
            obj.paint(g);
        }
        for(int i = 0 ; i < bulletList.size() ; i++){
            bulletList.get(i).move();
            bulletList.get(i).paint(g);
        }
        removeOut();
    }

    /**
     * 删除出局对象
     */
    private void removeOut(){
        for(Iterator<Bullet> iterator = bulletList.iterator();iterator.hasNext();){
            Bullet bullet = iterator.next();
            if(bullet.getX() < -bullet.getWidth() || bullet.getX() > GAME_WIDTH || bullet.getY() < -bullet.getHeight() || bullet.getY() > GAME_HEIGHT){
                iterator.remove();
            }
        }
    }
    class KeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:maintank.setBl(true);break;
                case KeyEvent.VK_RIGHT:maintank.setBr(true);break;
                case KeyEvent.VK_UP:maintank.setBu(true);break;
                case KeyEvent.VK_DOWN:maintank.setBd(true);break;
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:maintank.setBl(false);break;
                case KeyEvent.VK_RIGHT:maintank.setBr(false);break;
                case KeyEvent.VK_UP:maintank.setBu(false);break;
                case KeyEvent.VK_DOWN:maintank.setBd(false);break;
                case KeyEvent.VK_CONTROL:maintank.file();break;//ctrl发射子弹
            }
        }
    }
}
