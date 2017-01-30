package com.fiturriz.logging;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        logger.error("holy shit!");
        logger.warn("holy shit!");
        logger.info("holy shit!");
        logger.debug("holy shit!");
        logger.trace("holy shit!");


        loggerMDC();

        return ResponseEntity.ok().build();
    }



    protected void loggerMDC() throws Exception{


        ObjectMapper mapper = new ObjectMapper();

        Map<String,Object> json  = new HashMap<>();
        json.put("key1","valor1");
        json.put("key2","valor2");
        json.put("key3","valor3");

        MDC.put("unJson",mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));

        Gson gson = new GsonBuilder().create();

        MDC.put("unJson2",gson.toJson(json));

        logger.info("mdc PS");
        MDC.clear();
    }

}
