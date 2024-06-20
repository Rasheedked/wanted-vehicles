package com.example.demo.service;

import com.example.demo.entity.Impound;
import com.example.demo.entity.Vehicle;
import com.example.demo.payload.request.response.AddNewVehicle;
import com.example.demo.payload.request.response.CreateImpoundRequest;
import com.example.demo.payload.request.response.GetVehicleResponse;
import com.example.demo.repository.VehicleRepository;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VehicleService {
    @Autowired
    private  VehicleRepository vehicleRepository;

    public Long addNewVehicle(AddNewVehicle addNewVehicle) {
        Vehicle vehicle = new Vehicle(addNewVehicle.getChaseNumber(),
                addNewVehicle.getOwnerName()
                ,addNewVehicle.getMake()
                , addNewVehicle.getModel()
                ,addNewVehicle.getYear()
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

    public GetVehicleResponse getVehicleDetails(Long vehicleId)
    {
        Vehicle vehicle=vehicleRepository.findById(vehicleId).orElse(null);

        GetVehicleResponse newVehicleRequest = new GetVehicleResponse(
                vehicle.getChaseNumber(),
                vehicle.getImpoundId(),
                vehicle.getOwnerName(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getOwnershipStatus(),
                vehicle.getInsuranceExpiryDate(),
                vehicle.getWanted(),
                vehicle.getVehiclecolor(),
                vehicle.getRecordsNum(),
                vehicle.getCustomCardNum(),
                vehicle.getVehicleType(),
                vehicle.getPlateNumber(),
                vehicle.getTotalRecords()

        );
        return newVehicleRequest;

    }


    public String deleteVehicle(Long vehicleId)
    {
        boolean vehicleExists = vehicleRepository.existsById(vehicleId);
        if(vehicleExists)
        {
            vehicleRepository.deleteById(vehicleId);
            return "vehicle that has the id : " + vehicleId + " is completely deleted";
        }
        else {
            return "vehicle that has the id : " + vehicleId + " does not exist";
        }
    }
}