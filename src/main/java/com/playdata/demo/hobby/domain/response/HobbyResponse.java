package com.playdata.demo.hobby.domain.response;

import com.playdata.demo.hobby.domain.dto.HobbyMemberDto;
import com.playdata.demo.hobby.domain.entity.Hobby;

public record HobbyResponse(Integer id, String name, HobbyMemberDto member) {
    public static HobbyResponse from(Hobby hobby){

        return new HobbyResponse(
                hobby.getId(),
                hobby.getName(),
                HobbyMemberDto.from(hobby.getMember()));
    }
}
