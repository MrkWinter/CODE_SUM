package com.work04.project1;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static ClassInfo readClassInfo(String path) {
        ClassInfo classInfo = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(":");
                int type = Integer.parseInt(info[0]);
                if (type == 1) { // 类型为1，表示班级信息，创建ClassInfo实例
                    classInfo = new ClassInfo(info[1]);
                } else if (type == 2) { // 类型为2，表示学生信息，添加学生到ClassInfo实例
                    if (classInfo != null) {
                        int studentId = Integer.parseInt(info[1]);
                        int gender = Integer.parseInt(info[2]);
                        classInfo.addStudent(new Student(studentId, gender));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classInfo;
    }

    public static void main(String[] args) {
        ClassInfo classInfo = readClassInfo("student.txt");
        if (classInfo != null) {
            classInfo.sort();
        }
        // 根据需要进行后续处理
    }
}

