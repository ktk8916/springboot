package com.playdata.demo.member.domain.response;

import com.playdata.demo.hobby.domain.dto.HobbyDto;
import com.playdata.demo.member.domain.entity.Member;

import java.util.List;
import java.util.stream.Collectors;

public record MemberResponse(Integer id, String name, Integer age, List<HobbyDto> hobbies) {
    public static MemberResponse from(Member member){
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getHobbies()
                        .stream()
                        .map(HobbyDto::from)
                        .collect(Collectors.toList()));
    }
}
