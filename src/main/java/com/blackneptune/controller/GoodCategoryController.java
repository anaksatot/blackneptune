package com.blackneptune.controller;

import com.blackneptune.entity.Good;

import com.blackneptune.entity.GoodCategory;
import com.blackneptune.service.GoodCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 5/26/2017.
 */
@RestController
@RequestMapping(value = "/goodCategory")
public class GoodCategoryController {
    @Autowired
    private GoodCategoryServices goodCategoryServices;

    @RequestMapping(value = "/getAllGoodCategories", method = RequestMethod.GET)
    public ResponseEntity<List<GoodCategory>> getAllGoods() {
        return new ResponseEntity<List<GoodCategory>>(goodCategoryServices.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getGoodCategoryByID", method = RequestMethod.GET)
    public ResponseEntity<GoodCategory> getGoodByID(@RequestParam("goodCategoryID") Integer goodCategoryID) {
        return new ResponseEntity<GoodCategory>(goodCategoryServices.findById(goodCategoryID), HttpStatus.OK);
    }

    @RequestMapping(value="/createGoodCategory")
    public void createGood(@RequestParam("name") String name) {
        goodCategoryServices.create(new GoodCategory(name));
    }

    @RequestMapping(value="/deleteGoodByID")
    public void deleteGoodByID(@RequestParam("goodID") Integer goodID) {
        goodCategoryServices.deleteByID(goodID);
    }
}
