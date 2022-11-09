package com.example.bookingtravel.di;

import com.example.bookingtravel.network.ApiBookingTravel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;

import dagger.hilt.android.components.ActivityComponent;

import dagger.hilt.android.components.FragmentComponent;

import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.FragmentScoped;

import dagger.hilt.components.SingletonComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class RetrofitModule {

    public static final String BASE_URL = "https://testbookingtravel.000webhostapp.com/BookingT/public/";


    @Provides
    @Singleton
    public static ApiBookingTravel provideApi(){

        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build().create(ApiBookingTravel.class);

    }


}
