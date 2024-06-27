package com.example.demo.controllers;

import com.example.demo.payload.request.response.AddNewVehicleRequest;
import com.example.demo.payload.request.response.CreateImpoundRequest;
import com.example.demo.payload.request.response.GetVehicleResponse;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;


    @PostMapping("/create")
    public Long addNewVehicle(@RequestBody AddNewVehicleRequest addNewVehicleRequest){
        return vehicleService.addNewVehicle(addNewVehicleRequest);
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

    @PutMapping(path="/update/{vehicle_Id}")
    public String updateStudent(@PathVariable("vehicle_Id") Long vehicleId,
                                @RequestBody AddNewVehicleRequest updateVehicleRequest)
    {
        return vehicleService.updateVehicle(vehicleId, updateVehicleRequest);

    }



}
