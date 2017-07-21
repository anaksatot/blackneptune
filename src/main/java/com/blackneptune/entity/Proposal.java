package com.blackneptune.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Admin on 5/2/2017.
 */
@Entity
@Table
public class Proposal {
    @Id
    @Column(name= "proposal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int proposalID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User userSupplier;
    @Column(name= "proposal_status")
    private ProposalStatus proposalStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "tender_id")
    private Tender tender;
    @Column(name= "publishing_proposal_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date publishingProposalDate;
    @Column(name= "closing_proposal_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date closingProposalDate;
    @Column(name= "proposal_description")
    private String proposalDescription;
    @Column(name= "proposal_value")
    private double proposalValue;

    public Proposal() {
    }

    public Proposal(String proposalDescription) {
        this.proposalDescription = proposalDescription;
    }

    public Proposal(String proposalDescription, double proposalValue) {
        this.proposalDescription = proposalDescription;
        this.proposalValue = proposalValue;
    }

    public Proposal(User userSupplier, Tender tender, ProposalStatus proposalStatus, Date publishingProposalDate, Date closingProposalDate, String proposalDescription, double proposalValue) {
        this.userSupplier = userSupplier;
        this.tender = tender;
        this.proposalStatus = proposalStatus;
        this.publishingProposalDate = publishingProposalDate;
        this.closingProposalDate = closingProposalDate;
        this.proposalDescription = proposalDescription;
        this.proposalValue = proposalValue;
    }

    public int getProposalID() {
        return proposalID;
    }

    public void setProposalID(int proposalID) {
        this.proposalID = proposalID;
    }

    public User getUserSupplier() {
        return userSupplier;
    }

    public void setUserSupplier(User userSupplier) {
        this.userSupplier = userSupplier;
    }

    public ProposalStatus getProposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(ProposalStatus proposalStatus) {
        this.proposalStatus = proposalStatus;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
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
}
