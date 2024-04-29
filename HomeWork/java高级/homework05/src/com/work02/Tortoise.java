package com.work02;

import java.util.TreeMap;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Tortoise implements Runnable{
    public static Thread thread;
    public static boolean end = false;
    private int meter;
    @Override
    public void run() {
        while (true) {
            if (end) {
                return;
            }
            meter += 1;
            if (meter == 800) {
                System.out.println("乌龟获胜");
                Bare.end = true;
                Bare.awake();
                return;
            }
            System.out.println("乌龟跑了" + meter + "米");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
