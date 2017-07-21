package com.blackneptune.entityForRequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Taras on 15.07.2017.
 */
public class ProposalRequestBody {
    private int userSupplierID;
    private int tenderID;
    private Date publishingProposalDate;
    private Date closingProposalDate;
    private String proposalDescription;
    private double proposalValue;
    //private ProposalStatus proposalStatus;

    public int getUserSupplierID() {
        return userSupplierID;
    }

    public void setUserSupplierID(int userSupplierID) {
        this.userSupplierID = userSupplierID;
    }

    public int getTenderID() {
        return tenderID;
    }

    public void setTenderID(int tenderID) {
        this.tenderID = tenderID;
    }

    public Date getPublishingProposalDate() {
        return publishingProposalDate;
    }

    public void setPublishingProposalDate(String publishingProposalDate) throws ParseException {
        this.publishingProposalDate = dateFromString(publishingProposalDate);
    }

    public Date getClosingProposalDate() {
        return closingProposalDate;
    }

    public void setClosingProposalDate(String closingProposalDate) throws ParseException {
        this.closingProposalDate = dateFromString(closingProposalDate);
    }

    public String getProposalDescription() {
        return proposalDescription;
    }

    public void setProposalDescription(String proposalDescription) {
        this.proposalDescription = proposalDescription;
    }

    public double getProposalValue() {
        return proposalValue;
    }

    public void setProposalValue(double proposalValue) {
        this.proposalValue = proposalValue;
    }

    public Date dateFromString(String dateInString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
        Date date = formatter.parse(dateInString);
        return date;
    }

    @Override
    public String toString() {
        return "ProposalRequestBody{" +
                "userSupplierID=" + userSupplierID +
                ", tenderID=" + tenderID +
                ", publishingProposalDate=" + publishingProposalDate +
                ", closingProposalDate=" + closingProposalDate +
                ", proposalDescription='" + proposalDescription + '\'' +
                ", proposalValue=" + proposalValue +
                '}';
    }
}
