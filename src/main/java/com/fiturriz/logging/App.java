package com.fiturriz.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public ResponseEntity method() {
        logger.error("holy shit!");
        logger.warn("holy shit!");
        logger.info("holy shit!");
        logger.debug("holy shit!");
        logger.trace("holy shit!");
        return ResponseEntity.ok().build();
    }

}
