package com.example.bookingtravel.pojo.pojofornetwork;

public class Activity {

    private int id ;
    private String nameActivity ;
    private String activityUrl ;
    private String created_at ;
    private String updated_at ;


    public Activity(String nameActivity, String activityUrl) {
        this.nameActivity = nameActivity;
        this.activityUrl = activityUrl;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
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
