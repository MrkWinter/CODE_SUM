package com.mrkwinter.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class StudentSetTest {
    public static void main(String[] args) {
        HashSet<Student> studentSet = new HashSet<Student>();
        Student stu1 = new Student("张三", 18);
        Student stu2 = new Student("李四", 20);
        Student stu3 = new Student("王五", 19);
        studentSet.add(stu1);
        studentSet.add(stu2);
        studentSet.add(stu3);
        studentSet.remove(stu2);
        boolean isContain=false;
        isContain= studentSet.contains(stu1);
        System.out.println(isContain);
        Iterator<Student> iterator=studentSet.iterator();
        Student s=iterator.next();
        System.out.println("此Set集合第一个元素是："+s.toString());
        System.out.println("还有没有下一个元素？"+iterator.hasNext());
        System.out.println("下一个是："+iterator.next());
        System.out.println("使用迭代器Iterator进行遍历的结果：");
        Iterator<Student> it = studentSet.iterator();
        while (it.hasNext()) {
            Student student1 = it.next();
            System.out.println(student1.toString());
        }
        System.out.println("使用foreach进行遍历的结果：");
        for (Student student2 : studentSet) {
            System.out.println(student2.toString());

        }
        System.out.println("使用Lambda表达式进行遍历的结果：");
        studentSet.forEach((Student stu)->System.out.println(stu));
    }

}
