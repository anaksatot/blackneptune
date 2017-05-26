package com.blackneptune.dao.daoImpl;

import com.blackneptune.dao.GoodCategoryDao;
import com.blackneptune.entity.GoodCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 5/26/2017.
 */
@Transactional
@Repository
public class GoodCategoryDaoImpl implements GoodCategoryDao{
    EntityManager entityManager;

    public GoodCategoryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(GoodCategory goodCategory) {
        System.out.println("-21-"+goodCategory);
        System.out.println("-22-"+entityManager);
        entityManager.persist(goodCategory);
    }

    @Override
    public void update(GoodCategory goodCategory) {

    }

    @Override
    public GoodCategory findById(int goodCategoryId) {
        return entityManager.find(GoodCategory.class, goodCategoryId);
    }

    @Override
    public List<GoodCategory> findAll() {
        return null;
    }

    @Override
    public boolean delete(GoodCategory goodCategory) {
        return false;
    }

    @Override
    public boolean deleteByID(int goodCategoryID) {
        return false;
    }
}
