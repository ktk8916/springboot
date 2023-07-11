package com.playdata.demo.join;

import com.playdata.demo.hobby.domain.entity.Hobby;
import com.playdata.demo.hobby.service.HobbyService;
import com.playdata.demo.member.domain.entity.Member;
import com.playdata.demo.member.service.MemberService;
import com.playdata.demo.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberService memberService;
    private final HobbyService hobbyService;

    public void join(JoinRequest joinRequest){

        Member member = memberService.findById(joinRequest.memberId());
        Hobby hobby = hobbyService.findById(joinRequest.hobbyId());

        MemberHobby memberHobby = new MemberHobby(member, hobby);

        //주인이 바꾸면 될듯
        member.addMemberHobby(memberHobby);
        hobby.addMemberHobby(memberHobby);

        Store.memberHobbies.add(memberHobby);
    }
}
