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
        else
        {
            return "owner that has the id : " + ownerId + " does not exist";
        }
    }


    public String updateOwner(Long ownerId, AddOwnerRequest updateOwnerRequest)
    {
        Owner owner = ownerRepository.findById(ownerId).orElse(null);

        if (owner != null) {
            if (updateOwnerRequest.getNationality() != null) {
                owner.setNationality(updateOwnerRequest.getNationality());
            }
            if (updateOwnerRequest.getTransactionNo() != null) {
                owner.setTransactionNo(updateOwnerRequest.getTransactionNo());
            }
            if (updateOwnerRequest.getTransferTo() != null) {
                owner.setTransferTo(updateOwnerRequest.getTransferTo());
            }
            if (updateOwnerRequest.getTestResult() != null) {
                owner.setTestResult(updateOwnerRequest.getTestResult());
            }
            if (updateOwnerRequest.getAddressingParty() != null) {
                owner.setAddressingParty(updateOwnerRequest.getAddressingParty());
            }
            if (updateOwnerRequest.getOrderBook() != null) {
                owner.setOrderBook(updateOwnerRequest.getOrderBook());
            }
            if (updateOwnerRequest.getOrderType() != null) {
                owner.setOrderType(updateOwnerRequest.getOrderType());
            }
            if (updateOwnerRequest.getAddressingDate() != null) {
                owner.setAddressingDate(updateOwnerRequest.getAddressingDate());
            }
            if (updateOwnerRequest.getOrderDate() != null) {
                owner.setOrderDate(updateOwnerRequest.getOrderDate());
            }

            ownerRepository.save(owner);
            return "Owner with ID: " + ownerId + " has been updated.";
        } else {
            return "Owner with ID: " + ownerId + " does not exist.";
        }

    }

}
