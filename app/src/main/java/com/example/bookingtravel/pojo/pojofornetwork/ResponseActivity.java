package com.example.bookingtravel.pojo.pojofornetwork;

import java.util.ArrayList;

public class ResponseActivity {
    private String status ;
    private ArrayList<Activity> result;

    public ResponseActivity(String status, ArrayList<Activity> result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Activity> getResult() {
        return result;
    }

    public void setResult(ArrayList<Activity> result) {
        this.result = result;
    }
}
