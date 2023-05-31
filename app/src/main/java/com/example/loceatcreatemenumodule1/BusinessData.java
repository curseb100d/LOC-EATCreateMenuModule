package com.example.loceatcreatemenumodule1;

public class BusinessData {

    private String foodname;
    private String price;
    private String type;
    private String image;
    private String key;

    public BusinessData(String foodname, String price, String type, String image) {
        this.foodname = foodname;
        this.price = price;
        this.type = type;
        this.image = image;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public String getKey() {
        return key;
    }

    public String getFoodname() {
        return foodname;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }

    public BusinessData(){

    }

}
