package com.playdata.demo.member.domain.entity;

import com.playdata.demo.hobby.domain.entity.Hobby;
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
    private List<Hobby> hobbies = new ArrayList<>();

    public Member(String name, Integer age) {
        this.id = Store.memberIndex++;
        this.name = name;
        this.age = age;
    }

    public void updateMember(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public void addHobby(Hobby hobby){
        hobbies.add(hobby);
    }
}
