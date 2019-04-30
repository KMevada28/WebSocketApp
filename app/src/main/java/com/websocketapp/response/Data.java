package com.websocketapp.response;

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("imei")
    @Expose
    private int imei;
    @SerializedName("device_type")
    @Expose
    private String deviceType;
    @SerializedName("date_time_data")
    @Expose
    private String dateTimeData;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lng")
    @Expose
    private double lng;
    @SerializedName("speed")
    @Expose
    private int speed;
    @SerializedName("hdop")
    @Expose
    private int hdop;
    @SerializedName("pdop")
    @Expose
    private int pdop;
    @SerializedName("direction")
    @Expose
    private int direction;
    @SerializedName("sat_count")
    @Expose
    private int satCount;
    @SerializedName("odometer")
    @Expose
    private int odometer;
    @SerializedName("ignition_status")
    @Expose
    private int ignitionStatus;
    @SerializedName("x_axis")
    @Expose
    private int xAxis;
    @SerializedName("y_axis")
    @Expose
    private int yAxis;
    @SerializedName("z_axis")
    @Expose
    private int zAxis;
    @SerializedName("io_data")
    @Expose
    private IoData ioData;
    @SerializedName("server_datetime")
    @Expose
    private String serverDatetime;
    @SerializedName("total_distance")
    @Expose
    private double totalDistance;

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDateTimeData() {
        return dateTimeData;
    }

    public void setDateTimeData(String dateTimeData) {
        this.dateTimeData = dateTimeData;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHdop() {
        return hdop;
    }

    public void setHdop(int hdop) {
        this.hdop = hdop;
    }

    public int getPdop() {
        return pdop;
    }

    public void setPdop(int pdop) {
        this.pdop = pdop;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSatCount() {
        return satCount;
    }

    public void setSatCount(int satCount) {
        this.satCount = satCount;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public int getIgnitionStatus() {
        return ignitionStatus;
    }

    public void setIgnitionStatus(int ignitionStatus) {
        this.ignitionStatus = ignitionStatus;
    }

    public int getXAxis() {
        return xAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public int getZAxis() {
        return zAxis;
    }

    public void setZAxis(int zAxis) {
        this.zAxis = zAxis;
    }

    public IoData getIoData() {
        return ioData;
    }

    public void setIoData(IoData ioData) {
        this.ioData = ioData;
    }

    public String getServerDatetime() {
        return serverDatetime;
    }

    public void setServerDatetime(String serverDatetime) {
        this.serverDatetime = serverDatetime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

}