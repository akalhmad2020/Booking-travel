package com.example.bookingtravel.pojo.pojofornetwork;

import java.util.ArrayList;

import javax.inject.Inject;

public class ResponseCityActivity {

    private String status ;
    private ArrayList<CityActivity> result ;


    public ResponseCityActivity(String status, ArrayList<CityActivity> result) {
        this.status = status;
        this.result = result;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<CityActivity> getResult() {
        return result;
    }

    public void setResult(ArrayList<CityActivity> result) {
        this.result = result;
    }
}
