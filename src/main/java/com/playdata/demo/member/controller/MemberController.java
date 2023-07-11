package com.playdata.demo.member.controller;

import com.playdata.demo.member.service.MemberService;
import com.playdata.demo.member.domain.entity.Member;
import com.playdata.demo.member.domain.request.MemberRequest;
import com.playdata.demo.member.domain.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public List<MemberResponse> findAll(){
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable("id") Integer id){
        return memberService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MemberRequest memberRequest){
        memberService.save(memberRequest);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id){
        memberService.deleteById(id);
    }

    @PutMapping("{id}")
    public Member updateById(
            @PathVariable("id") Integer id,
            @RequestBody MemberRequest memberRequest){
        return memberService.update(id, memberRequest);
    }

}
