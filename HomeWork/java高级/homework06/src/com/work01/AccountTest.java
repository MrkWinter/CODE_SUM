package com.work01;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account(1000,"账户1");
        Account account2 = new Account(2000,"账户2");
        Bank bankService1 = new Bank(account1, 0, 200);
        Bank bankService2 = new Bank(account2, 1, 300);
        new Thread(bankService1).start();
        new Thread(bankService2).start();
    }
}
