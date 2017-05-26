package com.blackneptune.dao;

import com.blackneptune.entity.GoodCategory;

import java.util.List;

/**
 * Created by Admin on 5/26/2017.
 */
public interface GoodCategoryDao {
    void persist(GoodCategory goodCategory);

    void update(GoodCategory goodCategory);

    GoodCategory findById(int goodCategoryID);

    List<GoodCategory> findAll();

    boolean delete(GoodCategory goodCategory);

    boolean deleteByID(int goodCategoryID);
}
