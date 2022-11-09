package com.example.bookingtravel.pojo.pojotosubfragments;

public class PojoCategories {
    private int countDestinations ;
    private int imageId ;
    private String nameCategory;

    public PojoCategories(int countDestinations, int imageId, String nameCategory) {
        this.countDestinations = countDestinations;
        this.imageId = imageId;
        this.nameCategory = nameCategory;
    }

    public int getCountDestinations() {
        return countDestinations;
    }

    public void setCountDestinations(int countDestinations) {
        this.countDestinations = countDestinations;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
