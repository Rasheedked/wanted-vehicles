package com.example.demo.controllers;

import com.example.demo.payload.request.response.CreateImpoundRequest;
import com.example.demo.payload.request.response.GetImpoundResponse;
import com.example.demo.service.ImpoundService;
import com.example.demo.entity.Impound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/impound")

public class ImpoundController {

    @Autowired
    private final ImpoundService impoundService;
    public ImpoundController(ImpoundService impoundService) {this.impoundService = impoundService;}

    @PostMapping("/create")
    public Long createImpoundRequest(@RequestBody CreateImpoundRequest createImpoundRequest)
    {

       return impoundService.createImpoundRequest(createImpoundRequest);

    }

    @GetMapping("/get/{impound_id}")
    public GetImpoundResponse getImpoundDetails(@PathVariable("impound_id") Long impoundId) {
        return impoundService.getImpoundDetails(impoundId);
    }


    @DeleteMapping(path = "/delete/{impound_Id}")
    public String deleteImpound(@PathVariable("impound_Id") Long impoundId)
    {
        return impoundService.deleteImpound(impoundId);
    }



}
