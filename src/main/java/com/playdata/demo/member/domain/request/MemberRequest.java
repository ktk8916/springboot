package com.playdata.demo.member.domain.request;

import com.playdata.demo.member.domain.entity.Member;

public record MemberRequest(String name, Integer age) {
    public Member toEntity(){
        return new Member(name, age);
    }
}
