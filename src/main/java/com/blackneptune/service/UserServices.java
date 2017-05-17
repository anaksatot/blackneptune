package com.blackneptune.service;

import com.blackneptune.entity.User;

import java.util.List;

/**
 * Created by Admin on 5/12/2017.
 */
public interface UserServices {
    void create(User user);

    void update(User user);

    User findById(int id);

    List<User> getAll();

    void delete(User user);

    void deleteByID(int userID);
}
