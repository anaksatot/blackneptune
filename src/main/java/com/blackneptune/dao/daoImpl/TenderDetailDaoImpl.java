package com.blackneptune.dao.daoImpl;

import com.blackneptune.dao.TenderDetailDao;
import com.blackneptune.entity.Tender;
import com.blackneptune.entity.TenderDetail;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 5/17/2017.
 */
@Transactional
@Repository
public class TenderDetailDaoImpl implements TenderDetailDao {
    EntityManager entityManager;

    public TenderDetailDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(TenderDetail tenderDetail) {
        entityManager.persist(tenderDetail);
    }

    @Override
    public void update(TenderDetail tenderDetail) {

    }

    @Override
    public TenderDetail findById(int id) {
        return null;
    }

    @Override
    public List<TenderDetail> findByTender(Tender tender) {
        return null;
    }

    @Override
    public List<TenderDetail> findByTenderID(int id) {
        return null;
    }

    @Override
    public List<Tender> findAll() {
        return null;
    }

    @Override
    public boolean deleteByTenderID(int tenderID) {
        return false;
    }

    @Override
    public boolean deleteByTender(Tender tender) {
        return false;
    }
}
