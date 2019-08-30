package com.github.archongum.presto.udf.aggregate.state;

import io.prestosql.spi.function.AccumulatorState;
import io.prestosql.spi.function.AccumulatorStateMetadata;

import java.util.Map;


@AccumulatorStateMetadata(stateSerializerClass = MapStateSerializer.class, stateFactoryClass = MapStateFactory.class)
public interface MapState extends AccumulatorState {
    Map<String, Long> getMap();

    void setMap(Map<String, Long> value);
}
