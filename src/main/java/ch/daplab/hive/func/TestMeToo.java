package ch.daplab.hive.func;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by bperroud on 18-Jun-15.
 *
 * ADD JAR /home/bperroud/udf-starter/target/udf-starter-1.0.0-SNAPSHOT.jar;
 * CREATE TEMPORARY FUNCTION testMeToo AS 'ch.daplab.hive.func.TestMeToo';
 * SELECT playerID, testMeToo(playerID) FROM batting_2011 LIMIT 10;
 */
@Description(name = "testMeFunction", value = "_FUNC_(domain) - Test function don't do anything smart")
public class TestMeToo extends UDF {

    public String evaluate(String domain) {
        if (domain == null ) {
            return null;
        }

        return StringUtils.upperCase(domain);
    }
}
