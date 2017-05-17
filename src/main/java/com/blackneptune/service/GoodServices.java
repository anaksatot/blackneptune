package com.blackneptune.service;
import com.blackneptune.entity.Good;
import java.util.List;

/**
 * Created by Admin on 5/5/2017.
 */
public interface GoodServices {

    public void create(Good good);

    public void update(Good good);

    public Good findById(int id);

    public List<Good> getAll();

    public void delete(Good good);

    public void deleteByID(int goodID);
}
