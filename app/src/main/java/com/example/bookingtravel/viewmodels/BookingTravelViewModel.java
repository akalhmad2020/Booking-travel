package com.example.bookingtravel.viewmodels;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookingtravel.pojo.pojofornetwork.Activity;
import com.example.bookingtravel.pojo.pojofornetwork.City;
import com.example.bookingtravel.pojo.pojofornetwork.CityActivity;
import com.example.bookingtravel.pojo.pojofornetwork.Country;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseActivity;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseCity;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseCityActivity;
import com.example.bookingtravel.pojo.pojofornetwork.ResponseCountry;
import com.example.bookingtravel.repository.Repository;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;


@HiltViewModel
public class BookingTravelViewModel extends ViewModel {


    private Repository repository ;

    private MutableLiveData<ArrayList<City>> listCities = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Activity>> listActivities = new MutableLiveData<>();
    private MutableLiveData<ArrayList<CityActivity>> listCitiesActivities = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Country>> listCountries = new MutableLiveData<>();

    @Inject
    public BookingTravelViewModel(Repository repository) {
        this.repository = repository;
    }


    public MutableLiveData<ArrayList<City>> getListCities() {
        return listCities;
    }

    public MutableLiveData<ArrayList<Activity>> getListActivities() {
        return listActivities;
    }

    public MutableLiveData<ArrayList<CityActivity>> getListCitiesActivities() {
        return listCitiesActivities;
    }

    public MutableLiveData<ArrayList<Country>> getListCountries() {
        return listCountries;
    }



    public void getCities(){

        repository.getApiCites().subscribeOn(Schedulers.io())
                .map(new Function<ResponseCity, ArrayList<City>>() {
            @Override
            public ArrayList<City> apply(ResponseCity responseCity) throws Throwable {
                return responseCity.getResult();
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> listCities.setValue(result),
                        error -> Log.e("viewModelCities",error.getMessage()));
    }


    public void getActivities(){

        repository.getApiActivities().subscribeOn(Schedulers.io())
                .map(new Function<ResponseActivity, ArrayList<Activity>>() {
                    @Override
                    public ArrayList<Activity> apply(ResponseActivity responseActivity) throws Throwable {

                         return responseActivity.getResult();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> listActivities.setValue(result)
                , error -> Log.e("viewModelActivities",error.getMessage()));
    }



    public void getCitiesActivities(){

        repository.getApiCitiesActivities().subscribeOn(Schedulers.io())
                .map(new Function<ResponseCityActivity, ArrayList<CityActivity>>() {
                    @Override
                    public ArrayList<CityActivity> apply(ResponseCityActivity responseCityActivity) throws Throwable {
                        return responseCityActivity.getResult();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> listCitiesActivities.setValue(result),
                     error -> Log.e("viewModel" , error.getMessage())  );

    }



    public void getCountries(){

        repository.getApiCountries().subscribeOn(Schedulers.io())
                .map(new Function<ResponseCountry, ArrayList<Country>>() {
                    @Override
                    public ArrayList<Country> apply(ResponseCountry responseCountry) throws Throwable {
                        return responseCountry.getResult();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> listCountries.setValue(result),
                        error -> Log.e("viewModel" , error.getMessage())  );


    }





}
