package com.blackneptune.service.serviceImpl;

import com.blackneptune.dao.TenderDao;
import com.blackneptune.dao.TenderDetailDao;
import com.blackneptune.entity.Tender;
import com.blackneptune.entity.TenderDetail;
import com.blackneptune.service.GoodServices;
import com.blackneptune.service.TenderServices;
import com.blackneptune.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 5/13/2017.
 */
@Service
public class TenderServicesImpl implements TenderServices {
    @Autowired
    private TenderDao tenderDao;
    @Autowired
    private TenderDetailDao tenderDetailDao;
    @Autowired
    private GoodServices goodService;
    @Autowired
    private UserServices userServices;
    @Override
    public void create(Tender tender) {
        try {
            tenderDao.persist(tender);
            for (TenderDetail tenderdetail:tender.getTenderDetails()) {
                tenderDetailDao.persist(tenderdetail);
            }
        }
        catch (Exception ex) {
            System.out.println("Error creating the tender details: " + ex.toString());
        }
        System.out.println("Tender details successfully created!");
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
        System.out.println("Tender successfully deleting by ID!");
    }

    public Tender createTenderByRequestParameters(Integer userCustomerId, String description, Double expectedValue){
        Set<TenderDetail> tenderDetails = new HashSet<>();
        Tender tender = new Tender(userServices.findById(userCustomerId),description, expectedValue);
        tenderDetails.add(new TenderDetail(goodService.findById(2),5.0,834.2,"lishchyna",tender));
        tenderDetails.add(new TenderDetail(goodService.findById(3),12.0,400.0,"berry",tender));
        tender.setTenderDetails(tenderDetails);
        return tender;
    }
}
