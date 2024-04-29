package com.work3;

import java.io.*;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream objOut = new ObjectOutputStream(
                new FileOutputStream(new File("address.dat")));
        objOut.writeObject(new Address("河南","周口"));
        ObjectInputStream objInt = new ObjectInputStream(
                new FileInputStream("address.dat"));
        objOut.flush();
        objOut.close();
        Address o = (Address)objInt.readObject();
        System.out.println(o);

    }
}
class Address implements Serializable {
    private String state;
    private String province;

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Address(String state, String province) {
        this.state = state;
        this.province = province;
    }
}
