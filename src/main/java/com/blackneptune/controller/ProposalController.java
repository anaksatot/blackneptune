package com.blackneptune.controller;

import com.blackneptune.entity.Proposal;
import com.blackneptune.entityForRequestBody.ProposalRequestBody;
import com.blackneptune.service.ProposalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 5/17/2017.
 */
@Controller
@RequestMapping(value = "/proposal")
public class ProposalController {
    @Autowired
    private ProposalServices proposalServices;
    @RequestMapping(value="/createProposalOld")
    public void createProposal_old(@RequestBody Proposal proposal) {
        proposalServices.create(proposal);
    }

    @RequestMapping(value = "/getAllProposals", method = RequestMethod.GET)
    public ResponseEntity<List<Proposal>> getAllProposals() {
        return new ResponseEntity<List<Proposal>>(proposalServices.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getProposalByID", method = RequestMethod.GET)
    public ResponseEntity<Proposal> getProposalByID(@RequestParam("proposalID") Integer proposalID) {
        return new ResponseEntity<Proposal>(proposalServices.findById(proposalID), HttpStatus.OK);
    }

    @RequestMapping(value="/createProposal")
    public void createTender(@RequestBody ProposalRequestBody proposalRequestBody) {
        proposalServices.create(proposalServices.createProposalByRequestParameters(proposalRequestBody));
    }

    @RequestMapping(value="/deleteProposalByID")
    public String deleteGoodByID(@RequestParam("proposalID") Integer proposalID) {
        try {
            proposalServices.deleteByID(proposalID);
        }
        catch (Exception ex) {
            return "Error deleting the tender by ID: " + ex.toString();
        }
        return "Tender successfully deleting by ID!";
    }

}
