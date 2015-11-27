package com.example.katarn.pizzanator;

/**
 * Created by hozukimaru on 27/11/15.
 */
public class PizzaStore {
    private long id;
    private String storeName;
    private String website;
    private int phoneNumber;

    public PizzaStore(String storeName, String website, int phoneNumber) {
        this.id = -1;
        this.storeName = storeName;
        this.website = website;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
