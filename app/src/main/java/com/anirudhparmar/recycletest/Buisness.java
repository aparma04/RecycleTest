package com.anirudhparmar.recycletest;

/**
 * Created by Anirudh on 2/22/2017.
 */

public class Buisness {
    private String name;
    private String address;
    private String imageUrl;


    public Buisness(String name, String address, String imageUrl) {
        this.name = name;
        this.address = address;
        this.imageUrl = imageUrl;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
