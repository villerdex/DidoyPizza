package com.example.didoy.didoypizza.Model;

import android.view.View;

import java.io.Serializable;

/**
 * Created by Didoy on 9/20/2016.
 */
public class Pizza implements Serializable {

    private String name;
    private int imgId;
    private String desc;
    private int price ;

    public Pizza(String name, int imgId, String desc, int price) {
        this.name = name;
        this.imgId = imgId;
        this.desc = desc;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name;
    }
}
