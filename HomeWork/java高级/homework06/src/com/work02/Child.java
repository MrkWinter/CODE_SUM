package com.work02;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Child extends Thread {
    private final int number;
    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;

    public Child(int number, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.number = number;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    private void eat() {
        System.out.println("Child " + number + " is eating.");
        try {
            Thread.sleep(1000); // 模拟吃饭时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //模拟进餐
        leftChopstick.pickUp();
        rightChopstick.pickUp();
        eat();
        leftChopstick.putDown();
        rightChopstick.putDown();
    }
}
