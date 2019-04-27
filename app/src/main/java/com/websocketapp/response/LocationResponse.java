package com.websocketapp.response;

import com.google.gson.annotations.SerializedName;

public class LocationResponse
{
    @SerializedName("t")
    private String t;

    @SerializedName("d")
    private D d;

    public String getT ()
    {
        return t;
    }

    public void setT (String t)
    {
        this.t = t;
    }

    public D getD ()
    {
        return d;
    }

    public void setD (D d)
    {
        this.d = d;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [t = "+t+", d = "+d+"]";
    }
}