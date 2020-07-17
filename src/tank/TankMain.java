package tank;


import tank.frame.TankFrame;
import tank.frameobject.AITank;
import tank.frameobject.Tank;

/**
 * 坦克大战主类
 */
public class TankMain {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
//        for(tankFrame)
//        tankFrame.addtank
        for(int i = 0 ; i < Integer.parseInt(Prop.get("enemyNum").toString()); i++){
            tankFrame.addTank(new AITank(tankFrame,100*(i+1),100));
        }
        while(true){
            Thread.sleep(30);
            tankFrame.repaint();
        }
    }
}
