package com.example.travelmantics;

import java.io.Serializable;

public class TravelDeal implements Serializable {

    private String id;
    private String title;
    private String description;
    private String price;
    private String imgURL;

    public TravelDeal() {
    }

    public TravelDeal(String id, String title, String description, String price, String imgURL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
