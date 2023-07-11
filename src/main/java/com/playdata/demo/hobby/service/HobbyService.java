package com.playdata.demo.hobby.service;

import com.playdata.demo.hobby.domain.entity.Hobby;
import com.playdata.demo.hobby.domain.request.HobbyRequest;
import com.playdata.demo.hobby.domain.response.HobbyResponse;
import com.playdata.demo.member.domain.entity.Member;
import com.playdata.demo.member.service.MemberService;
import com.playdata.demo.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HobbyService {

    private final MemberService memberService;
    public List<HobbyResponse> findAll(){
        return Store.hobbies
                .stream()
                .map(HobbyResponse::from)
                .collect(Collectors.toList());
    }
    public void save(HobbyRequest hobbyRequest) {

        Member member = memberService.findById(hobbyRequest.memberId());
        Hobby hobby = Hobby.createHobby(hobbyRequest.name(), member);
        Store.hobbies.add(hobby);
        member.addHobby(hobby);
    }
}
