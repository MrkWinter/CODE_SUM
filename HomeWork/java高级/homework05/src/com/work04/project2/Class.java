package com.work04.project2;

/**
 * @author MrkWinter
 * @version 1.0
 */


import com.work04.project1.Student;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private int classId;
    private List<Student> students;

    public Class(int classId) {
        this.classId = classId;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getStudentCount() {
        return students.size();
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // 其他需要的方法

    // Getter and Setter
}
