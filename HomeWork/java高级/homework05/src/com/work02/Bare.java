package com.work02;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Bare implements Runnable {
    public static Thread thread;
    public static boolean end = false;
    private int meter;

    public static void awake() {
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            meter += 2;
            if (meter == 600) {
                try {
                    System.out.println("兔子休息");
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    System.out.println("兔子醒了");
                }
            }
            if (end) {
                return;
            }
            if (meter == 800) {
                System.out.println("兔子获胜");
                Tortoise.end = true;
                return;
            }
            System.out.println("兔子跑了" + meter + "米");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
