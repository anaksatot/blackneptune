package com.blackneptune.dao;

import com.blackneptune.entity.Proposal;
import com.blackneptune.entity.ProposalStatus;
import com.blackneptune.entity.Tender;

import java.util.List;

/**
 * Created by Admin on 5/5/2017.
 */
public interface ProposalDao {

    public void persist(Proposal proposal);

    public void update(Proposal proposal);

    public Proposal findById(int id);

    public List<Proposal> findByTender(Tender tender);

    public List<Proposal> findByStatus(ProposalStatus proposalStatus);

    public List<Proposal> findAll();

    public  void delete(Proposal proposal);

    public  void deleteByProposalID(int proposalID);

}
