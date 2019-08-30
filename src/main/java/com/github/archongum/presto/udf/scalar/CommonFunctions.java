package com.github.archongum.presto.udf.scalar;

import io.airlift.slice.Slice;
import io.prestosql.spi.function.Description;
import io.prestosql.spi.function.ScalarFunction;
import io.prestosql.spi.function.SqlType;
import io.prestosql.spi.type.StandardTypes;

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
