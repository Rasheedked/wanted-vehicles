package com.example.demo.controllers;

import com.example.demo.payload.request.response.AddNewVehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;


    @PostMapping("/create")
    public Long addNewVehicle(@RequestBody AddNewVehicle addNewVehicle){
        return vehicleService.addNewVehicle(addNewVehicle);
    }


}
