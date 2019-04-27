package com.websocketapp;

import com.google.android.gms.common.api.Response;

import okhttp3.WebSocket;
import okio.ByteString;


public interface ISWMInterface {

    void onOpen(WebSocket var1, Response var2);
    void onMessage(WebSocket var1, String var2);
    void onMessage(WebSocket var1, ByteString var2);
    void onClosing(WebSocket var1, int var2, String var3);
    void onFailure(WebSocket var1, Throwable var2, Response var3);

}
