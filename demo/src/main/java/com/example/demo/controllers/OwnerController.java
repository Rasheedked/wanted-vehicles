package com.example.demo.controllers;

import com.example.demo.payload.request.response.AddOwnerRequest;
import com.example.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/owner")
public class OwnerController {
    @Autowired
    private final OwnerService ownerService;
    public OwnerController(OwnerService ownerService) {this.ownerService = ownerService;}

    @PostMapping("/create")
    public Long addOwner(@RequestBody AddOwnerRequest addOwnerRequest) {

        return ownerService.addOwner(addOwnerRequest);
    }
}
