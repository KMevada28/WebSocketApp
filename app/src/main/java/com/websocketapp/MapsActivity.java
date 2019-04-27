package com.websocketapp;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iswm.socket.ISWMSocket;
import com.websocketapp.response.D;
import com.websocketapp.response.Data;
import com.websocketapp.response.LocationResponse;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, ISWMSocket.ISWMSocketInterface {

    private GoogleMap mMap;
    private Context mContext;
    private ISWMSocket iswmSocket;
    private double dummyLat = -34;
    private double dummyLon = 150;
    private Gson gson;
    private GsonBuilder gsonBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mContext = this;
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        getSocketObject();
    }

    private void getSocketObject() {
        iswmSocket =
                new ISWMSocket(
                        mContext,
                        "iswm-dev.acceldash.com",
                        "80");
        iswmSocket.start();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        putMarker(dummyLat, dummyLon);


    }

    private void putMarker(double lat, double lon) {
        LatLng sydney = new LatLng(lat, lat);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private void parceJsonData(String response) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);
            System.out.println("locationResponse Object" + jsonObject);
            if (jsonObject != null) {
                JSONObject jsonObject1 = jsonObject.getJSONObject("d");
                if (jsonObject1 != null) {
                    JSONObject jsonObject2 = jsonObject1.getJSONObject("data");
                    if (jsonObject2 != null) {
                        putMarker(Double.parseDouble(jsonObject2.get("lat").toString()),
                                Double.parseDouble(jsonObject2.get("lng").toString()));
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        iswmSocket.subscribeTopic("gps_data:356917057992922");
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        System.out.println("MESSAGE1:- " + s);
        parceJsonData(s);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString byteString) {
        //System.out.println("MESSAGE2:- " + byteString);

    }

    @Override
    public void onClosing(WebSocket webSocket, int i, String s) {
        //System.out.println("MESSAGE3:- " + i);
        //System.out.println("MESSAGE4:- " + s);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
        iswmSocket.retry();
        //System.out.println("CAUSE"+throwable.getCause());
        //System.out.println("MESSAGE"+throwable.getMessage());
    }

}
