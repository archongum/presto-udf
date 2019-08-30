package com.github.archongum.presto.udf.scalar;

import io.airlift.slice.Slice;
import io.prestosql.spi.block.Block;
import io.prestosql.spi.function.*;
import io.prestosql.spi.type.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


@ScalarFunction("array_max_count_element")
@Description("Get maximum count element of array (null is not counting; if has multiple return one of them)")
public final class ArrayMaxCountElementFunction
{
    private ArrayMaxCountElementFunction() {}

    @TypeParameter("T")
    @SqlType("T")
    @SqlNullable
    public static Slice sliceArrayMaxCountElement(
        @TypeParameter("T") Type elementType,
        @SqlType("array(T)") Block block
    ) {
        if (block.getPositionCount() == 0) {
            return null;
        }

        Map<Slice, Long> map = new HashMap<>();

        for (int i = 0; i < block.getPositionCount(); i++) {
            if (block.isNull(i)) {
                continue;
            }
            Slice curElement = elementType.getSlice(block, i);
            Long c = map.get(curElement);
            if (c == null) {
                map.put(curElement, 1L);
            } else {
                map.put(curElement, c+1);
            }
        }

        if (map.isEmpty()) {
            return null;
        }

        return map.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
    }

    @TypeParameter("T")
    @SqlType("T")
    @SqlNullable
    public static Long longArrayMaxCountElement(
        @TypeParameter("T") Type elementType,
        @SqlType("array(T)") Block block
    ) {
        if (block.getPositionCount() == 0) {
            return null;
        }

        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < block.getPositionCount(); i++) {
            if (block.isNull(i)) {
                continue;
            }
            Long curElement = elementType.getLong(block, i);
            Long c = map.get(curElement);
            if (c == null) {
                map.put(curElement, 1L);
            } else {
                map.put(curElement, c+1);
            }
        }

        if (map.isEmpty()) {
            return null;
        }

        return map.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
    }
}
