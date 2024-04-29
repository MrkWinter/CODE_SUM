package com.work01;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.util.ArrayList;

/**
 * 银行类 可以进行存取钱
 */
public class Bank implements Runnable {
    //银行账户(当前正在处理的)
    private Account curAccount;
    //当前正在处理的业务 0为取钱 1为存钱
    private Integer action;
    //当前业务存取钱的数目
    private Integer num;

    public Bank(Account curAccount, Integer action, Integer num) {
        this.curAccount = curAccount;
        this.action = action;
        this.num = num;
        if (num < 0 || (action == 0 && curAccount.getBalance() < num)) {
            throw new RuntimeException("取存钱出错 检查数据");
        }
    }

    /**
     * 存取钱业务
     *
     * @param account
     * @param num
     */
    public void saveOrWithDraw(Account account, Integer action, Integer num) {
        synchronized (Bank.class) { //使用静态锁
            System.out.println(action == 0 ? account.getName() + "：取钱正在办理中..." : account.getName() + ":存钱正在办理中...");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }
            if (action == 0) {
                account.setBalance(account.getBalance() - num);
            } else {
                account.setBalance(account.getBalance() + num);
            }
            System.out.println(account.getName() + "办理完成,当前账户余额：" + account.getBalance());
        }
    }

    @Override
    public void run() {
        saveOrWithDraw(curAccount, action, num);
    }
}
