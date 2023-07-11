package com.playdata.demo.hobby.domain.dto;

import com.playdata.demo.hobby.domain.entity.Hobby;
import com.playdata.demo.join.MemberHobby;

public record HobbyDto(Integer id, String name) {
    public static HobbyDto from(MemberHobby memberHobby){
        Hobby hobby = memberHobby.getHobby();
        return new HobbyDto(hobby.getId(), hobby.getName());
    }
}
