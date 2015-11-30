package com.example.katarn.pizzanator;

/**
 * Created by hozukimaru on 27/11/15.
 */
public class PizzaStore {
    private long id;
    private String storeName;
    private String address;
    private String website;
    private String phoneNumber;

    public PizzaStore(String storeName, String address, String website, String phoneNumber) {
        this.id = -1;
        this.storeName = storeName;
        this.address = address;
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

    public void setAddress(String address) {this.address = address; }

    public java.lang.String getAddress() {return address; }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
