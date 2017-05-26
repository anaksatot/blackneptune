package com.blackneptune.entity;

import javax.persistence.*;

/**
 * Created by Admin on 5/2/2017.
 */
@Entity
@Table (name = "tender_detail")
public class TenderDetail {
    @Id
    @Column(name= "tenderdetail_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tenderID;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "tender_id")
    private Tender tender;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "good_id")
    private Good good;
    @Column(name= "quantity")
    private Double quantity;
    @Column(name= "expected_good_value")
    private Double expectedGoodValue;
    @Column(name= "good_description")
    private String goodDescription;

    public TenderDetail(Good good, Double quantity, Double expectedGoodValue, String goodDescription, Tender tender) {
        this.good = good;
        this.quantity = quantity;
        this.expectedGoodValue = expectedGoodValue;
        this.goodDescription = goodDescription;
        this.tender = tender;
    }

    @Override
    public String toString() {
        return "TenderDetail{" +
                "tenderID=" + tenderID +
                ", tender=" + tender +
                ", good=" + good +
                ", quantity=" + quantity +
                ", expectedGoodValue=" + expectedGoodValue +
                ", goodDescription='" + goodDescription + '\'' +
                '}';
    }


}
