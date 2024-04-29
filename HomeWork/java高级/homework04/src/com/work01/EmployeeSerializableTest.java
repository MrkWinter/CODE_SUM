package com.work01;

import java.io.*;

public class EmployeeSerializableTest {
    public static void main(String[] args) throws IOException {
        Address address = new Address("中国", "吉林", "长春");
        Employee emplpyee = new Employee("张XX", 30, address);
        System.out.println(emplpyee.toString());
        File file = new File("employee.dat");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        oos.writeObject(emplpyee);
        oos.flush();
        oos.close();
        fos.close();
    }
}
