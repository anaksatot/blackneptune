package com.blackneptune.entity;

import javax.persistence.*;

/**
 * Created by Admin on 5/2/2017.
 */
@Entity
@Table
public class GoodCategory {
    @Id
    @Column(name= "good_category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goodCategoryID;
    @Column(name= "good_category_name")
    private String goodCategoryName;

    public GoodCategory() {
    }

    public GoodCategory(String name) {
        this.goodCategoryName = name;
    }
}
