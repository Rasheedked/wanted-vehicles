package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table
public class Owner {

    @Id
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

    public Owner(Long ownerId, String nationality, String transactionNo, String transferTo, String testResult, String orderBook, String addressingParty, String orderType, LocalDate addressingDate, LocalDate orderDate) {
        this.ownerId = ownerId;
        this.nationality = nationality;
        this.transactionNo = transactionNo;
        this.transferTo = transferTo;
        this.testResult = testResult;
        this.orderBook = orderBook;
        this.addressingParty = addressingParty;
        this.orderType = orderType;
        this.addressingDate = addressingDate;
        this.orderDate = orderDate;
    }

    public Owner() {
        this.ownerId = null;
    }

    public Owner(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Owner(Long ownerId, String nationality, String transactionNo, String transferTo, String testResult) {
        this.ownerId = ownerId;
        this.nationality = nationality;
        this.transactionNo = transactionNo;
        this.transferTo = transferTo;
        this.testResult = testResult;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getTransferTo() {
        return transferTo;
    }

    public void setTransferTo(String transferTo) {
        this.transferTo = transferTo;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(String orderBook) {
        this.orderBook = orderBook;
    }

    public String getAddressingParty() {
        return addressingParty;
    }

    public void setAddressingParty(String addressingParty) {
        this.addressingParty = addressingParty;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public LocalDate getAddressingDate() {
        return addressingDate;
    }

    public void setAddressingDate(LocalDate addressingDate) {
        this.addressingDate = addressingDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
