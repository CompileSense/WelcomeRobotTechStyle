package com.compilesense.liuyi.welcomerobottechstyle.application;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by shenjingyuan002 on 2017/1/9.
 */

public class WRApplication extends Application {
    private RequestQueue mRequestQueue;
    public String cameraIP = null,cameraAccount = null,cameraPassword = null;
    public int cameraPort = -1;
    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.start();
    }

    public void addRequest(Request request){
        mRequestQueue.add(request);
    }
    public void setCameraParameters(String ip, int port, String account, String password){
        cameraIP = ip;
        cameraPort = port;
        cameraAccount = account;
        cameraPassword = password;
    }
}
