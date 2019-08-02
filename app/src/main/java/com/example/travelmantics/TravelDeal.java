package com.example.travelmantics;

public class TravelDeal {

    public static String title;
    public static String description;
    public static String price;

    public TravelDeal() {
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        TravelDeal.title = title;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        TravelDeal.description = description;
    }

    public static String getPrice() {
        return price;
    }

    public static void setPrice(String price) {
        TravelDeal.price = price;
    }
}
