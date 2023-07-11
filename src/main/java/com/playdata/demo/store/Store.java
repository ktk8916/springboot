package com.playdata.demo.store;

import com.playdata.demo.hobby.domain.entity.Hobby;
import com.playdata.demo.member.domain.entity.Member;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static List<Member> members = new ArrayList<>();
    public static Integer memberIndex = 0;
    public static List<Hobby> hobbies = new ArrayList<>();
    public static Integer hobbyIndex = 0;
}
