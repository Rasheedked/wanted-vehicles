package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import com.example.demo.payload.request.response.AddNewVehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    private final VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository) {this.vehicleRepository = vehicleRepository;}

    public Long addNewVehicle(AddNewVehicle addNewVehicle) {
        Vehicle vehicle = new Vehicle(addNewVehicle.getChaseNumber(),
                addNewVehicle.getOwnerName()
                ,addNewVehicle.getMake()
                , addNewVehicle.getModel()
                , addNewVehicle.getOwnershipStatus()
                ,addNewVehicle.getInsuranceExpiryDate()
                ,addNewVehicle.getWanted()
                ,addNewVehicle.getVehiclecolor()
                , addNewVehicle.getRecordsNum()
                , addNewVehicle.getCustomCardNum()
                , addNewVehicle.getVehicleType()
                , addNewVehicle.getPlateNumber()
                ,addNewVehicle.getTotalRecords());
        return vehicleRepository.save(vehicle).getVehicle_id();
    }
}
