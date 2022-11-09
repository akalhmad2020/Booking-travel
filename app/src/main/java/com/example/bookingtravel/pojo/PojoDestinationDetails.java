package com.example.bookingtravel.pojo;

public class PojoDestinationDetails {
    private String countryName ;
    private String cityName ;
    private String activityName ;
    private int position ;

    public PojoDestinationDetails(String countryName, String cityName, String activityName, int position) {
        this.countryName = countryName;
        this.cityName = cityName;
        this.activityName = activityName;
        this.position = position;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
