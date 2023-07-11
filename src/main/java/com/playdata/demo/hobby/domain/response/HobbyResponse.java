package com.playdata.demo.hobby.domain.response;

import com.playdata.demo.member.domain.dto.MemberDto;
import com.playdata.demo.hobby.domain.entity.Hobby;

import java.util.List;
import java.util.stream.Collectors;

public record HobbyResponse(Integer id, String name, List<MemberDto> member) {
    public static HobbyResponse from(Hobby hobby){

        return new HobbyResponse(
                hobby.getId(),
                hobby.getName(),
                hobby.getMemberHobbies()
                        .stream()
                        .map(MemberDto::from)
                        .collect(Collectors.toList()));
    }
}
