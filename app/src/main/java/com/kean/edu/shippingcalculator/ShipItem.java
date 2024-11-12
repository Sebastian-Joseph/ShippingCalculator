package com.kean.edu.shippingcalculator;

public class ShipItem {
    static final double BASE = 3.00;
    static final double BASE_EXTRA = 5.00;
    static final double ADDED = 0.50;
    static final int BASE_WEIGHT = 20;
    static final int BASE_EXTRA_WEIGHT = 50;
    static final double EXTRA_OUNCES = 5.0;

    private int mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCost;

    public ShipItem() {
        mWeight = 0;
        mAddedCost = 0.0;
        mBaseCost = 0.0;
        mTotalCost = 0.0;
    }

    public void setWeight(int weight) {
        mWeight = weight;
        computeCosts();
    }

    private void computeCosts() {
        if (mWeight <= 0) {
            mBaseCost = 0.0;
        } else if (mWeight > 0 && mWeight < BASE_WEIGHT) {
            mBaseCost = BASE;
            mAddedCost = 0.0;
        } else if (mWeight >= BASE_WEIGHT && mWeight < BASE_EXTRA_WEIGHT) {
            mBaseCost = BASE;
            mAddedCost = (int) (((mWeight - BASE_WEIGHT)) / EXTRA_OUNCES) * ADDED;
        } else if (mWeight >= BASE_EXTRA_WEIGHT) {
            mBaseCost = BASE_EXTRA;
            mAddedCost = (int) ((mWeight - BASE_WEIGHT) / EXTRA_OUNCES) * ADDED;
        }
        mTotalCost = mBaseCost + mAddedCost;
    }

    public double getBaseCost() {
        return mBaseCost;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    public double getTotalCost() {
        return mTotalCost;
    }
}
