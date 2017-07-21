package com.blackneptune.service.serviceImpl;

import com.blackneptune.dao.ProposalDao;
import com.blackneptune.entity.Proposal;
import com.blackneptune.entity.ProposalStatus;
import com.blackneptune.entityForRequestBody.ProposalRequestBody;
import com.blackneptune.service.ProposalServices;
import com.blackneptune.service.TenderServices;
import com.blackneptune.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 7/3/2017.
 */
@Service
public class ProposalServicesImpl implements ProposalServices {
    @Autowired
    private ProposalDao proposalDao;

    @Autowired
    private UserServices userServices;

    @Autowired
    private TenderServices tenderServices;

    @Override
    public void create(Proposal proposal) {
        try {
            proposalDao.persist(proposal);
        }
        catch (Exception ex) {
            System.out.println("Error creating the proposal: " + ex.toString());
        }
        System.out.println("Proposal successfully created!");
    }

    @Override
    public Proposal createProposalByRequestParameters(ProposalRequestBody proposalRequestBody) {
        Proposal proposal = new Proposal(userServices.findById(proposalRequestBody.getUserSupplierID()),tenderServices.findById(proposalRequestBody.getTenderID()), ProposalStatus.OFFERED, proposalRequestBody.getPublishingProposalDate(),proposalRequestBody.getClosingProposalDate(),proposalRequestBody.getProposalDescription(),proposalRequestBody.getProposalValue());
        return proposal;
    }

    @Override
    public Proposal findById(int id) {
        return proposalDao.findById(id);
    }

    @Override
    public List<Proposal> getAll() {
        return proposalDao.findAll();
    }

    @Override
    public void delete(Proposal proposal) {
        try {
            proposalDao.delete(proposal);
        }
        catch (Exception ex) {
            System.out.println("Error deleting the proposal: " + ex.toString());
        }
        System.out.println("Proposal successfully deleted!");
    }

    @Override
    public void deleteByID(int proposalID) {
        proposalDao.deleteByProposalID(proposalID);
    }
}
