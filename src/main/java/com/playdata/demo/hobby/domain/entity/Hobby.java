package com.playdata.demo.hobby.domain.entity;

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
public class Hobby {

    private Integer id;
    private String name;
    private List<MemberHobby> memberHobbies = new ArrayList<>();

    public static Hobby createHobby(String name){
        Hobby hobby = new Hobby();
        hobby.id = Store.hobbyIndex++;
        hobby.name = name;
        return hobby;
    }

}
