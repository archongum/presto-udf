/*
 * Copyright 2013-2016 Qubole
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.archongum.presto;

import com.github.archongum.presto.udf.aggregate.MaxCountElementAggregation;
import com.github.archongum.presto.udf.scalar.ArrayMaxCountElementFunction;
import com.github.archongum.presto.udf.scalar.CommonFunctions;
import com.github.archongum.presto.udf.scalar.DateTimeFunctions;
import io.prestosql.spi.Plugin;

import java.util.HashSet;
import java.util.Set;


public class UdfPlugin implements Plugin
{
    @Override
    public Set<Class<?>> getFunctions()
    {
        Set<Class<?>> set = new HashSet<>();
        set.add(ArrayMaxCountElementFunction.class);
        set.add(CommonFunctions.class);
        set.add(DateTimeFunctions.class);
        set.add(MaxCountElementAggregation.class);
        return set;
    }
}
