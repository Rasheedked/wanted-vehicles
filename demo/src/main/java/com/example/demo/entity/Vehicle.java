package com.example.demo.entity;

import com.example.demo.ENUMS.EColor;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Vehicle {
    @Id
    @SequenceGenerator(
            name="vehicle_sequence",
            sequenceName = "vehicle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicle_sequence"
    )
    private Long vehicle_id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    private String chaseNumber;
    private String impoundId;
    private String ownerName;
    private String make;
    private String model;
    private int year;
    private String ownershipStatus;
    private LocalDate insuranceExpiryDate;
    private Boolean wanted;
    @Enumerated(EnumType.STRING)
    public EColor vehiclecolor;
    private int recordsNum;
    private String customCardNum;
    private String vehicleType;
    private String plateNumber;
    private Double totalRecords;

    public Vehicle(String chaseNumber, String ownerName, String make, String model,int year, String ownershipStatus, LocalDate insuranceExpiryDate, Boolean wanted,  EColor vehiclecolor, int recordsNum, String customCardNum, String vehicleType, String plateNumber, Double totalRecords) {
        this.chaseNumber = chaseNumber;
        this.ownerName = ownerName;
        this.make = make;
        this.model = model;
        this.year = year;
        this.ownershipStatus = ownershipStatus;
        this.insuranceExpiryDate = insuranceExpiryDate;
        this.wanted = wanted;
        this.vehiclecolor = vehiclecolor;
        this.recordsNum = recordsNum;
        this.customCardNum = customCardNum;
        this.vehicleType = vehicleType;
        this.plateNumber = plateNumber;
        this.totalRecords = totalRecords;
    }
    public Vehicle() {}

    public Vehicle(String chaseNumber, String impoundId, Boolean wanted) {
        this.chaseNumber = chaseNumber;
        this.impoundId = impoundId;
        this.wanted = wanted;
    }



    public Vehicle(String chaseNumber, String plateNumber) {
        this.chaseNumber = chaseNumber;
        this.plateNumber = plateNumber;
    }

    public Long getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Long vehicle_id) {
        this.vehicle_id = vehicle_id;
    }


    public String getChaseNumber() {
        return chaseNumber;
    }
    public void setChaseNumber(String chaseNumber) {
        this.chaseNumber = chaseNumber;
    }

    public String getImpoundId() {
        return impoundId;
    }
    public void setImpoundId(String impoundId) {
        this.impoundId = impoundId;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getOwnershipStatus() {
        return ownershipStatus;
    }

    public LocalDate getInsuranceExpiryDate() {
        return insuranceExpiryDate;
    }

    public Boolean getWanted() {
        return wanted;
    }

    public int getRecordsNum() {
        return recordsNum;
    }

    public String getCustomCardNum() {
        return customCardNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Double getTotalRecords() {
        return totalRecords;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOwnershipStatus(String ownershipStatus) {
        this.ownershipStatus = ownershipStatus;
    }

    public void setInsuranceExpiryDate(LocalDate insuranceExpiryDate) {
        this.insuranceExpiryDate = insuranceExpiryDate;
    }

    public void setWanted(Boolean wanted) {
        this.wanted = wanted;
    }

    public void setRecordsNum(int recordsNum) {
        this.recordsNum = recordsNum;
    }

    public void setCustomCardNum(String customCardNum) {
        this.customCardNum = customCardNum;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setTotalRecords(Double totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public EColor getVehiclecolor() {
        return vehiclecolor;
    }

    public void setVehiclecolor(EColor vehiclecolor) {
        this.vehiclecolor = vehiclecolor;
    }


}
