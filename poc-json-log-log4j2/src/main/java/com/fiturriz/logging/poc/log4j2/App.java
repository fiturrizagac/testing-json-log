package com.fiturriz.logging.poc.log4j2;

import static com.fiturriz.logging.poc.log4j2.model.FiturrizLogEvent.LOG_DATA;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiturriz.logging.poc.log4j2.model.Data;
import com.fiturriz.logging.poc.log4j2.model.Event;
import com.fiturriz.logging.poc.log4j2.model.LogData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by frankieic on 1/15/17.
 */
@SpringBootApplication
@RequestMapping
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping("/test")
    public ResponseEntity method() throws Exception {
        logger.error("holy error!");
        logger.warn("holy warn!");
        logger.info("holy info!");
        logger.debug("holy debug!");
        logger.trace("holy trace!");


        loggerMDC();

        return ResponseEntity.ok().build();
    }



    protected void loggerMDC() throws Exception{

        ObjectMapper mapper = new ObjectMapper();

//        Map<String,Object> json  = new HashMap<>();
//        json.put("key1","valor1");
//        json.put("key2","valor2");
//        json.put("key3","valor3");
//
//        MDC.put("unJson",mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
//
//        Gson gson = new GsonBuilder().create();
//
//        MDC.put("unJson2",gson.toJson(json));

        // test
        Event event = new Event("TRANSFER",new Date().getTime());
        Data data = new Data(50.10, "+51123456789","+51987654321");
        LogData logData = new LogData(event,data);

        MDC.put(LOG_DATA,mapper.writeValueAsString(logData));


        logger.info("Testing POC layout");
        MDC.clear();

    }

}
