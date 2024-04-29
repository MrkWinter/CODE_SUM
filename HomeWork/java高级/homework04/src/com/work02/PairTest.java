package com.work02;

public class PairTest {
    public static void main(String[] args) {
        Pair<String,String>p1=new Pair<String, String>("name","zhang");
        Pair<String,String>p2=new Pair<String, String>("name","liu");
        BaseInterfase utiBase=new PairUtil();
        System.out.printf("比较结果：p1=p2\t"+utiBase.compare(p1,p2));
        Pair<String,Integer>p3=new Pair<String, Integer>("age",67);
        Pair<String,Integer>p4=new Pair<String, Integer>("age",67);
        System.out.printf("比较结果：p3=p4\t"+utiBase.compare(p3,p4));
        Pair<Integer,String>p5=new Pair<Integer,String>(1,"apple");
        Pair<Integer,String>p6=new Pair<Integer,String>(2,"pear");
        boolean same= utiBase.compare(p5,p6);
        System.out.print("比较成果：p5=p6\t"+same);;
    }
}
