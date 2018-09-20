package com.archon.presto.udf.scalar;

import org.junit.Test;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


/**
 * @author Archon  2018/9/20
 * @since
 */
public class DateTimeFunctionsTest {

    @Test
    public void lastDay() {
        long millis = System.currentTimeMillis();
        System.out.println(DateTimeFunctions.lastDay(DateTimeUtils.toDays(millis)));
        System.out.println(MILLISECONDS.toDays(millis));
    }

    @Test
    public void toDatetime() {
        long millis = System.currentTimeMillis();
        long d1 = DateTimeUtils.toLocalDateTime(millis).toLocalDate().toEpochDay();
        System.out.println(d1);
        System.out.println(millis/86400000);
    }

    @Test
    public void lastSecond() {
        long millis = System.currentTimeMillis();
        System.out.println(DateTimeFunctions.lastSecond(millis/86400000));
    }

    @Test
    public void yesterdayLastSecond() {
        System.out.println(DateTimeFunctions.yesterdayLastSecond());
    }

    @Test
    public void yesterday() {
        System.out.println(DateTimeFunctions.yesterday());
    }
}
