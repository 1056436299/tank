package tank.bulletStrategy;

import tank.frameobject.Bullet;
import tank.frameobject.Tank;

import java.util.ArrayList;
import java.util.List;

/**
 * 向前发射子弹
 */
public class OneBullet implements FireStrategy {

    private OneBullet(){

    }
    private static OneBullet ins = new OneBullet();
    public static OneBullet getins(){
        return ins;
    }
    @Override
    public List<Bullet> bulletFire(Tank tank) {
        Bullet bullet = new Bullet(tank);
        List<Bullet> list = new ArrayList<>();
        list.add(bullet);
        return list;
    }
}
