package com.blackneptune.service.serviceImpl;

import com.blackneptune.dao.TenderDao;
import com.blackneptune.entity.Tender;
import com.blackneptune.service.TenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 5/13/2017.
 */
@Service
public class TenderServicesImpl implements TenderServices {
    @Autowired
    private TenderDao tenderDao;
    @Override
    public void create(Tender tender) {
        tenderDao.persist(tender);
    }

    @Override
    public void update(Tender tender) {

    }

    @Override
    public Tender findById(int id) {
        return null;
    }

    @Override
    public List<Tender> getAll() {
        return tenderDao.findAll();
    }

    @Override
    public void delete(Tender tender) {

    }

    @Override
    public void deleteByID(int tenderID) {
        try {
            tenderDao.deleteByID(tenderID);
        }
        catch (Exception ex) {
            System.out.println("Error deleting the tender by ID: " + ex.toString());
        }
        System.out.println("Tender succesfully deleting by ID!");
    }
}
