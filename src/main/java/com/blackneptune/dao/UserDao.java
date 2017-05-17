package com.blackneptune.dao;

import com.blackneptune.entity.Role;
import com.blackneptune.entity.User;

import java.util.List;

/**
 * Created by Admin on 5/5/2017.
 */
public interface UserDao {

    void persist(User user);

    void update(User user);

    User findById(int id);

    List<User> findByRole(Role role);

    List<User> findAll();

    boolean delete(User user);

    boolean deleteByID(int userID);
}
