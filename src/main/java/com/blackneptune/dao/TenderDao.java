package com.blackneptune.dao;

import com.blackneptune.entity.Tender;
import com.blackneptune.entity.TenderStatus;

import java.util.List;

/**
 * Created by Admin on 5/5/2017.
 */
public interface TenderDao {

    void persist(Tender tender);

    void update(Tender tender);

    Tender findById(int id);

    List<Tender> findByProposal(Tender tender);

    List<Tender> findByStatus(TenderStatus tenderStatus);

    List<Tender> findAll();

    void delete(Tender tender);

    boolean deleteByID(int tenderID);
}
