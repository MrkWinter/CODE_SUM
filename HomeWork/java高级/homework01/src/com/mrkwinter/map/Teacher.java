package com.mrkwinter.map;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Teacher {
    String name;
    String sex;

    public Teacher(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Teacher[" + name + "," + sex + "]";

    }
}
