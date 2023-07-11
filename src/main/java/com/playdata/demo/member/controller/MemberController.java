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
    public MemberResponse findById(@PathVariable("id") Integer id){
        //이거 정도는 컨트롤러에서 바꿔도 괜춘?
        //memberService에 findById -> Member, findById -> MemberResponse 따로 만들기 ?
        return MemberResponse.from(memberService.findById(id));
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
    public MemberResponse updateById(
            @PathVariable("id") Integer id,
            @RequestBody MemberRequest memberRequest){
        return MemberResponse.from(memberService.update(id, memberRequest));
    }

}
