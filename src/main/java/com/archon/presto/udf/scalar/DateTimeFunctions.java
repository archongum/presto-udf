package com.archon.presto.udf.scalar;

import com.facebook.presto.spi.function.Description;
import com.facebook.presto.spi.function.ScalarFunction;
import com.facebook.presto.spi.function.SqlType;
import com.facebook.presto.spi.type.StandardTypes;
import io.airlift.slice.Slice;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.archon.presto.udf.scalar.DateTimeUtils.OFFSET_MILLIS;
import static java.util.concurrent.TimeUnit.DAYS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;


/**
 * @author Archon  2018/9/20
 * @since
 */
public class DateTimeFunctions {

    @Description("last day of month")
    @ScalarFunction("last_day")
    @SqlType(StandardTypes.DATE)
    public static long lastDay(@SqlType(StandardTypes.DATE) long days) {
        return DateTimeUtils.lastDayOfMonth((int) days).toEpochDay();
    }

    @Description("first day of month")
    @ScalarFunction("first_day")
    @SqlType(StandardTypes.DATE)
    public static long firstDay(@SqlType(StandardTypes.DATE) long days) {
        return DateTimeUtils.firstDayOfMonth((int) days).toEpochDay();
    }

    @Description("to timestamp")
    @ScalarFunction("to_datetime")
    @SqlType(StandardTypes.TIMESTAMP)
    public static long toDatetime(@SqlType(StandardTypes.DATE) long days, @SqlType(StandardTypes.VARCHAR) Slice time) {
        return DateTimeUtils.toMillis(DateTimeUtils.toLocalDateTime(LocalDate.ofEpochDay(days), time.toStringUtf8()));
    }

    @Description("last second of the date")
    @ScalarFunction("last_second")
    @SqlType(StandardTypes.TIMESTAMP)
    public static long lastSecond(@SqlType(StandardTypes.DATE) long days) {
        return DateTimeUtils.toMillis(LocalDateTime.of(DateTimeUtils.toLocalDate((int) days), DateTimeUtils.LAST_SECOND));
    }

    @Description("yesterday")
    @ScalarFunction("yesterday")
    @SqlType(StandardTypes.DATE)
    public static long yesterday() {
        return MILLISECONDS.toDays(System.currentTimeMillis()) - 1;
    }

    @Description("yesterday last second")
    @ScalarFunction("yesterday_last_second")
    @SqlType(StandardTypes.TIMESTAMP)
    public static long yesterdayLastSecond() {
        return DAYS.toMillis(MILLISECONDS.toDays(System.currentTimeMillis())) - OFFSET_MILLIS - 1000;
    }
}
