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

        //member, hobby에 추가하는과정이 createMemberHobby 속에 있음
        MemberHobby memberHobby = MemberHobby.createMemberHobby(member, hobby);

        Store.memberHobbies.add(memberHobby);
    }
}
