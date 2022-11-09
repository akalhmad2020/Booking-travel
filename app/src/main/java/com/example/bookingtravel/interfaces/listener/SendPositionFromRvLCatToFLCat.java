package com.example.bookingtravel.interfaces.listener;

// this interface contains function to get int (position) , city name and country name
// from RvListingCategoriesAdapter to send it to ListingCategoriesFragment fragment
public interface SendPositionFromRvLCatToFLCat {
    void sendPosition(int activityId , int cityId, String countryName , String cityName );
}
