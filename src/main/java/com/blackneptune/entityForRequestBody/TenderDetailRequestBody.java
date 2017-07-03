package com.blackneptune.entityForRequestBody;

/**
 * Created by Admin on 7/1/2017.
 */
public class TenderDetailRequestBody {
    private  int goodID;
    private  double quantity;
    private  double expectedGoodValue;
    private  String goodDescription;

    public TenderDetailRequestBody() {
    }

    public int getGoodID() {
        return goodID;
    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getExpectedGoodValue() {
        return expectedGoodValue;
    }

    public void setExpectedGoodValue(double expectedGoodValue) {
        this.expectedGoodValue = expectedGoodValue;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    @Override
    public String toString() {
        return "TenderDetailRequestBody{" +
                "goodID=" + goodID +
                ", quantity=" + quantity +
                ", expectedGoodValue=" + expectedGoodValue +
                ", goodDescription='" + goodDescription + '\'' +
                '}';
    }
}
