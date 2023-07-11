package com.playdata.demo.hobby.domain.dto;

import com.playdata.demo.hobby.domain.entity.Hobby;

public record HobbyDto(Integer id, String name) {
    public static HobbyDto from(Hobby hobby){
        return new HobbyDto(hobby.getId(), hobby.getName());
    }
}
