package com.blackneptune.service;

import com.blackneptune.entity.Proposal;
import com.blackneptune.entityForRequestBody.ProposalRequestBody;

import java.util.List;

/**
 * Created by Admin on 7/3/2017.
 */
public interface ProposalServices {
    void create(Proposal proposal);

    Proposal createProposalByRequestParameters(ProposalRequestBody proposalRequestBody);

    Proposal findById(int id);

    List<Proposal> getAll();

    void delete(Proposal proposal);

    void deleteByID(int goodID);
}
