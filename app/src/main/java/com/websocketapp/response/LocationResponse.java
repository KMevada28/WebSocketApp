package com.websocketapp.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationResponse {

    @SerializedName("t")
    @Expose
    private int t;
    @SerializedName("d")
    @Expose
    private D d;

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

}