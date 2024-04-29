package com.work04.project1;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Student implements Comparable<Student> {
    private int studentId;
    private int gender;

    public Student(int studentId, int gender) {
        this.studentId = studentId;
        this.gender = gender;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getGender() {
        return gender;
    }

    @Override
    public int compareTo(Student other) {
        // 先按照性别排序，女生在前面，男生在后面
        if (this.gender != other.gender) {
            return this.gender - other.gender;
        }
        // 当都是女生时，按照学号升序排序
        return this.studentId - other.studentId;
    }
}

