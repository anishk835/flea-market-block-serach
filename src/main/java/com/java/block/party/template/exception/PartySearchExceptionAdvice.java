package com.java.block.party.template.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PartySearchExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(BlockPartySearchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String sortOrderFieldNotFound(BlockPartySearchException ex) {
        return ex.getMessage();
    }
}
