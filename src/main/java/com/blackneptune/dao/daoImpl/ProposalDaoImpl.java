package com.blackneptune.dao.daoImpl;

import com.blackneptune.dao.ProposalDao;
import com.blackneptune.entity.Proposal;
import com.blackneptune.entity.ProposalStatus;
import com.blackneptune.entity.Tender;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 5/5/2017.
 */
@Transactional
@Repository
public class ProposalDaoImpl implements ProposalDao {
    EntityManager entityManager;

    public ProposalDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Proposal proposal) {
        entityManager.persist(proposal);
    }

    public void update(Proposal proposal) {
        Proposal proposalUpdate = findById(proposal.getProposalID());
        proposalUpdate.setProposalDescription(proposal.getProposalDescription());
        proposalUpdate.setProposalValue(proposal.getProposalValue());
        entityManager.flush();
    }

    public Proposal findById(int proposalID) {
        return entityManager.find(Proposal.class, proposalID);
    }

    public List<Proposal> findByTender(Tender tender) {
        return null;
    }

    public List<Proposal> findByStatus(ProposalStatus proposalStatus) {
        return null;
    }

    public List<Proposal> findAll() {
        String hql = "FROM Proposal as proposal";
        return (List<Proposal>) entityManager.createQuery(hql).getResultList();
    }

    public boolean delete(Proposal proposal) {
        return false;
    }

    @Override
    public boolean deleteByProposalID(int proposalID) {
        return false;
    }
}
