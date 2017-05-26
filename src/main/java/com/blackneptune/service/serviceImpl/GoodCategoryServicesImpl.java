package com.blackneptune.service.serviceImpl;

import com.blackneptune.dao.GoodCategoryDao;
import com.blackneptune.entity.GoodCategory;
import com.blackneptune.service.GoodCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 5/26/2017.
 */
@Service
public class GoodCategoryServicesImpl implements GoodCategoryServices {
    @Autowired
    private GoodCategoryDao goodCategoryDao;
    @Override
    public void create(GoodCategory goodCategory) {
        try {
            System.out.println("-18-"+goodCategoryDao);
            System.out.println("-19-"+goodCategory);
            goodCategoryDao.persist(goodCategory);
        }
        catch (Exception ex) {
            System.out.println("Error creating the good category: " + ex.toString());
        }
        System.out.println("Good category successfully created!");
    }

    @Override
    public void update(GoodCategory goodCategory) {

    }

    @Override
    public GoodCategory findById(int id) {
        return goodCategoryDao.findById(id);
    }

    @Override
    public List<GoodCategory> getAll() {
        return null;
    }

    @Override
    public void delete(GoodCategory goodCategory) {

    }

    @Override
    public void deleteByID(int goodCategoryID) {

    }
}
