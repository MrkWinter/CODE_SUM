package com.work04;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class StudentSER {

    //将学生信息录入并保存到dat文件中 返回文件路径
    public String enterInfoStudent(String src) {
        return SerStudent(infoStudent(), src);
    }
    //输入学生数据 得到一个学生对象
    public Student infoStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------请输入学生信息------\n 请输入学生学号:");
        String id = scanner.next();
        System.out.println("请输入学习姓名:");
        String name = scanner.next();
        System.out.println("请输入学习身份证号:");
        String identity = scanner.next();
        System.out.println("------请输入学生成绩------\n Java:");
        int javaGrade = scanner.nextInt();
        System.out.println("MySQL:");
        int MySQLGrade = scanner.nextInt();
        System.out.println("JavaWeb:");
        int javaWebGrade = scanner.nextInt();
        HashMap<String, Integer> grade = new HashMap<>();
        grade.put("Java",javaGrade);
        grade.put("MySQL",MySQLGrade);
        grade.put("JavaWeb",javaWebGrade);
        double avgGrade = getAvg(grade);
        return new Student(id, name, identity, grade, avgGrade);
    }
    public double getAvg(HashMap<String,Integer> grade) {
        Collection<Integer> values = grade.values();
        Iterator<Integer> iterator = values.iterator();
        int count = 0;
        double sum = 0;
        for (Object o: grade.values()) {
            count+=1;
            sum += (Integer) o;
        }
        return sum/count;
    }
    //指定文件目录  序列化成文件 返回文件路径
    public String SerStudent(Student stu, String dest) {
        dest = dest + ".dat";
        try {
            ObjectOutputStream objOut = new ObjectOutputStream(
                    new FileOutputStream(dest));
            objOut.writeObject(stu);
            objOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dest;
    }

    //根据文件路径 返回序列化的对象
    public Student ReSerStudent(String src) {
        Student stu = null;
        try {
            ObjectInputStream objPut = new ObjectInputStream(
                    new FileInputStream(src));
            stu = (Student) objPut.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return stu;
    }

}

class Student implements Serializable {
    private String stu_id;
    private String name;
    private transient String identity;
    private HashMap<String, Integer> grade;
    private double avg_grade;

    public Student(String stu_id, String name, String identity, HashMap<String, Integer> grade, double avg_grade) {
        this.stu_id = stu_id;
        this.name = name;
        this.identity = identity;
        this.grade = grade;
        this.avg_grade = avg_grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id + '\'' +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", grade=" + grade +
                ", avg_grade=" + avg_grade +
                '}';
    }
}
