package com.education.ztu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main2 {
    private static final Logger logger = LogManager.getLogger(Main2.class);

    public static void main(String[] args) {
        logger.info("Application started");
        logger.fatal("Fatal message - application might crash");
        logger.error("Error message - something went wrong");
        logger.warn("Warning message - be careful");
        logger.info("Info message - just FYI");
        logger.debug("Debug message - useful for debugging");
        logger.trace("Trace message - very detailed info");

        try {
            int result = divide(10, 2);
            logger.debug("Division result: {}", result);
        } catch (Exception e) {
            logger.error("Error occurred during division", e);
        }

        logger.info("Application finished");
    }

    private static int divide(int a, int b) {
        logger.trace("Entering divide() with a = {} and b = {}", a, b);
        if (b == 0) {
            logger.warn("Division by zero attempted!");
            throw new ArithmeticException("Cannot divide by zero");
        }
        int result = a / b;
        logger.trace("Exiting divide() with result = {}", result);
        return result;
    }
}

