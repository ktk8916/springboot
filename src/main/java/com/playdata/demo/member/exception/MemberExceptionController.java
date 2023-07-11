package com.playdata.demo.member.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberExceptionController {
    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MemberExceptionResponse notFound(MemberNotFoundException e, HttpServletRequest request){

        return new MemberExceptionResponse(
                request.getRequestURI(),
                e.getMemberId(),
                e.getMessage());
    }

    record MemberExceptionResponse(String api, Integer id, String msg){

    }
}
