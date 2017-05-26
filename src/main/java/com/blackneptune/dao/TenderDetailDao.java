package com.blackneptune.dao;

import com.blackneptune.entity.Tender;
import com.blackneptune.entity.TenderDetail;

import java.util.List;

/**
 * Created by Admin on 5/17/2017.
 */
public interface TenderDetailDao {

    void persist(TenderDetail tenderDetail);

    void update(TenderDetail tenderDetail);

    TenderDetail findById(int id);

    List<TenderDetail> findByTender(Tender tender);

    List<TenderDetail> findByTenderID(int id);

    List<Tender> findAll();

    boolean deleteByTenderID(int tenderID);

    boolean deleteByTender(Tender tender);
}
