package com.example.laba9.model;

import java.io.Serializable;

public class Rent implements Serializable {
    private String name;
    private String phoneNumber;
    private String rentDate;
    private String productName;
    private double price;
    private String duration;

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getRentDate() { return rentDate; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getDuration() { return duration; }

    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setRentDate(String rentDate) { this.rentDate = rentDate; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setPrice(double price) { this.price = price; }
    public void setDuration(String duration) { this.duration = duration; }
}