package com.example.bookingtravel.pojo.pojofornetwork;

import java.util.ArrayList;

public class ResponseCity {

    private String status ;
    private ArrayList<City> result ;

    public ResponseCity(String status, ArrayList<City> result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<City> getResult() {
        return result;
    }

    public void setResult(ArrayList<City> result) {
        this.result = result;
    }
}
