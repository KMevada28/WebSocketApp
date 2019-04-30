package com.websocketapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iswm.socket.ISWMSocket;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, ISWMSocket.ISWMSocketInterface {

    private GoogleMap mMap;
    private Context mContext;
    private ISWMSocket iswmSocket;
    private double tempLat = 0;
    private double tempLon = 0;
    private Gson gson;
    private GsonBuilder gsonBuilder;
    LatLng latLng;
    ArrayList<LatLng> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mContext = this;
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
        putMarker(tempLat, tempLon);
    }

    private void putMarker(double lat, double lon) {
        if(tempLat!=0 && tempLon!=0){
            latLng = new LatLng(lat, lon);
            list.add(latLng);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Marker for Current Position"));
                    mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(latLng , 14.0f) );
                    PolylineOptions options = new PolylineOptions().width(5).color(Color.BLUE).geodesic(true);
                    for (int z = 0; z < list.size(); z++) {
                        LatLng point = list.get(z);
                        options.add(point);
                    }
                    mMap.addPolyline(options);
                }
            });
        }
    }

    private void parceJsonData(String response) {
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(response);
            System.out.println("locationResponse Object" + jsonObject);
            if (jsonObject != null) {
                JSONObject jsonObject1 = jsonObject.getJSONObject("d");
                if (jsonObject1 != null) {
                    if(jsonObject1.has("data")){
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("data");
                        if (jsonObject2 != null) {
                            tempLat = Double.parseDouble(jsonObject2.get("lat").toString());
                            tempLon = Double.parseDouble(jsonObject2.get("lng").toString());
                            putMarker(tempLat,tempLon);
                            System.out.println("LAT >>>"+Double.parseDouble(jsonObject2.get("lat").toString()));
                            System.out.println("LNG >>>"+Double.parseDouble(jsonObject2.get("lng").toString()));
                        }
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        iswmSocket.subscribeTopic("gps_data:356917056651263");
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        System.out.println("MESSAGE1:- " + s);
        parceJsonData(s);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString byteString) {
    }

    @Override
    public void onClosing(WebSocket webSocket, int i, String s) {
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
        iswmSocket.retry();
    }

}
