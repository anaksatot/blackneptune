package com.blackneptune.controller;

import com.blackneptune.entity.Tender;
import com.blackneptune.service.TenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value="/createTender")
    public String createTender(@RequestParam("description") String description) {
        try {
            tenderService.create(new Tender(description));
        }
        catch (Exception ex) {
            return "Error creating the tender: " + ex.toString();
        }
        return "Tender successfully created!";
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
