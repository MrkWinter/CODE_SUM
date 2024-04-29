package algorithm_imp.algo_problems_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1. 约瑟夫环问题 (单向环形链表的使用)
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleLinked circleLinked = new CircleLinked();
        circleLinked.addChild(new Child("a"));
        circleLinked.addChild(new Child("b"));
        circleLinked.addChild(new Child("c"));
        circleLinked.addChild(new Child("d"));
        circleLinked.addChild(new Child("e"));
        ArrayList<Child> order = circleLinked.getOrder(1, 2);
        for (Child c : order) {
            System.out.println(c);
        }
    }
}


class CircleLinked {
    private Child first;
    private Child curChild;

    public void addChild(Child child) {
        if (first == null) {
            first = child;
            first.next = first;
            curChild = first;
            return;
        }
        curChild.next = child;
        curChild = child;
        curChild.next = first;
    }


    public ArrayList<Child> getOrder(int begin, int interval) {
        if (first == null)
            return null;
        ArrayList<Child> childrenOrder = new ArrayList<>();
        //找到第一个孩子 前一个位置
        Child outChild = null;
        if (begin == 1)
            outChild = curChild;
        else {
            outChild = first;
            for (int i = 0; i < begin - 2; i++) {
                outChild = outChild.next;
            }
        }
        while (outChild.next != outChild) {
            childrenOrder.add(outChild.next);
            //删除
            outChild.next = outChild.next.next;
            //移动
            for (int i = 0; i < interval - 1; i++) {
                outChild = outChild.next;
            }

        }
        childrenOrder.add(outChild);
        return childrenOrder;
    }
}

class Child {
    public String name;
    public Child next;

    public Child(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }

    public Child() {
    }
}
