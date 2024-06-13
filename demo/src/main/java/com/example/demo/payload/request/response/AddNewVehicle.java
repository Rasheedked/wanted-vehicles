package com.example.demo.payload.request.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddNewVehicle {

    private Long chaseNumber;
    private String impoundId;
    private String ownerName;
    private String make;
    private String model;
    private String ownershipStatus;
    private LocalDate insuranceExpiryDate;
    private Boolean wanted;
    @Enumerated(EnumType.STRING)
    public vehicleColor vehiclecolor ;
    private int recordsNum;
    private String customCardNum;
    private String vehicleType;
    private String plateNumber;
    private Double totalRecords;

    public enum vehicleColor{
        WHITE, BLACK,GREEN, YELLOW, ORANGE, PINK, BLUE,GREY,PURPLE
    }

}
