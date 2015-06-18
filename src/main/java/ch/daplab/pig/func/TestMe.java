package ch.daplab.pig.func;

import org.apache.commons.lang.StringUtils;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.util.WrappedIOException;

import java.io.IOException;


/**
 * Amazing UDF expecting two arguments, and
 *
 */
public class TestMe  extends EvalFunc<String> {

    @Override
    public String exec(Tuple input) throws IOException {

        if (input == null || input.size() != 1 ) {
            return null;
        }

        if (input.get(0) == null || input.get(1) == null) {
            return null;
        }
        return (StringUtils.upperCase((String)input.get(0)));
    }

}
