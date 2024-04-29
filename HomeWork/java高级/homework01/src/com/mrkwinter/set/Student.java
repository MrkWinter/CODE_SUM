package com.mrkwinter.set;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student[" + name + "," + age + "]";
    }
}


//    HashMap<Integer, String> hashMap = new HashMap<>();
//    Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
//Entry 是 Map中的一个内部接口 在EntrySet方法中实现了该结构 形成一个类
//该类中存储key 和 value值 并且有相关方法 把所有Map.Entry<> 类型的对象 (接口向上转型接收)
//保存在set中 然后用set中的迭代器遍历