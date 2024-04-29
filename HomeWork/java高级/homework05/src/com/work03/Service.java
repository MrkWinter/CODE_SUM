package com.work03;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Service {
    public static void main(String[] args) {
        Thread vip = new Thread(new Svip());
        Normal normal1 = new Normal();
        normal1.thread = vip;
        Thread normal = new Thread(normal1);
        normal.start();
    }
}
class Svip implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("办理倒计时"+ i);
        }
    }
}
class  Normal implements  Runnable {
    public Thread thread;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("办理倒计时" + i);
            if(i == 5&&thread!=null) {
                System.out.println("vip用户插队");
                try {
                    thread.start();
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}