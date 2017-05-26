package com.blackneptune.service;

import com.blackneptune.entity.Tender;

import java.util.List;

/**
 * Created by Admin on 5/13/2017.
 */
public interface TenderServices {
    void create(Tender tender);

    void update(Tender tender);

    Tender findById(int id);

    List<Tender> getAll();

    void delete(Tender tender);

    void deleteByID(int goodID);

    Tender createTenderByRequestParameters(Integer userCustomerID, String description, Double expectedValue);
}
