package com;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author MrkWinter
 * @version 1.0
 */
@SuppressWarnings("all")
public class InvokePractice {
    public static void main(String[] args) throws Exception {
        //1. 获得class类
        Class<?> aClass = Class.forName("com.Person");
        // Class<? extends Person> aClass1 = new Person().getClass();
        //2. 获得构造器
        Constructor<?> c1 = aClass.getConstructor(String.class, int.class, String.class, int.class);
        Constructor<?>[] cArr = aClass.getDeclaredConstructors();
        //3. 通过class类对象 获取对象
        Person p1 = (Person) c1.newInstance("z张三", 19, "9-2", 1222);
        Person p2 = null;
        for (Constructor c : cArr) {
            Class[] typeArr = c.getParameterTypes();
            if (typeArr.length > 0 && typeArr[0] == int.class) {
                c.setAccessible(true);
                p2 = (Person) c.newInstance(13333);
            }
        }
        //4. 获得使用属性
        Field name = aClass.getField("name");
        name.set(p1, "张三");
        Field[] fArr = aClass.getDeclaredFields();
        for (Field f : fArr) {
            if (f.getModifiers() != 1)
                f.setAccessible(true);
            switch (f.getName()) {
                case "name":
                    f.set(p2, "李四");
                    break;
                case "age":
                    f.set(p2, 20);
                    break;
                case "birthday":
                    f.set(p2, "10-21");
                    break;
            }
        }
        //5. 获得使用方法
        Method say = aClass.getMethod("say", String.class);
        say.invoke(p1, "p1 说 ：你好呀");
        Method[] mArr = aClass.getDeclaredMethods();
        for (Method m : mArr) {
            if (m.getModifiers() != 1)
                m.setAccessible(true);
            if (m.getName().equals("say") || m.getName().equals("song"))
                m.invoke(p2, "p2 说 ：你好呀");
        }
        System.out.println(p1);
        System.out.println(p2);
    }

}

class Person {
    public String name;
    protected int age;
    String birthday;
    private int id;

    public Person() {
    }

    public Person(String name, int age, String birthday, int id) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.id = id;
    }

    private Person(int id) {
        this.id = id;
    }

    public void say(String str) {
        System.out.println(str);
    }

    private void song(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", birthday='" + birthday + '\'' +
                ", id=" + id +
                '}';
    }
}