package com.example.demo.entity;

import com.example.demo.ENUMS.EType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Impound {

    @Id
    @SequenceGenerator(
            name="impound_sequence",
            sequenceName = "impound_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "impound_sequence"
    )
    private Long impoundId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private String impoundOrigin;
    @Enumerated(EnumType.STRING)
    public EType impoundType ;
    private String impoundAuthority;
    private String vehicleLocation;
    private LocalDate impoundDate;
    private Boolean isLinkedToReport;
    private String reportNum;


    public Impound(Long impoundId, Vehicle vehicle, String impoundOrigin, EType impoundType, String impoundAuthority, String vehicleLocation, LocalDate impoundDate, Boolean isLinkedToReport, String reportNum) {
        this.impoundId = impoundId;
        this.vehicle = vehicle;
        this.impoundOrigin = impoundOrigin;
        this.impoundType = impoundType;
        this.impoundAuthority = impoundAuthority;
        this.vehicleLocation = vehicleLocation;
        this.impoundDate = impoundDate;
        this.isLinkedToReport = isLinkedToReport;
        this.reportNum = reportNum;
    }

    public Impound(String impoundOrigin,EType impoundtype ,String vehiclelocation, String impoundAuthority, LocalDate impoundDate, Boolean isLinkedToReport, String reportNum) {
        this.impoundOrigin = impoundOrigin;
        this.impoundType = impoundtype;
        this.vehicleLocation = vehiclelocation;
        this.impoundAuthority = impoundAuthority;
        this.impoundDate = impoundDate;
        this.isLinkedToReport = isLinkedToReport;
        this.reportNum = reportNum;
    }



    public Impound(Long impoundId) {
        this.impoundId = impoundId;
    }

    public Impound(Long impoundId, String impoundOrigin, Boolean isLinkedToReport, String reportNum) {
        this.impoundId = impoundId;
        this.impoundOrigin = impoundOrigin;
        this.isLinkedToReport = isLinkedToReport;
        this.reportNum = reportNum;
    }

    public Impound() {
        this.impoundOrigin="inside";
        this.isLinkedToReport=false;
        this.reportNum=null;
        this.impoundType=impoundType.TRAFFICALLY;
        this.impoundAuthority="UAE";
        this.impoundDate=LocalDate.now();
    }

    public Long getImpoundId() {
        return impoundId;
    }

    public void setImpoundId(Long impoundId) {
        this.impoundId = impoundId;
    }

    public String getImpoundAuthority() {
        return impoundAuthority;
    }

    public void setImpoundAuthority(String impoundAuthority) {
        this.impoundAuthority = impoundAuthority;
    }

    public String getImpoundOrigin() {
        return impoundOrigin;
    }

    public void setImpoundOrigin(String impoundOrigin) {
        this.impoundOrigin = impoundOrigin;
    }

    public String getVehicleLocation() {
        return vehicleLocation;
    }

    public void setVehicleLocation(String vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

    public LocalDate getImpoundDate() {
        return impoundDate;
    }

    public void setImpoundDate(LocalDate impoundDate) {
        this.impoundDate = impoundDate;
    }

    public Boolean getLinkedToReport() {
        return isLinkedToReport;
    }

    public void setLinkedToReport(Boolean linkedToReport) {
        isLinkedToReport = linkedToReport;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public EType getImpoundType() {
        return impoundType;
    }

    public void setImpoundType(EType impoundType) {
        this.impoundType = impoundType;
    }

}
