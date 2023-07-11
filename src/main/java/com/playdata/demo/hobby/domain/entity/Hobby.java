package com.playdata.demo.hobby.domain.entity;

import com.playdata.demo.member.domain.entity.Member;
import com.playdata.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Hobby {

    private Integer id;
    private String name;
    private Member member;

    public static Hobby createHobby(String name, Member member){
        Hobby hobby = new Hobby();
        hobby.name = name;
        hobby.member = member;
        return hobby;
    }
}
