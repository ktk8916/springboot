package com.playdata.demo.hobby.controller;

import com.playdata.demo.hobby.service.HobbyService;
import com.playdata.demo.hobby.domain.request.HobbyRequest;
import com.playdata.demo.hobby.domain.response.HobbyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hobbies")
public class HobbyController {

    private final HobbyService hobbyService;

    @GetMapping
    public List<HobbyResponse> findAll(){
        return hobbyService.findAll();
    }
    @PostMapping
    public void save(@RequestBody HobbyRequest hobbyRequest){
        hobbyService.save(hobbyRequest);
    }
}
