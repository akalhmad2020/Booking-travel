package com.example.bookingtravel.repository;

import com.example.bookingtravel.network.ApiBookingTravel;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseActivity;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseCity;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseCityActivity;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseCountry;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {

    private ApiBookingTravel apiBookingTravel ;


    @Inject
    public Repository(ApiBookingTravel apiBookingTravel) {
        this.apiBookingTravel = apiBookingTravel;
    }

    public Observable<ResponseCity> getApiCites() {
        return apiBookingTravel.getCities();
    }

    public Observable<ResponseActivity> getApiActivities() {
        return apiBookingTravel.getActivities();
    }

    public Observable<ResponseCountry> getApiCountries(){

        return apiBookingTravel.getCountries();
    }


    public Observable<ResponseCityActivity> getApiCitiesActivities(){

        return apiBookingTravel.getCityActivity();
    }



}
