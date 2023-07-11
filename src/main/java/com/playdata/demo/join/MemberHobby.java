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

    public static MemberHobby createMemberHobby(Member member, Hobby hobby){

        MemberHobby memberHobby = new MemberHobby(member, hobby);
        member.getMemberHobbies().add(memberHobby);
        hobby.getMemberHobbies().add(memberHobby);
        return memberHobby;
    }
}
