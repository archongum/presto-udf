# Installation
1. `mvn clean assembly:assembly`
2. Copy `presto-udf-*-jar-with-dependencies.jar` to `${PRESTO_HOME}/plugin/custom-functions/` in all presto nodes.
(create directory if not exists)
3. Restart presto cluster


# Functions
## Scalar Functions
| Function                | Return Type | Argument Types | Description                                                                          | Usage                                 |
| ----------------------- | ----------- | -------------- | ------------------------------------------------------------------------------------ | ------------------------------------- |
| first_day               | date        | date           | first day of month                                                                   | first_day(current_date)               |
| last_day                | date        | date           | last day of month                                                                    | last_day(current_date)                |
| to_datetime             | timestamp   | date, varchar  | combine the two args                                                                 | to_datetime(current_date, '23:59:59') |
| last_second             | timestamp   | date           | last second of the date                                                              | last_second(current_date)             |
| yesterday_last_second   | timestamp   |                | last second of yesterday                                                             | yesterday_last_second()               |
| yesterday               | date        |                | yesterday                                                                            | yesterday()                           |
| array_max_count_element | T           | array(T)       | Get maximum count element (null is not counting; if has multiple return one of them) | array_max_count_element(array['1'])   |

## Aggregate Functions
| Function          | Return Type | Argument Types | Description                                                                          | Usage                   |
| ----------------- | ----------- | -------------- | ------------------------------------------------------------------------------------ | ----------------------- |
| max_count_element | VARCHAR     | array(VARCHAR) | Get maximum count element (null is not counting; if has multiple return one of them) | max_count_element(name) |
