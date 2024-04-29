package com.work04.project1;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassInfo {
    private String name;
    private List<Student> students;

    public ClassInfo(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sort() {
        Collections.sort(students); // 使用Collections.sort对学生进行排序，会调用Student类的compareTo方法
    }

    // 其他需要的方法

    // Getter and Setter
}
