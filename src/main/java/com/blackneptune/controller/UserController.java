package com.blackneptune.controller;

import com.blackneptune.entity.User;
import com.blackneptune.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 5/12/2017.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServices userService;

    @RequestMapping(value="/createUser")
    public void createUser(@RequestParam("name") String name, @RequestParam("password")  String password) {
        userService.create(new User(name,password));
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllGoods() {
        return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserByID", method = RequestMethod.GET)
    public ResponseEntity<User> getGoodByID(@RequestParam("userID") Integer userID) {
        User user = userService.findById(userID);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/deleteUserByID")
    public void deleteGoodByID(@RequestParam("userID") Integer userID) {
        userService.deleteByID(userID);
    }

}
