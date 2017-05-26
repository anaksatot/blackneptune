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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User userCustomer;
    @Transient
    private TenderStatus tenderStatus;
    @Transient
    private GoodCategory goodCategory;
    @Column(name= "publishing_date")
    private LocalDate publishingDate;
    @Column(name= "closing_date")
    private LocalDate closingDate;
    @Column(name= "tender_description")
    private String tenderDescription;
    @Column(name= "expected_value")
    private double expectedValue;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "tender")
    private Set<TenderDetail> tenderDetails;

    public Tender() {
    }

    public Tender(String tenderDescription) {
        this.tenderDescription = tenderDescription;
    }

    public Tender(User user, String tenderDescription, double expectedValue) {
        this.tenderDescription = tenderDescription;
        this.expectedValue = expectedValue;
        this.userCustomer = user;
    }

    public Tender(String tenderDescription, double expectedValue, Set<TenderDetail> tenderDetails) {
        this.tenderDescription = tenderDescription;
        this.expectedValue = expectedValue;
        this.tenderDetails = tenderDetails;
        System.out.println(tenderDetails.toString());
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

    public double getTenderExpectedValue() {
        return expectedValue;
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

    public void setTenderExpectedValue(double expectantValue) {
        this.expectedValue = expectantValue;
    }

    public void setTenderDetails(Set<TenderDetail> tenderDetails) {
        this.tenderDetails = tenderDetails;
    }
}
