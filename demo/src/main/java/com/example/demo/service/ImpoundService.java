package com.example.demo.service;

import com.example.demo.entity.Impound;
import com.example.demo.payload.request.response.CreateImpoundRequest;
import com.example.demo.repository.ImpoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpoundService {
    @Autowired
    private final ImpoundRepository impoundRepository;
    public ImpoundService(ImpoundRepository impoundRepository) {this.impoundRepository=impoundRepository;}

    public Long createImpoundRequest(CreateImpoundRequest createImpoundRequest)
    {
        Impound impound = new Impound(createImpoundRequest.getImpoundOrigin(),createImpoundRequest.getVehicleLocation(),createImpoundRequest.getImpoundAuthority(),createImpoundRequest.getImpoundDate(),createImpoundRequest.getIsLinkedToReport(),createImpoundRequest.getReportNum());
      return  impoundRepository.save(impound).getImpoundId();
    }

}