package com.work04;

/**
 * @author MrkWinter
 * @version 1.0
 */
import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeTransaction {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        Date currentDate = new Date(currentTimeMillis);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String formattedDate = sdf.format(currentDate);

        System.out.println("转换后的时间：" + formattedDate);
    }
}
