package com.work04;

/**
 * @author MrkWinter
 * @version 1.0
 */
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTransaction {
    public static void main(String[] args) {
        LocalDateTime targetDateTime = LocalDateTime.of(2023, 11, 20, 11, 11, 20);
        LocalDateTime startDateTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);

        long daysBetween = ChronoUnit.DAYS.between(startDateTime, targetDateTime);
        long seconds = daysBetween * 24 * 60 * 60;

        System.out.println("转换为秒数：" + seconds);
    }
}

