package com.websocketapp.response;

import com.google.gson.annotations.SerializedName;

public class D
{
    @SerializedName("data")
    private Data data;

    @SerializedName("topic")
    private String topic;

    private String event;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    public String getTopic ()
    {
        return topic;
    }

    public void setTopic (String topic)
    {
        this.topic = topic;
    }

    public String getEvent ()
    {
        return event;
    }

    public void setEvent (String event)
    {
        this.event = event;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", topic = "+topic+", event = "+event+"]";
    }
}
