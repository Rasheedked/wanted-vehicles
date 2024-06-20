package com.example.demo.controllers;

import com.example.demo.payload.request.response.AddOwnerRequest;
import com.example.demo.payload.request.response.GetOwnerDetailsResponse;
import com.example.demo.payload.request.response.GetVehicleResponse;
import com.example.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/get/{owner_id}")
    public GetOwnerDetailsResponse getOwnerDetails(@PathVariable("owner_id") Long ownerId) {
        return ownerService.getOwnerDetails(ownerId);
    }

    @DeleteMapping(path = "/delete/{owner_Id}")
    public String deleteOwner(@PathVariable("owner_Id") Long ownerId)
    {
        return ownerService.deleteOwner(ownerId);
    }

}
