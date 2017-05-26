package com.blackneptune.dao.daoImpl;

import com.blackneptune.dao.GoodDao;
import com.blackneptune.entity.Good;
import com.blackneptune.entity.GoodCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 5/5/2017.
 */
@Transactional
@Repository

public class GoodDaoImpl implements GoodDao {

    EntityManager entityManager;

    public GoodDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Good good) {
        entityManager.persist(good);
    }

    public void update(Good good) {;
        Good goodUpdate = findById(good.getGoodID());
        goodUpdate.setGoodName(good.getGoodName());
        goodUpdate.setGoodCategory(good.getGoodCategory());
        entityManager.flush();
    }

    public Good findById(int goodId) {
        return entityManager.find(Good.class, goodId);
    }

    public List<Good> findAll() {
        String hql = "FROM Good as good";
        return (List<Good>) entityManager.createQuery(hql).getResultList();
    }

    public boolean delete(Good good) {

        Good goodFromDB = findById(good.getGoodID());
        if (goodFromDB != null) {
            entityManager.remove(goodFromDB);
            return true;
        }
        return false;

    }

    public boolean deleteByID(int goodID) {

        Good goodFromDB = findById(goodID);
        if (goodFromDB != null) {
            entityManager.remove(goodFromDB);
            return true;
        }
        return false;

    }

}
