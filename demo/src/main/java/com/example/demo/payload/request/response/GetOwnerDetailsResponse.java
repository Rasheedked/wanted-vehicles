package com.example.demo.payload.request.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetOwnerDetailsResponse {
    private Long ownerId;
    private String nationality;
    private String transactionNo;
    private String transferTo;
    private String testResult;
    private String addressingParty;
    private String orderBook;
    private String orderType;
    private LocalDate addressingDate;
    private LocalDate orderDate;
}
