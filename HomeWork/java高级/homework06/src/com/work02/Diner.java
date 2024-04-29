package com.work02;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Diner {
    public static void main(String[] args) {
        int numChild = 5;
        Chopstick[] chopsticks = new Chopstick[numChild];
        Child[] children = new Child[numChild];

        for (int i = 0; i < numChild; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        for (int i = 0; i < numChild; i++) {
            children[i] = new Child(i, chopsticks[i], chopsticks[(i + 1) % numChild]);
        }

        for (Child child : children) {
            child.start();
        }

        for (Child child : children) {
            try {
                child.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
