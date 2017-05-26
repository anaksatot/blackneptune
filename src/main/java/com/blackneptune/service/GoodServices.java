package com.blackneptune.service;
import com.blackneptune.entity.Good;
import com.blackneptune.entity.GoodCategory;

import java.util.List;

/**
 * Created by Admin on 5/5/2017.
 */
public interface GoodServices {

    void create(Good good);

    void update(Good good);

    Good findById(int id);

    List<Good> getAll();

    void delete(Good good);

    void deleteByID(int goodID);

}
