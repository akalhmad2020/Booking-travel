package com.example.bookingtravel.network;

import com.example.bookingtravel.pojo.pojofornetwork.ResponseActivity;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseCity;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseCityActivity;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseCountry;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiBookingTravel {

    @GET("getCities")
    public Observable<ResponseCity> getCities();

    @GET("getCitiesActivities")
    public Observable<ResponseCityActivity> getCityActivity();

    @GET("getCountries")
    public Observable<ResponseCountry> getCountries();

    @GET("getActivities")
    public Observable<ResponseActivity> getActivities();







}
