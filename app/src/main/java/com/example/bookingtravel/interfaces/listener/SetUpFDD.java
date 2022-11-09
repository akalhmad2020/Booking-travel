package com.example.bookingtravel.interfaces.listener;

// this interface contains function to get int(position) , country name and city name
// from ListingCategoriesFragment fragment
// that came from RvListingCategoriesAdapter to send it to ListingCategories Activity
// and that activity will set up fragment DestinationDetails
public interface SetUpFDD {
    void setUpFdd(int activityId , int cityId, String countryName , String cityName , String newActivityName );
}
