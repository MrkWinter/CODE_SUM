package com;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class PairTest {
    public static void main(String[] args) {
        Pair<String, String> p1 = new Pair<>("name", "zhang");
        Pair<String, String> p2 = new Pair<>("name", "liu");
        BaseInterface utilBase = new PairUtil();
        System.out.println("p1p2对象比较" + utilBase.compare(p1, p2));

        Pair<String, Integer> p3 = new Pair<>("age", 67);
        Pair<String, Integer> p4 = new Pair<>("age", 67);
        System.out.println("p3p4对象比较" + utilBase.compare(p1, p2));

        Pair<Integer, String> p5 = new Pair<>(1, "apple");
        Pair<Integer, String> p6 = new Pair<>(2, "pair");
        System.out.println("p5p6对象比较" + utilBase.compare(p1, p2));
    }
}
