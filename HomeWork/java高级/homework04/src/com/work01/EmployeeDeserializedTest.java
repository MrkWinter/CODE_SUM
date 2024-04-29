package com.work01;

import java.io.*;

public class EmployeeDeserializedTest {
    public static void main(String[] args) {
        File file=new File("employee.dat");
        Employee employee=null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            employee = (Employee) ois.readObject();
            System.out.println("修改员工的信息：");
            System.out.println(employee);
        }
        catch (FileNotFoundException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        employee.getAddress().setCity("中国");
        employee.getAddress().setProvince("武汉省");
        employee.getAddress().setCity("武汉市");
        employee.setAge(21);
    }
}
