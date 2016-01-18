Hive and Pig UDFs Starter
====

## Build it
```
mvn clean install
```

## Hive
```sql
ADD JAR /opt/udf-starter/udf-starter.jar;
 
CREATE TEMPORARY FUNCTION testMeToo AS 'ch.daplab.hive.func.TestMeToo';
 
SELECT playerID, testMeToo(playerID) FROM batting_2011 LIMIT 10;
```

## Pig

```
REGISTER /opt/udf-starter/udf-starter.jar;
 
DEFINE testMe ch.daplab.pig.func.TestMe();
 
data = LOAD 'test_udf.txt' USING PigStorage() AS (d:chararray);
 
data = FOREACH data GENERATE
  d,
  testMe(d) as dToUpper;
 
DUMP data;
```
