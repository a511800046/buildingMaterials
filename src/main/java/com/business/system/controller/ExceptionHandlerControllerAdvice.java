package com.business.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

//@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    private static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

    //@ExceptionHandler(NoSuchElementException.class)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException e) {
        LOGGER.info("ExceptionHandlerControllerAdvice--handleNoSuchElementException");
        return e.getMessage();
    }

}
