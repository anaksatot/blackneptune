package com.blackneptune.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Admin on 5/2/2017.
 */
@Entity
@Table
public class Proposal {
    @Id
    @Column(name= "good_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int proposalID;
    @Transient
    private User userSupplier;
    @Transient
    private ProposalStatus proposalStatus;
    @Transient
    private Tender tender;
    @Transient
    private LocalDate publishingProposalDate;
    @Transient
    private LocalDate closingProposalDate;
    @Column(name= "proposal_description")
    private String proposalDescription;
    @Column(name= "proposal_value")
    private double proposalValue;

    public Proposal(String proposalDescription) {
        this.proposalDescription = proposalDescription;
    }

    public Proposal(String proposalDescription, double proposalValue) {
        this.proposalDescription = proposalDescription;
        this.proposalValue = proposalValue;
    }

    public Proposal(User userSupplier, ProposalStatus proposalStatus, Tender tender, LocalDate publishingProposalDate, LocalDate closingProposalDate, String proposalDescription, double proposalValue) {
        this.userSupplier = userSupplier;
        this.proposalStatus = proposalStatus;
        this.tender = tender;
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

    public LocalDate getPublishingProposalDate() {
        return publishingProposalDate;
    }

    public void setPublishingProposalDate(LocalDate publishingProposalDate) {
        this.publishingProposalDate = publishingProposalDate;
    }

    public LocalDate getClosingProposalDate() {
        return closingProposalDate;
    }

    public void setClosingProposalDate(LocalDate closingProposalDate) {
        this.closingProposalDate = closingProposalDate;
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
}
