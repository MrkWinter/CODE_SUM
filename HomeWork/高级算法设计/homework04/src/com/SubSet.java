package com;

/**
 * @author MrkWinter
 * @version 1.0
 */

import java.util.List;
import java.util.ArrayList;

public class SubSet {

    private List<String> subset = new ArrayList<>();  //这里就存放各个子集

    public void computeSubSet(String str) {

        if (str.length() == 1)    //当str只有一个字符时，直接把它当成一个子集加入subset中
        {
            subset.add(str);
            return;
        }

        String first = str.substring(0, 1);  //取出第一个字符
        String left = str.substring(1);   //取出剩余字符

        computeSubSet(left);   //剩余字符要再次调用computeSubset计算它的子集

        int size = subset.size();  //子集的个数
        for (int i = 0; i < size; i++) {
            subset.add(first + subset.get(i));
        }
        subset.add(first);  //第一个字符也是集合的一个子集所以要加到subset中
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < subset.size(); i++) {
            String str = subset.get(i);
            buffer.append("{").append(str).append("}\n");  //每一行就是一个子集 例如{B}\n{AB}
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        SubSet ss = new SubSet();
        String sm = "ABCD";
        ss.computeSubSet(sm);
        System.out.println(ss);  //默认会调用ss.toString()
    }
}