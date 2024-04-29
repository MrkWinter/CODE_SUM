package com.work01;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Account {
    //账户余额
    private Integer balance;
    //账户名字
    private String name;

    public Account(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(Integer balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}
