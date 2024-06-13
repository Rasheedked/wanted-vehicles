package com.example.demo.service;

import com.example.demo.entity.Owner;
import com.example.demo.payload.request.response.AddOwner;
import com.example.demo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    private final OwnerRepository ownerRepository;
    public OwnerService(OwnerRepository ownerRepository) {this.ownerRepository = ownerRepository;}

    public Long addOwner(AddOwner addowner) {
        Owner owner = new Owner(addowner.getOwnerId()
                ,addowner.getNationality()
                , addowner.getTransactionNo()
                , addowner.getTransferTo()
                , addowner.getTestResult()
                , addowner.getOrderBook()
                ,addowner.getAddressingParty()
                , addowner.getOrderType()
                ,addowner.getAddressingDate()
                ,addowner.getOrderDate()
        );

        return ownerRepository.save(owner).getOwnerId();

    }
}
