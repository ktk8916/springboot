package com.playdata.demo.hobby.exception;

public class HobbyNotFoundException extends NullPointerException{

    private final Integer hobbyId;
    public HobbyNotFoundException(String s, Integer hobbyId) {
        super(s);
        this.hobbyId = hobbyId;
    }
}
