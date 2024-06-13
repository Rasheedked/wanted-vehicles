package com.example.demo.payload.request.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateImpoundRequest {


    private String impoundOrigin;
    private String impoundType;
    private String impoundAuthority;
    private String vehicleLocation;
    private LocalDate impoundDate;
    private Boolean isLinkedToReport;
    private String reportNum;

}
