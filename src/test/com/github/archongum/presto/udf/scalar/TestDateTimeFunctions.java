package com.github.archongum.presto.udf.scalar;

import org.junit.jupiter.api.Test;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


/**
 * @author Archon  2018/9/20
 * @since
 */
class TestDateTimeFunctions {

    @Test
    void testLastDay() {
        long millis = System.currentTimeMillis();
        System.out.println(DateTimeFunctions.lastDay(DateTimeUtils.toDays(millis)));
        System.out.println(MILLISECONDS.toDays(millis));
    }

    @Test
    void testToDatetime() {
        long millis = System.currentTimeMillis();
        long d1 = DateTimeUtils.toLocalDateTime(millis).toLocalDate().toEpochDay();
        System.out.println(d1);
        System.out.println(millis/86400000);
    }

    @Test
    void testLastSecond() {
        long millis = System.currentTimeMillis();
        System.out.println(DateTimeFunctions.lastSecond(millis/86400000));
    }

    @Test
    void testYesterdayLastSecond() {
        System.out.println(DateTimeFunctions.yesterdayLastSecond());
    }

    @Test
    void testYesterday() {
        System.out.println(DateTimeFunctions.yesterday());
    }
}
