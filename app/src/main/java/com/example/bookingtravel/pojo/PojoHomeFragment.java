package com.example.bookingtravel.pojo;

public class PojoHomeFragment {

   private String nameActivity ;
   private int imageId ;


    public PojoHomeFragment(String nameActivity, int imageId) {
        this.nameActivity = nameActivity;
        this.imageId = imageId;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
