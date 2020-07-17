package tank.bulletStrategy;

import tank.frameobject.Bullet;
import tank.frameobject.Tank;

import java.util.List;

/**
 * 坦克子弹发射策略
 */
public interface FireStrategy {
    /**
     * 根据坦克，创建不同的子弹
     * @param tank
     * @return
     */
    List<Bullet> bulletFire(Tank tank);
}
