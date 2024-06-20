package com.example.demo.service;

import com.example.demo.entity.Owner;
import com.example.demo.entity.Vehicle;
import com.example.demo.payload.request.response.AddOwnerRequest;
import com.example.demo.payload.request.response.GetOwnerDetailsResponse;
import com.example.demo.payload.request.response.GetVehicleResponse;
import com.example.demo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    private final OwnerRepository ownerRepository;
    public OwnerService(OwnerRepository ownerRepository) {this.ownerRepository = ownerRepository;}

    public Long addOwner(AddOwnerRequest addowner) {
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


    public GetOwnerDetailsResponse getOwnerDetails(Long ownerId)
    {
        Owner owner =ownerRepository.findById(ownerId).orElse(null);

        GetOwnerDetailsResponse newOwnerRequest = new GetOwnerDetailsResponse(
                owner.getOwnerId()
                ,owner.getNationality()
                , owner.getTransactionNo()
                , owner.getTransferTo()
                , owner.getTestResult()
                , owner.getOrderBook()
                ,owner.getAddressingParty()
                , owner.getOrderType()
                ,owner.getAddressingDate()
                ,owner.getOrderDate()

        );
        return newOwnerRequest;

    }

    public String deleteOwner(Long ownerId)
    {
        boolean ownerExists = ownerRepository.existsById(ownerId);
        if(ownerExists)
        {
            ownerRepository.deleteById(ownerId);
            return "owner that has the id : " + ownerId + " is completely deleted";
        }
        else {
            return "owner that has the id : " + ownerId + " does not exist";
        }
    }

}
