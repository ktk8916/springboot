package com.playdata.demo.member.exception;

import lombok.Getter;

@Getter
public class MemberNotFoundException extends NullPointerException {

    private Integer memberId;
    public MemberNotFoundException(String s, Integer memberId) {
        super(s);
        this.memberId = memberId;
    }

}
