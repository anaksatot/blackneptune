package com.blackneptune.entity;

import com.blackneptune.entityForRequestBody.TenderDetailRequestBody;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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
    @Column(name= "tender_status")
    private TenderStatus tenderStatus;
    @Transient
    private GoodCategory goodCategory;
    @Column(name= "tender_description")
    private String tenderDescription;
    @Column(name= "expected_value")
    private double expectedValue;
    @Column(name= "publishing_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date publishingDate;
    @Column(name= "closing_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date closingDate;
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
    }

    public Tender(User user, TenderStatus tenderStatus, String tenderDescription, double expectedValue, Date publishingDate, Date closingDate ) {
        this.userCustomer = user;
        this.tenderStatus = tenderStatus;
        this.tenderDescription = tenderDescription;
        this.expectedValue = expectedValue;
        this.publishingDate = publishingDate;
        this.closingDate = closingDate;
    }

    public Tender(User user, TenderStatus tenderStatus, String tenderDescription, double expectedValue, Date publishingDate, Date closingDate, Set<TenderDetail> tenderDetails) {
        this.userCustomer = user;
        this.tenderStatus = tenderStatus;
        this.tenderDescription = tenderDescription;
        this.expectedValue = expectedValue;
        this.tenderDetails = tenderDetails;
        this.publishingDate = publishingDate;
        this.closingDate = closingDate;
    }

    public int getTenderID() {
        return tenderID;
    }

    public User getUserCustomer() {
        return userCustomer;
    }

    public User getUserCustomerByID() {
        return userCustomer;
    }

    public TenderStatus getTenderStatus() {
        return tenderStatus;
    }

    public GoodCategory getGoodCategory() {
        return goodCategory;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public Date getClosingDate() {
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

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public void setTenderDescription(String tenderDescription) {
        this.tenderDescription = tenderDescription;
    }

    public void setExpectedValue(double expectedValue) {
        this.expectedValue = expectedValue;
    }

    public void setTenderDetails(Set<TenderDetail> tenderDetails) {
        this.tenderDetails = tenderDetails;
    }
}
