package com.playdata.demo.member.domain.entity;

import com.playdata.demo.join.MemberHobby;
import com.playdata.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {

    private Integer id;
    private String name;
    private Integer age;
    private List<MemberHobby> memberHobbies = new ArrayList<>();

    public static Member createMember(String name, Integer age){
        Member member = new Member();
        member.id = Store.memberIndex++;
        member.name = name;
        member.age = age;
        return member;
    }

    public void updateMember(String name, Integer age){
        this.name = name;
        this.age = age;
    }

}
