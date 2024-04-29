package com.work02;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Race {
    public static void main(String[] args) {
        Bare.thread = new Thread(new Bare());
        Tortoise.thread = new Thread(new Tortoise());
        Bare.thread.start();
        Tortoise.thread.start();
    }
}
