package com.websocketapp.response;

import com.google.gson.annotations.SerializedName;

public class Data
{
    @SerializedName("date_time_data")
    private String date_time_data;

    @SerializedName("pdop")
    private String pdop;

    @SerializedName("io_data")
    private String io_data;

    @SerializedName("lng")
    private double lng;

    @SerializedName("odometer")
    private String odometer;

    @SerializedName("y_axis")
    private String y_axis;

    @SerializedName("x_axis")
    private String x_axis;

    @SerializedName("device_type")
    private String device_type;

    @SerializedName("ignition_status")
    private String ignition_status;

    @SerializedName("hdop")
    private String hdop;

    @SerializedName("speed")
    private String speed;

    @SerializedName("sat_count")
    private String sat_count;

    @SerializedName("z_axis")
    private String z_axis;

    @SerializedName("total_distance")
    private String total_distance;

    @SerializedName("imei")
    private String imei;

    @SerializedName("server_datetime")
    private String server_datetime;

    @SerializedName("lat")
    private double lat;

    @SerializedName("direction")
    private String direction;

    public String getDate_time_data ()
    {
        return date_time_data;
    }

    public void setDate_time_data (String date_time_data)
    {
        this.date_time_data = date_time_data;
    }

    public String getPdop ()
    {
        return pdop;
    }

    public void setPdop (String pdop)
    {
        this.pdop = pdop;
    }

    public String getIo_data ()
    {
        return io_data;
    }

    public void setIo_data (String io_data)
    {
        this.io_data = io_data;
    }

    public double getLng ()
    {
        return lng;
    }

    public void setLng (double lng)
    {
        this.lng = lng;
    }

    public String getOdometer ()
    {
        return odometer;
    }

    public void setOdometer (String odometer)
    {
        this.odometer = odometer;
    }

    public String getY_axis ()
    {
        return y_axis;
    }

    public void setY_axis (String y_axis)
    {
        this.y_axis = y_axis;
    }

    public String getX_axis ()
    {
        return x_axis;
    }

    public void setX_axis (String x_axis)
    {
        this.x_axis = x_axis;
    }

    public String getDevice_type ()
    {
        return device_type;
    }

    public void setDevice_type (String device_type)
    {
        this.device_type = device_type;
    }

    public String getIgnition_status ()
    {
        return ignition_status;
    }

    public void setIgnition_status (String ignition_status)
    {
        this.ignition_status = ignition_status;
    }

    public String getHdop ()
    {
        return hdop;
    }

    public void setHdop (String hdop)
    {
        this.hdop = hdop;
    }

    public String getSpeed ()
    {
        return speed;
    }

    public void setSpeed (String speed)
    {
        this.speed = speed;
    }

    public String getSat_count ()
    {
        return sat_count;
    }

    public void setSat_count (String sat_count)
    {
        this.sat_count = sat_count;
    }

    public String getZ_axis ()
    {
        return z_axis;
    }

    public void setZ_axis (String z_axis)
    {
        this.z_axis = z_axis;
    }

    public String getTotal_distance ()
    {
        return total_distance;
    }

    public void setTotal_distance (String total_distance)
    {
        this.total_distance = total_distance;
    }

    public String getImei ()
    {
        return imei;
    }

    public void setImei (String imei)
    {
        this.imei = imei;
    }

    public String getServer_datetime ()
    {
        return server_datetime;
    }

    public void setServer_datetime (String server_datetime)
    {
        this.server_datetime = server_datetime;
    }

    public double getLat ()
    {
        return lat;
    }

    public void setLat (double lat)
    {
        this.lat = lat;
    }

    public String getDirection ()
    {
        return direction;
    }

    public void setDirection (String direction)
    {
        this.direction = direction;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date_time_data = "+date_time_data+", pdop = "+pdop+", io_data = "+io_data+", lng = "+lng+", odometer = "+odometer+", y_axis = "+y_axis+", x_axis = "+x_axis+", device_type = "+device_type+", ignition_status = "+ignition_status+", hdop = "+hdop+", speed = "+speed+", sat_count = "+sat_count+", z_axis = "+z_axis+", total_distance = "+total_distance+", imei = "+imei+", server_datetime = "+server_datetime+", lat = "+lat+", direction = "+direction+"]";
    }
}
			
			