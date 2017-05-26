package com.blackneptune.controller;

import com.blackneptune.entity.Good;
import com.blackneptune.entity.GoodCategory;
import com.blackneptune.service.GoodCategoryServices;
import com.blackneptune.service.GoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/good")
public class GoodController {
    @Autowired
    private GoodServices goodService;

    @Autowired
    private GoodCategoryServices goodCategoryService;

    @RequestMapping(value = "/getAllGoods", method = RequestMethod.GET)
    public ResponseEntity<List<Good>> getAllGoods() {
        return new ResponseEntity<List<Good>>(goodService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getGoodByID", method = RequestMethod.GET)
    public ResponseEntity<Good> getGoodByID(@RequestParam("goodID") Integer goodID) {
        return new ResponseEntity<Good>(goodService.findById(goodID), HttpStatus.OK);
    }

    @RequestMapping(value="/createGood")
    public void createGood(@RequestParam("name") String name, @RequestParam("goodCategoryID") Integer goodCategoryID) {
        goodService.create(new Good(name,goodCategoryService.findById(goodCategoryID)));
    }

    @RequestMapping(value="/deleteGoodByID")
    public void deleteGoodByID(@RequestParam("goodID") Integer goodID) {
        goodService.deleteByID(goodID);
    }

}