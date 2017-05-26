package com.blackneptune.service.serviceImpl;

import java.util.List;
import com.blackneptune.dao.GoodDao;
import com.blackneptune.entity.Good;
import com.blackneptune.entity.GoodCategory;
import com.blackneptune.service.GoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Admin on 5/5/2017.
 */
@Service
public class GoodServiceImpl implements GoodServices{

    @Autowired
    private GoodDao goodDao;

    public GoodServiceImpl() {
    }

    public GoodServiceImpl(GoodDao goodDao) {

        this.goodDao = goodDao;
    }

    @Override
    public void create(Good good) {
        try {
            goodDao.persist(good);
        }
        catch (Exception ex) {
            System.out.println("Error creating the good: " + ex.toString());
        }
        System.out.println("Good successfully created!");
    }

    @Override
    public void update(Good good) {

    }

    @Override
    public Good findById(int id) {
        return goodDao.findById(id);
    }

    @Override
    public List<Good> getAll() {
        List<Good> listGood =  goodDao.findAll();
        return listGood;
    }

    @Override
    public void delete(Good good) {
        goodDao.delete(good);
    }

    @Override
    public void deleteByID(int goodID) {
        try {
            goodDao.deleteByID(goodID);
        }
        catch (Exception ex) {
            System.out.println("Error deleting the good by ID: " + ex.toString());
        }
        System.out.println("Good successfully deleting by ID!");
    }

}