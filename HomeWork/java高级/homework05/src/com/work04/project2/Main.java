package com.work04.project2;

/**
 * @author MrkWinter
 * @version 1.0
 */


import com.work04.project1.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static MajorInfo readMajorInfo(String path) {
        MajorInfo majorInfo = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(":");
                int type = Integer.parseInt(info[0]);
                if (type == 1) { // 类型为1，表示专业信息，创建MajorInfo实例
                    majorInfo = new MajorInfo(info[1]);
                } else if (type == 2) { // 类型为2，表示班级信息，添加班级到MajorInfo实例
                    if (majorInfo != null) {
                        int classId = Integer.parseInt(info[1]);
                        majorInfo.addClass(new Class(classId));
                    }
                } else if (type == 3) { // 类型为3，表示学生信息，添加学生到班级
                    if (majorInfo != null) {
                        int studentId = Integer.parseInt(info[1]);
                        int gender = Integer.parseInt(info[2]);
                        int classId = Integer.parseInt(info[3]);
                        Class classObj = majorInfo.getClassByClassId(classId);
                        if (classObj != null) {
                            classObj.addStudent(new Student(studentId, gender));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return majorInfo;
    }

    public static void main(String[] args) {
        MajorInfo majorInfo = readMajorInfo("info.txt");
        if (majorInfo != null) {
            int studentCount = majorInfo.getStudentCount();
            System.out.println("软件工程学生人数：" + studentCount);
            List<Class> classList = majorInfo.getClassList();
            for (Class classObj : classList) {
                int classId = classObj.getClassId();
                int studentCountInClass = classObj.getStudentCount();
                System.out.println("班级 " + classId + " 学生个数：" + studentCountInClass);
            }
        }
    }
}
