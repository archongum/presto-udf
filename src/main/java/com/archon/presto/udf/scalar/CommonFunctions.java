package com.archon.presto.udf.scalar;

import com.facebook.presto.spi.function.Description;
import com.facebook.presto.spi.function.ScalarFunction;
import com.facebook.presto.spi.function.SqlType;
import com.facebook.presto.spi.type.StandardTypes;
import io.airlift.slice.Slice;

import java.util.Random;


/**
 * @author Archon  2018/9/20
 * @since
 */
public class CommonFunctions {

    @Description("rand(String seed)")
    @ScalarFunction("rand")
    @SqlType(StandardTypes.DOUBLE)
    public static double randomWithSeed(@SqlType(StandardTypes.VARCHAR) Slice seed)
    {
        return new Random(seed.toStringUtf8().hashCode()).nextDouble();
    }
}
