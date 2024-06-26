package com.example.demo.payload.request.response;

import com.example.demo.ENUMS.EType;
import com.example.demo.entity.Impound;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateImpoundRequest {


    private String impoundOrigin;

    public EType impoundType ;
    private String impoundAuthority;
    private String vehicleLocation;
    private LocalDate impoundDate;
    private Boolean isLinkedToReport;
    private String reportNum;

    public enum ImpoundType {
        TRAFFICALLY,
        CRIMINALLY
    }


    public EType getImpoundType() {
        return impoundType;
    }

    public void setImpoundType(EType impoundType) {
        this.impoundType = impoundType;
    }
}
