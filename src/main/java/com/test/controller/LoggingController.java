package com.test.controller;

import com.test.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    private final LoggingService loggingService;

    public LoggingController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "World") String name) {
        logger.debug("Received request to greeting to '{}'", name);
        String result = loggingService.greetingTo(name);
        logger.info("Response with '{}'", result);
        return result;
    }
}
