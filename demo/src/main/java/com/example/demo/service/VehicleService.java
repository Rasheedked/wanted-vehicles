package com.example.demo.service;

import com.example.demo.ENUMS.EColor;
import com.example.demo.entity.Impound;
import com.example.demo.entity.Vehicle;
import com.example.demo.payload.request.response.AddNewVehicleRequest;
import com.example.demo.payload.request.response.GetVehicleResponse;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VehicleService {
    @Autowired
    private  VehicleRepository vehicleRepository;

    public Long addNewVehicle(AddNewVehicleRequest addNewVehicleRequest) {
        Vehicle vehicle = new Vehicle(addNewVehicleRequest.getChaseNumber(),
                addNewVehicleRequest.getOwnerName()
                , addNewVehicleRequest.getMake()
                , addNewVehicleRequest.getModel()
                , addNewVehicleRequest.getYear()
                , addNewVehicleRequest.getOwnershipStatus()
                , addNewVehicleRequest.getInsuranceExpiryDate()
                , addNewVehicleRequest.getWanted()
                , addNewVehicleRequest.getVehiclecolor()
                , addNewVehicleRequest.getRecordsNum()
                , addNewVehicleRequest.getCustomCardNum()
                , addNewVehicleRequest.getVehicleType()
                , addNewVehicleRequest.getPlateNumber()
                , addNewVehicleRequest.getTotalRecords());
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

    public String updateVehicle(Long vehicleId,AddNewVehicleRequest updateVehicleRequest)
    {
        Vehicle vehicle=vehicleRepository.findById(vehicleId).orElse(null);
        if(vehicle!=null)
        {

            if (updateVehicleRequest.getChaseNumber() != null && !updateVehicleRequest.getChaseNumber().isEmpty()) {
                vehicle.setChaseNumber(updateVehicleRequest.getChaseNumber());
            }
            if (updateVehicleRequest.getImpoundId() != null && !updateVehicleRequest.getImpoundId().isEmpty()) {
                vehicle.setImpoundId(updateVehicleRequest.getImpoundId());
            }
            if (updateVehicleRequest.getOwnerName() != null && !updateVehicleRequest.getOwnerName().isEmpty()) {
                vehicle.setOwnerName(updateVehicleRequest.getOwnerName());
            }
            if (updateVehicleRequest.getMake() != null && !updateVehicleRequest.getMake().isEmpty()) {
                vehicle.setMake(updateVehicleRequest.getMake());
            }
            if (updateVehicleRequest.getModel() != null && !updateVehicleRequest.getModel().isEmpty()) {
                vehicle.setModel(updateVehicleRequest.getModel());
            }
            if (updateVehicleRequest.getYear() != 0) {
                vehicle.setYear(updateVehicleRequest.getYear());
            }
            if (updateVehicleRequest.getOwnershipStatus() != null && !updateVehicleRequest.getOwnershipStatus().isEmpty()) {
                vehicle.setOwnershipStatus(updateVehicleRequest.getOwnershipStatus());
            }
            if (updateVehicleRequest.getInsuranceExpiryDate() != null) {
                vehicle.setInsuranceExpiryDate(updateVehicleRequest.getInsuranceExpiryDate());
            }
            if (updateVehicleRequest.getWanted() != null) {
                vehicle.setWanted(updateVehicleRequest.getWanted());
            }
            if (updateVehicleRequest.getVehiclecolor() != null) {
                vehicle.setVehiclecolor(updateVehicleRequest.getVehiclecolor());
            }
            if (updateVehicleRequest.getRecordsNum() != 0) {
                vehicle.setRecordsNum(updateVehicleRequest.getRecordsNum());
            }
            if (updateVehicleRequest.getCustomCardNum() != null && !updateVehicleRequest.getCustomCardNum().isEmpty()) {
                vehicle.setCustomCardNum(updateVehicleRequest.getCustomCardNum());
            }
            if (updateVehicleRequest.getVehicleType() != null && !updateVehicleRequest.getVehicleType().isEmpty()) {
                vehicle.setVehicleType(updateVehicleRequest.getVehicleType());
            }
            if (updateVehicleRequest.getPlateNumber() != null && !updateVehicleRequest.getPlateNumber().isEmpty()) {
                vehicle.setPlateNumber(updateVehicleRequest.getPlateNumber());
            }
            if (updateVehicleRequest.getTotalRecords() != null) {
                vehicle.setTotalRecords(updateVehicleRequest.getTotalRecords());
            }
            vehicleRepository.save(vehicle);
            return "Vehicle with id : " + vehicleId + " has been updated";

        }
        else
        {
            return "Vehicle with id : " + vehicleId + " does not exist";
        }

    }


}