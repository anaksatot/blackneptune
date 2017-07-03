package com.blackneptune.controller;

import com.blackneptune.entity.Tender;
import com.blackneptune.entity.TenderDetail;
import com.blackneptune.entityForRequestBody.TenderRequestBody;
import com.blackneptune.service.TenderServices;
import com.blackneptune.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 5/13/2017.
 */
@RestController
@RequestMapping(value = "/tender")
public class TenderController {
    @Autowired
    private TenderServices tenderService;

    @RequestMapping(value = "/getAllTenders", method = RequestMethod.GET)
    public ResponseEntity<List<Tender>> getAllTenders() {
        return new ResponseEntity<List<Tender>>(tenderService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getTenderByID", method = RequestMethod.GET)
    public ResponseEntity<Tender> getTenderByID(@RequestParam("tenderID") Integer tenderID) {
        return new ResponseEntity<Tender>(tenderService.findById(tenderID), HttpStatus.OK);
    }

    @RequestMapping(value="/createTenderWithRequestParams")
    public void createTenderWithRequestParams(@RequestParam("description") String description,
                                 @RequestParam("expectedValue") Double expectedValue, @RequestBody Set<TenderDetail> tenderDetails) {
        tenderService.create(new Tender(description,expectedValue,tenderDetails));
    }

    @RequestMapping(value="/createTender")
    public void createTender(@RequestBody TenderRequestBody tenderRequestBody) {
        tenderService.create(tenderService.createTenderByRequestParameters(tenderRequestBody));
    }


    @RequestMapping(value="/deleteTenderByID")
    public String deleteGoodByID(@RequestParam("tenderID") Integer tenderID) {
        try {
            tenderService.deleteByID(tenderID);
        }
        catch (Exception ex) {
            return "Error deleting the tender by ID: " + ex.toString();
        }
        return "Tender successfully deleting by ID!";
    }
}
