package com.mrkwinter.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class UserListTest {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("小明", "xiaoming@qq.com"));
        User xiaozhang = new User("小张", "xiaozhang@qq.com");
        userList.add(xiaozhang);
        User xiaohu = new User("小胡", "xiaohu@qq.com");
        userList.set(1, xiaohu);
        userList.remove(1);
        ListIterator<User> iterator = userList.listIterator();
        User u = iterator.next();
        System.out.println(u.toString());
        System.out.println("后面还有没有元素？" + iterator.hasNext());
        System.out.println("遍历方法1的结果！");
        for (Iterator<User> it1 = userList.iterator(); it1.hasNext(); ) {
            User user = it1.next();
            System.out.println(user.toString());
        }
        System.out.println("遍历方法2的结果！" + "此方法需要重点掌握");
        for (User tmp : userList) {
            System.out.println(tmp.toString());
        }
        System.out.println("遍历的方法3的结果！");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }
    }
}
