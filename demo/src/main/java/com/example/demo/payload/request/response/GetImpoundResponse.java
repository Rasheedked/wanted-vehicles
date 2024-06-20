package com.example.demo.payload.request.response;

import com.example.demo.ENUMS.EType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetImpoundResponse {
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
