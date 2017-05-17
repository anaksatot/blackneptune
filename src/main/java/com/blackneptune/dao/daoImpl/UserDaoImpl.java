package com.blackneptune.dao.daoImpl;

import com.blackneptune.dao.UserDao;
import com.blackneptune.entity.Role;
import com.blackneptune.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 5/5/2017.
 */
@Transactional
@Repository
public class UserDaoImpl implements UserDao {
    //@PersistenceContext
    EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(User user) {
        //entityManager.getTransaction().begin();
        entityManager.persist(user);
        //entityManager.getTransaction().commit();
    }

    public void update(User user) {
       // entityManager.getTransaction().begin();
        User userUpdate = findById(user.getUserID());
        userUpdate.setUserName(user.getUserName());
        userUpdate.setPassword(user.getPassword());
        //userUpdate.setRole(user.getRole());
        userUpdate.setPhone(user.getPhone());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setIdentificationCode(user.getIdentificationCode());
        entityManager.flush();
        //entityManager.getTransaction().commit();
    }

    public User findById(int userID) {
        return entityManager.find(User.class, userID);
    }

    public List<User> findByRole(Role role) {
        return null;
    }

    public List<User> findAll() {
        String hql = "FROM User as user";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    public boolean delete(User user) {
        User userFromDB = findById(user.getUserID());
        if (userFromDB != null) {
            //entityManager.getTransaction().begin();
            entityManager.remove(userFromDB);
            //entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByID(int userID) {
        User userFromDB = findById(userID);
        if (userFromDB != null) {
            //entityManager.getTransaction().begin();
            entityManager.remove(userFromDB);
            //entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }


}
