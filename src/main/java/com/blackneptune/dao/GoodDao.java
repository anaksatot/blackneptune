package com.blackneptune.dao;

import com.blackneptune.entity.Good;
import com.blackneptune.entity.GoodCategory;

import java.util.List;

/**
 * Created by Admin on 5/5/2017.
 */
public interface GoodDao {

    void persist(Good good);

    void update(Good good);

    Good findById(int id);

    List<Good> findAll();

    boolean delete(Good good);

    boolean deleteByID(int goodID);

}
