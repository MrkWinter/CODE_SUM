package com.mrkwinter.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class TeacherMapTest {
    public static void main(String[] args) {
        Map<String, Teacher> teacherMap = new HashMap<String, Teacher>();
        Teacher teac1 = new Teacher("张三", "男");
        Teacher teac2 = new Teacher("李四", "女");
        Teacher teac3 = new Teacher("王五", "男");
        teacherMap.put("001", teac1);
        teacherMap.put("102", teac2);
        teacherMap.put("201", teac3);
        teacherMap.remove("001");
        Teacher teacher = new Teacher("李思", "女");
        teacherMap.replace("102", teac2, teacher);
        System.out.println("此Map中是否包含工号202?" + teacherMap.containsKey("202"));
        System.out.println("此Map中是否包含teac3?" + teacherMap.containsValue(teac3));
        System.out.println("所有的工号：");
        for (String s : teacherMap.keySet()) {
            System.out.println(s);
        }
        System.out.println("所有的教师：");
        for (Teacher t : teacherMap.values()) {
            System.out.println(t.toString());

        }
        System.out.println("entrySet()方法的使用...");
        Set<Map.Entry<String, Teacher>> entrySet = teacherMap.entrySet();
        for (Map.Entry<String, Teacher> entry : entrySet) {
            String s = entry.getKey();
            Teacher t = entry.getValue();
            System.out.println(s + "," + t.getName() + "," + t.getSex());
        }
        System.out.println("通过Key获取Value进行遍历：");
        for (String s : teacherMap.keySet()) {
            Teacher t = teacherMap.get(s);
            System.out.println(t.toString());
        }
        System.out.println("通过获取Map中所有的Value进行遍历：");
        for (Teacher t : teacherMap.values()) {
            System.out.println(t.toString());
        }
        System.out.println("通过entrySet()进行遍历:");
        for (Map.Entry<String, Teacher> teac : teacherMap.entrySet()) {
            String s = teac.getKey();
            Teacher t = teac.getValue();
            System.out.println(s + "," + t.toString());
        }
    }
}
 