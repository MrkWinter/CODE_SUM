package com.work04;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        StudentSER studentSER = new StudentSER();
        Student student1 = studentSER.ReSerStudent(studentSER.enterInfoStudent("student1"));
        System.out.println(student1);
    }
}
