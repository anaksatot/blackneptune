package com.blackneptune.service.serviceImpl;

import com.blackneptune.dao.TenderDao;
import com.blackneptune.dao.TenderDetailDao;
import com.blackneptune.entity.Tender;
import com.blackneptune.entity.TenderDetail;
import com.blackneptune.entityForRequestBody.TenderDetailRequestBody;
import com.blackneptune.entityForRequestBody.TenderRequestBody;
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
    private UserServices userService;
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
        System.out.println("Tender successfully created!");
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

    public Tender createTenderByRequestParameters(TenderRequestBody tenderRequestBody){
        Tender tender = new Tender(userService.findById(tenderRequestBody.getUserCustomerID()),tenderRequestBody.getTenderStatus(),tenderRequestBody.getTenderDescription(),tenderRequestBody.getExpectedValue(),tenderRequestBody.getPublishingDate(),tenderRequestBody.getClosingDate());
        Set<TenderDetail> tenderDetails = createTenderSetDetailsForTenderUsingTenderDetailRequestBodies(tender, tenderRequestBody.getTenderDetailRequestBodies());
        tender.setTenderDetails(tenderDetails);
        return tender;
    }

    private Set<TenderDetail>  createTenderSetDetailsForTenderUsingTenderDetailRequestBodies(Tender tender, Set<TenderDetailRequestBody> tenderDetailRequestBody){
        Set<TenderDetail> tenderDetails = new HashSet<>();
        for (TenderDetailRequestBody TDRB:tenderDetailRequestBody) {
            tenderDetails.add( createTenderDetailForTenderUsingTenderDetailRequestBodies(TDRB.getGoodID(),TDRB.getQuantity(),TDRB.getExpectedGoodValue(),TDRB.getGoodDescription(),tender));
        }
        return tenderDetails;
    }

    private TenderDetail  createTenderDetailForTenderUsingTenderDetailRequestBodies(int goodID, double quantity, double expectedGoodValue, String goodDescription, Tender tender){
        return new TenderDetail(goodService.findById(goodID),quantity,expectedGoodValue,goodDescription,tender);
    }

}
