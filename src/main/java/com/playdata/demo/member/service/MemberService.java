package com.playdata.demo.member.service;

import com.playdata.demo.member.domain.entity.Member;
import com.playdata.demo.member.domain.request.MemberRequest;
import com.playdata.demo.member.domain.response.MemberResponse;
import com.playdata.demo.member.exception.MemberNotFoundException;
import com.playdata.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    public List<MemberResponse> findAll(){
        return Store.members
                .stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
    }

    public Member findById(Integer id){
        return Store.members
                .stream()
                .filter(m-> m.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new MemberNotFoundException("member is not exist", id));
    }

    public void save(MemberRequest memberRequest){
        Store.members.add(memberRequest.toEntity());
    }

    public void deleteById(Integer id){
        Store.members.remove(findById(id));
    }

    public Member update(Integer id, MemberRequest memberRequest) {
        Member member = findById(id);
        member.updateMember(
                memberRequest.name(),
                memberRequest.age());
        return member;
    }
}
