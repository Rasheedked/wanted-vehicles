package com.example.demo.controllers;

import com.example.demo.payload.request.response.AddNewVehicle;
import com.example.demo.payload.request.response.CreateImpoundRequest;
import com.example.demo.payload.request.response.GetVehicleResponse;
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


    @GetMapping("/get/{vehicle_id}")
    public GetVehicleResponse getVehicleDetails(@PathVariable("vehicle_id") Long vehicleId) {
        return vehicleService.getVehicleDetails(vehicleId);
    }

    @DeleteMapping(path = "/delete/{vehicle_Id}")
    public String deleteVehicle(@PathVariable("vehicle_Id") Long vehicleId)
    {
        return vehicleService.deleteVehicle(vehicleId);
    }



}
