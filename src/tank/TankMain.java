package tank;


import tank.frame.TankFrame;

/**
 * 坦克大战主类
 */
public class TankMain {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        while(true){
            Thread.sleep(30);
            tankFrame.repaint();
        }
    }
}
