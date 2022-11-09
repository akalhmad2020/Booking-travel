package com.example.bookingtravel.pojo;

public class PojoListingCategories {
    private String countDestination ;
    private String nameCountry ;
    private String nameCity ;
    private int imageId ;

    public PojoListingCategories(String countDestination, String nameCountry, String nameCity, int imageId) {
        this.countDestination = countDestination;
        this.nameCountry = nameCountry;
        this.nameCity = nameCity;
        this.imageId = imageId;
    }


    public String getCountDestination() {
        return countDestination;
    }

    public void setCountDestination(String countDestination) {
        this.countDestination = countDestination;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
