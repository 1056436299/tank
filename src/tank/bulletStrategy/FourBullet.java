package tank.bulletStrategy;

import tank.frameobject.Bullet;
import tank.frameobject.Tank;
import tank.frameobject.base.TankDir;

import java.util.ArrayList;
import java.util.List;

/**
 * 向4个方向发射子弹
 */
public class FourBullet implements FireStrategy {
    private FourBullet(){

    }
    private static FourBullet ins = new FourBullet();
    public static FourBullet getins(){
        return ins;
    }
    @Override
    public List<Bullet> bulletFire(Tank tank) {
        Bullet bulletl = new Bullet(tank, TankDir.LEFT);
        Bullet bulletu = new Bullet(tank, TankDir.UP);
        Bullet bulletd = new Bullet(tank, TankDir.DOWN);
        Bullet bulletr = new Bullet(tank, TankDir.RIGHT);
        List<Bullet> list = new ArrayList<>();
        list.add(bulletl);
        list.add(bulletu);
        list.add(bulletd);
        list.add(bulletr);

        return list;
    }
}
