package com.example.bookingtravel.pojo.pojofornetwork;

public class CityActivity {

    private int id ;
    private int cityId ;
    private int activityId ;
    private String nameItem ;
    private String imageItem ;
    private String created_at ;
    private String updated_at ;


    public CityActivity(int cityId, int activityId, String nameItem, String imageItem) {
        this.cityId = cityId;
        this.activityId = activityId;
        this.nameItem = nameItem;
        this.imageItem = imageItem;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getImageItem() {
        return imageItem;
    }

    public void setImageItem(String imageItem) {
        this.imageItem = imageItem;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
