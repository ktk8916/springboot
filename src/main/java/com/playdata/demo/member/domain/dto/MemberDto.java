package com.playdata.demo.member.domain.dto;

import com.playdata.demo.member.domain.entity.Member;
import com.playdata.demo.join.MemberHobby;

public record MemberDto(Integer id, String name, Integer age) {
    public static MemberDto from(MemberHobby memberHobby){
        Member member = memberHobby.getMember();
        return new MemberDto(
                member.getId(),
                member.getName(),
                member.getAge());
    }
}
