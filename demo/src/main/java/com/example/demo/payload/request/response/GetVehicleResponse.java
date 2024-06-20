package com.example.demo.payload.request.response;

import com.example.demo.ENUMS.EColor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetVehicleResponse {
    private String chaseNumber;
    private String impoundId;
    private String ownerName;
    private String make;
    private String model;
    private int year;
    private String ownershipStatus;
    private LocalDate insuranceExpiryDate;
    private Boolean wanted;
    public EColor vehiclecolor ;
    private int recordsNum;
    private String customCardNum;
    private String vehicleType;
    private String plateNumber;
    private Double totalRecords;
}
