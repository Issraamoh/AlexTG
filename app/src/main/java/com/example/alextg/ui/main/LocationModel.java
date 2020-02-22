package com.example.alextg.ui.main;

public class LocationModel {
    String address,name,description;

    int image;
    Double lattitude, longtitude;

    public LocationModel(String address, String name, String description, int image, Double lattitude, Double longtitude) {
        this.address = address;
        this.name = name;
        this.description = description;
        this.image = image;
        this.lattitude = lattitude;
        this.longtitude = longtitude;
    }
}
