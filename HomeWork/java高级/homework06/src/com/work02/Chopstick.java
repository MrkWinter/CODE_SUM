package com.work02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Chopstick {
    private final int number;
    private final ReentrantLock lock;

    public Chopstick(int number) {
        this.number = number;
        this.lock = new ReentrantLock();
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}
