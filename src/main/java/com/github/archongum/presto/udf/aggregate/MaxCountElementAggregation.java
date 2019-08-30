package com.github.archongum.presto.udf.aggregate;

import com.github.archongum.presto.udf.aggregate.state.MapState;
import io.airlift.slice.Slice;
import io.airlift.slice.Slices;
import io.prestosql.spi.block.BlockBuilder;
import io.prestosql.spi.function.AggregationFunction;
import io.prestosql.spi.function.CombineFunction;
import io.prestosql.spi.function.Description;
import io.prestosql.spi.function.InputFunction;
import io.prestosql.spi.function.OutputFunction;
import io.prestosql.spi.function.SqlType;
import io.prestosql.spi.type.StandardTypes;

import java.util.Map;
import java.util.Map.Entry;

import static io.prestosql.spi.type.VarcharType.VARCHAR;


@AggregationFunction("max_count_element")
@Description("Get maximum count element (null is not counting; if has multiple return one of them)")
public class MaxCountElementAggregation
{
    @InputFunction
    public static void input(MapState state, @SqlType(StandardTypes.VARCHAR) Slice value)
    {
        String v = value.toStringUtf8();
        Map<String, Long> map = state.getMap();
        Long cnt = map.get(v);
        if (cnt == null) {
            map.put(v, 1L);
        } else {
            map.put(v, cnt+1);
        }
    }

    @CombineFunction
    public static void combine(MapState state, MapState otherState)
    {
        otherState.getMap().forEach((k, v) -> state.getMap().merge(k, v, Long::sum));
    }

    @OutputFunction(StandardTypes.VARCHAR)
    public static void output(MapState state, BlockBuilder out)
    {
        if (state.getMap().isEmpty()) {
            out.appendNull();
        } else {
            VARCHAR.writeSlice(out,
                Slices.utf8Slice(state.getMap().entrySet().stream().max(Entry.comparingByValue()).get().getKey()));
        }
    }
}
