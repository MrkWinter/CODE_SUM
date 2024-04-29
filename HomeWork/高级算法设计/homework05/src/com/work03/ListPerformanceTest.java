package com.work03;

/**
 * @author MrkWinter
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {
    public static void main(String[] args) {
        int dataSize = 100000; // 测试数据的大小

        // ArrayList 插入数据性能测试
        List<Integer> arrayList = new ArrayList<>();
        long arrayListInsertStartTime = System.currentTimeMillis();
        for (int i = 0; i < dataSize; i++) {
            arrayList.add(i);
        }
        long arrayListInsertEndTime = System.currentTimeMillis();
        System.out.println("ArrayList 插入数据耗时：" + (arrayListInsertEndTime - arrayListInsertStartTime) + "ms");

        // LinkedList 插入数据性能测试
        List<Integer> linkedList = new LinkedList<>();
        long linkedListInsertStartTime = System.currentTimeMillis();
        for (int i = 0; i < dataSize; i++) {
            linkedList.add(i);
        }
        long linkedListInsertEndTime = System.currentTimeMillis();
        System.out.println("LinkedList 插入数据耗时：" + (linkedListInsertEndTime - linkedListInsertStartTime) + "ms");

        // ArrayList 删除数据性能测试
        long arrayListDeleteStartTime = System.currentTimeMillis();
        for (int i = dataSize - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        long arrayListDeleteEndTime = System.currentTimeMillis();
        System.out.println("ArrayList 删除数据耗时：" + (arrayListDeleteEndTime - arrayListDeleteStartTime) + "ms");

        // LinkedList 删除数据性能测试
        long linkedListDeleteStartTime = System.currentTimeMillis();
        for (int i = dataSize - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        long linkedListDeleteEndTime = System.currentTimeMillis();
        System.out.println("LinkedList 删除数据耗时：" + (linkedListDeleteEndTime - linkedListDeleteStartTime) + "ms");
    }
}

