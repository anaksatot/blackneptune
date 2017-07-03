package com.blackneptune.entityForRequestBody;

import com.blackneptune.entity.TenderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * Created by Admin on 6/28/2017.
 */
public class TenderRequestBody {
    private int userCustomerID;
    private TenderStatus tenderStatus;
    private int goodCategoryID;
    private Date publishingDate;
    private Date closingDate;
    private String tenderDescription;
    private double expectedValue;
    private Set<TenderDetailRequestBody> tenderDetailRequestBodies;

    public TenderRequestBody() {
    }

    public void setUserCustomerID(int userCustomerID) {
        this.userCustomerID = userCustomerID;
    }

    public void setTenderStatusID(String tenderStatus) {
        this.tenderStatus =  TenderStatus.valueOf(tenderStatus);
    }

    public void setGoodCategoryID(int goodCategoryID) {
        this.goodCategoryID = goodCategoryID;
    }

    public void setTenderDescription(String tenderDescription) {
        this.tenderDescription = tenderDescription;
    }

    public void setExpectedValue(double expectedValue) {
        this.expectedValue = expectedValue;
    }

    public void setPublishingDate(String publishingDateString) throws ParseException {
        this.publishingDate = dateFromString(publishingDateString);
    }

    public void setClosingDate(String closingDateString) throws ParseException {
        this.closingDate = dateFromString(closingDateString);
    }

    public void setTenderDetailRequestBodies(Set<TenderDetailRequestBody> tenderDetailRequestBodies) {
        this.tenderDetailRequestBodies = tenderDetailRequestBodies;
    }

    public int getUserCustomerID() {
        return userCustomerID;
    }

    public TenderStatus getTenderStatus() {
        return tenderStatus;
    }

    public int getGoodCategoryID() {
        return goodCategoryID;
    }

    public String getTenderDescription() {
        return tenderDescription;
    }

    public double getExpectedValue() {
        return expectedValue;
    }

    public Set<TenderDetailRequestBody> getTenderDetailRequestBodies() {
        return tenderDetailRequestBodies;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public Date dateFromString(String dateInString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
        Date date = formatter.parse(dateInString);
        return date;
    }

    @Override
    public String toString() {
        return "TenderRequestBody{" +
                "userCustomerID=" + userCustomerID +
                ", tenderStatus=" + tenderStatus +
                ", goodCategoryID=" + goodCategoryID +
                ", publishingDate=" + publishingDate +
                ", closingDate=" + closingDate +
                ", tenderDescription='" + tenderDescription + '\'' +
                ", expectedValue=" + expectedValue +
                ", tenderDetails=" + tenderDetailRequestBodies +
                '}';
    }
}
