package com.example.demo.controllers;

import com.example.demo.payload.request.response.CreateImpoundRequest;
import com.example.demo.service.ImpoundService;
import com.example.demo.entity.Impound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/impound")

public class ImpoundController {

    @Autowired
    private final ImpoundService impoundService;
    public ImpoundController(ImpoundService impoundService) {this.impoundService = impoundService;}

    @PostMapping("/create")
    public Long createImpoundRequest(@RequestBody CreateImpoundRequest createImpoundRequest)
    {
        System.out.println("111111111111");
       return impoundService.createImpoundRequest(createImpoundRequest);

    }

}
