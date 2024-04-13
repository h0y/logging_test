package com.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public String greetingTo(String name) {
        logger.debug("greeting to '{}'", name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.warn("Interrupted while saying hello ", e);
        }
        return "Hello, " + name + "!";
    }
}
