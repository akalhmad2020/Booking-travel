package com.example.bookingtravel.pojo.pojofornetwork;

import java.util.ArrayList;

public class ResponseCountry {

    private String status ;
    private ArrayList<Country> result ;

    public ResponseCountry(String status, ArrayList<Country> result) {
        this.status = status;
        this.result = result;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Country> getResult() {
        return result;
    }

    public void setResult(ArrayList<Country> result) {
        this.result = result;
    }
}
