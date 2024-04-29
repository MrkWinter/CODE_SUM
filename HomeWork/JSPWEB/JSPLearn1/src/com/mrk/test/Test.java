package com.mrk.test;

import com.mrk.utils.DataBase;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        new DataBase().executeQuery("select * from account");
    }
}
