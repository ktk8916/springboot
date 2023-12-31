package com.playdata.demo.hobby.service;

import com.playdata.demo.hobby.domain.entity.Hobby;
import com.playdata.demo.hobby.domain.request.HobbyRequest;
import com.playdata.demo.hobby.domain.response.HobbyResponse;
import com.playdata.demo.member.domain.entity.Member;
import com.playdata.demo.member.exception.MemberNotFoundException;
import com.playdata.demo.member.service.MemberService;
import com.playdata.demo.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HobbyService {

    private final MemberService memberService;
    public Hobby findById(Integer id){
        return Store.hobbies
                .stream()
                .filter(m-> m.getId().equals(id))
                .findFirst()
                .orElse(null);

    }
    public List<HobbyResponse> findAll(){
        return Store.hobbies
                .stream()
                .map(HobbyResponse::from)
                .collect(Collectors.toList());
    }

    public void save(HobbyRequest hobbyRequest) {

        Hobby hobby = Hobby.createHobby(hobbyRequest.name());
        Store.hobbies.add(hobby);
    }

    public List<HobbyResponse> findByName(String name){
        return Store.hobbies
                .stream()
                .filter(hobby -> hobby.getName().contains(name))
                .map(HobbyResponse::from)
                .collect(Collectors.toList());
    }

    public List<HobbyResponse> searchHobbies(String name) {
        if(name==null){
            return findAll();
        } else {
            return findByName(name);
        }
    }
}
