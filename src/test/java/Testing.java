import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * Created by frankieic on 1/30/17.
 */
public class Testing {

    @Test
    public void name() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Map<String,Object> json  = new HashMap<>();
        json.put("key1","valor1");
        json.put("key2","valor2");
        json.put("key3","valor3");

        String text = mapper.writeValueAsString(json);
        System.out.println(text);


    }
}
