package com.playdata.demo.join;

import com.playdata.demo.hobby.domain.entity.Hobby;
import com.playdata.demo.member.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberHobby {

    private Member member;
    private Hobby hobby;
}
