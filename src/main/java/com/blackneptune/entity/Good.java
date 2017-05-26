package com.blackneptune.entity;

import javax.persistence.*;

/**
 * Created by Admin on 5/2/2017.
 */
@Entity
@Table
public class Good {
    @Id
    @Column(name= "good_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goodID;
    @Column(name= "good_name")
    private String goodName;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "good_category_id")
    private GoodCategory goodCategory;

    public Good() {
    }

    public Good(String goodName, GoodCategory goodCategory) {
        this.goodName = goodName;
        this.goodCategory = goodCategory;
    }


    public int getGoodID() {
        return goodID;
    }

    public GoodCategory getGoodCategory() {
        return goodCategory;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public void setGoodCategory(GoodCategory goodCategory) {
        this.goodCategory = goodCategory;
    }
}
