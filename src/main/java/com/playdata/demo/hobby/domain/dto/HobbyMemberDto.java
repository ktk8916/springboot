package com.playdata.demo.hobby.domain.dto;

import com.playdata.demo.member.domain.entity.Member;
public record HobbyMemberDto(String name, Integer age) {
    public static HobbyMemberDto from(Member member){
        return new HobbyMemberDto(
                member.getName(),
                member.getAge());
    }
}
