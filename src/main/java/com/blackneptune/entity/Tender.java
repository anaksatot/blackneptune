package com.blackneptune.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Admin on 5/2/2017.
 */
@Entity
@Table
public class Tender {
    @Id
    @Column(name= "tender_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tenderID;
    @Transient
    private User userCustomer;
    @Transient
    private TenderStatus tenderStatus;
    @Transient
    private GoodCategory goodCategory;
    @Transient
    private LocalDate publishingDate;
    @Transient
    private LocalDate closingDate;
    @Column(name= "description")
    private String tenderDescription;
    @Transient
    private double expectantValue;
    @Transient
    private Set<TenderDetail> tenderDetails;

    public Tender() {
    }

    public Tender(String tenderDescription) {
        this.tenderDescription = tenderDescription;
    }

    public int getTenderID() {
        return tenderID;
    }

    public User getUserCustomer() {
        return userCustomer;
    }

    public TenderStatus getTenderStatus() {
        return tenderStatus;
    }

    public GoodCategory getGoodCategory() {
        return goodCategory;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public String getTenderDescription() {
        return tenderDescription;
    }

    public double getExpectantValue() {
        return expectantValue;
    }

    public Set<TenderDetail> getTenderDetails() {
        return tenderDetails;
    }

    public void setTenderID(int tenderID) {
        this.tenderID = tenderID;
    }

    public void setUserCustomer(User userCustomer) {
        this.userCustomer = userCustomer;
    }

    public void setTenderStatus(TenderStatus tenderStatus) {
        this.tenderStatus = tenderStatus;
    }

    public void setGoodCategory(GoodCategory goodCategory) {
        this.goodCategory = goodCategory;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public void setTenderDescription(String tenderDescription) {
        this.tenderDescription = tenderDescription;
    }

    public void setExpectantValue(double expectantValue) {
        this.expectantValue = expectantValue;
    }

    public void setTenderDetails(Set<TenderDetail> tenderDetails) {
        this.tenderDetails = tenderDetails;
    }
}
