# Installation
1. `mvn package`
2. Copy `presto-udf-*.jar` to `PRESTO_HOME/plugin/teradata-functions/` in all presto nodes
(copy to this directory because it has all jars we need)
3. Restart presto


# Functions
| Function              | Return Type | Argument Types | Description              | Usage                                 |
|-----------------------|-------------|----------------|--------------------------|---------------------------------------|
| first_day             | date        | date           | first day of month       | first_day(current_date)               |
| last_day              | date        | date           | last day of month        | last_day(current_date)                |
| to_datetime           | timestamp   | date, varchar  | combine the two args     | to_datetime(current_date, '23:59:59') |
| last_second           | timestamp   | date           | last second of the date  | last_second(current_date)             |
| yesterday_last_second | timestamp   |                | last second of yesterday | yesterday_last_second()               |
| yesterday             | date        |                | yesterday                | yesterday()                           |

