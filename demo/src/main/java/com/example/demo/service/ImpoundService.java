package com.example.demo.service;

import com.example.demo.ENUMS.EType;
import com.example.demo.entity.Impound;
import com.example.demo.payload.request.response.CreateImpoundRequest;
import com.example.demo.payload.request.response.GetImpoundResponse;
import com.example.demo.repository.ImpoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ImpoundService {
    @Autowired
    private final ImpoundRepository impoundRepository;
    public ImpoundService(ImpoundRepository impoundRepository) {this.impoundRepository=impoundRepository;}

    public Long createImpoundRequest(CreateImpoundRequest createImpoundRequest)
    {
        Impound impound = new Impound(createImpoundRequest.getImpoundOrigin(),createImpoundRequest.getImpoundType(),createImpoundRequest.getVehicleLocation(),createImpoundRequest.getImpoundAuthority(),createImpoundRequest.getImpoundDate(),createImpoundRequest.getIsLinkedToReport(),createImpoundRequest.getReportNum());
      return  impoundRepository.save(impound).getImpoundId();
    }

    public GetImpoundResponse getImpoundDetails(Long impoundId)
    {
        Impound impound=impoundRepository.findById(impoundId).orElse(null);

        GetImpoundResponse newImpoundRequest = new GetImpoundResponse(
               impound.getImpoundOrigin(),
                impound.getImpoundType(),
                impound.getImpoundAuthority(),
                impound.getVehicleLocation(),
                impound.getImpoundDate(),
                impound.getLinkedToReport(),
                impound.getReportNum()
                );
        return newImpoundRequest;

    }

    public String deleteImpound(Long impoundId)
    {
        boolean impoundExists = impoundRepository.existsById(impoundId);
        if(impoundExists)
        {
            impoundRepository.deleteById(impoundId);
            return "Impound that has the id : " + impoundId + " is completely deleted";
        }
        else {
            return "Impound that has the id : " + impoundId + " does not exist";
        }
    }

    public String updateImpound(Long impoundId, CreateImpoundRequest updateRequest)
    {
        Impound impound=impoundRepository.findById(impoundId).orElse(null);
        if(impound!=null)
        {

            if (updateRequest.getImpoundOrigin() != null && !updateRequest.getImpoundOrigin().isEmpty()) {
                impound.setImpoundOrigin(updateRequest.getImpoundOrigin());
            }
            if (updateRequest.getImpoundType() != null) {
                impound.setImpoundType(updateRequest.getImpoundType());
            }
            if (updateRequest.getImpoundAuthority() != null && !updateRequest.getImpoundAuthority().isEmpty()) {
                impound.setImpoundAuthority(updateRequest.getImpoundAuthority());
            }
            if (updateRequest.getVehicleLocation() != null && !updateRequest.getVehicleLocation().isEmpty()) {
                impound.setVehicleLocation(updateRequest.getVehicleLocation());
            }
            if (updateRequest.getImpoundDate() != null) {
                impound.setImpoundDate(updateRequest.getImpoundDate());
            }
            if (updateRequest.getIsLinkedToReport() != null) {
                impound.setLinkedToReport(updateRequest.getIsLinkedToReport());
            }
            if (updateRequest.getReportNum() != null && !updateRequest.getReportNum().isEmpty()) {
                impound.setReportNum(updateRequest.getReportNum());
            }
            impoundRepository.save(impound);
            return "Impound with id : " + impoundId + " has been updated";

        }
        else
        {
            return "Impound with id : " + impoundId + " does not exist";
        }

    }

}
