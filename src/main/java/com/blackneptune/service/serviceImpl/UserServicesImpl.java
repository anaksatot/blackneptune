package com.blackneptune.service.serviceImpl;

import com.blackneptune.dao.UserDao;
import com.blackneptune.entity.User;
import com.blackneptune.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 5/12/2017.
 */
@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserDao userDao;
    @Override
    public void create(User user) {
        try {
            userDao.persist(user);
        }
        catch (Exception ex) {
            System.out.println("Error creating the user: " + ex.toString());
        }
        System.out.println("User successfully created!");
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(int id) {
        User user =  userDao.findById(id);
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> listUsers =  userDao.findAll();
        return listUsers;
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void deleteByID(int userID) {
        try {
            userDao.deleteByID(userID);
        }
        catch (Exception ex) {
            System.out.println("Error deleting the user by ID: " + ex.toString());
        }
        System.out.println("User successfully deleting by ID!");

    }
}
