package ch.daplab.pig.func;

import org.apache.commons.lang.StringUtils;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.util.WrappedIOException;

import java.io.IOException;


/**
 * Amazing UDF expecting two arguments, and
 *
 * REGISTER /home/bperroud/udf-starter/target/udf-starter-1.0.0-SNAPSHOT.jar;
 * DEFINE testMe ch.daplab.pig.func.TestMe();
 * data = LOAD 'test_udf.txt' USING PigStorage() AS (d:chararray);
 * data = FOREACH data GENERATE
 *   d,
 *   testMe(d) as dToUpper;
 * DUMP data;
 *
 */
public class TestMe  extends EvalFunc<String> {

    @Override
    public String exec(Tuple input) throws IOException {

        if (input == null || input.size() != 1 ) {
            return null;
        }

        if (input.get(0) == null) {
            return null;
        }
        return (StringUtils.upperCase((String)input.get(0)));
    }

}
