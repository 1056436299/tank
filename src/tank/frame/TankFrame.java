package tank.frame;

import tank.frame.base.DoubleBufferingFrame;
import tank.frameobject.Boom;
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
    private List<Boom> booms = new ArrayList<>();
    public void addBoom(Boom boom){
        booms.add(boom);
    }
    public void removeBoom(Boom boom){
        booms.remove(boom);
    }
    /**
     * 主战坦克
     */
    private Tank maintank = new Tank(this);
    /**
     * 坦克所发射的子弹
     */
    private List<Bullet> bulletList = new ArrayList<Bullet>();
    /**
     * 用于存储所有的物体
     */
    List<Tank> tankList = new ArrayList<>();
    {
        //将主战坦克添加到物体列表
        tankList.add(maintank);
    }

    public void addBullet(Bullet bullet){
        bulletList.add(bullet);
    }
    public void addTank(Tank tank){
        tankList.add(tank);
    }
    public void removeBullet(Bullet bullet){
        bulletList.remove(bullet);
    }
    public void removeTank(Tank tank){
        tankList.remove(tank);
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
//        maintank.move();
//        maintank.paint(g);
        for(int i = 0 ; i < tankList.size() ; i++){
            tankList.get(i).move();
            tankList.get(i).paint(g);
        }
        for(int i = 0 ; i < bulletList.size() ; i++){
            bulletList.get(i).move();
            bulletList.get(i).paint(g);
        }
        for(Tank tank : tankList){
            for(Bullet bullet : bulletList){
                bullet.collideWithTank(tank);
            }
        }
        for(int i = 0 ; i < booms.size() ; i++){
            booms.get(i).paint(g);
        }
        removeOut();
        Color color = g.getColor();
        g.setColor(Color.white);
        g.drawString("坦克数量："+tankList.size(),50,60);
        g.drawString("子弹数量："+bulletList.size(),50,80);
        g.setColor(color);
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
