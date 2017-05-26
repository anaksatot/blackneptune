package com.blackneptune.service;

import com.blackneptune.entity.GoodCategory;

import java.util.List;

/**
 * Created by Admin on 5/26/2017.
 */
public interface GoodCategoryServices {
    void create(GoodCategory goodCategory);

    void update(GoodCategory goodCategory);

    GoodCategory findById(int id);

    List<GoodCategory> getAll();

    void delete(GoodCategory goodCategory);

    void deleteByID(int goodCategoryID);
}
