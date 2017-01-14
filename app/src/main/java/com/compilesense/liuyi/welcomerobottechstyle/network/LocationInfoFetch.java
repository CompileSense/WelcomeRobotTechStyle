package com.compilesense.liuyi.welcomerobottechstyle.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.compilesense.liuyi.welcomerobottechstyle.application.WRApplication;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.BaiduLocationBean;
import com.google.gson.Gson;

/**
 * Created by shenjingyuan002 on 2016/12/2.
 */

@SuppressWarnings("SpellCheckingInspection")
public class LocationInfoFetch {
    private static final String TAG = "LocationInfoFetch";
    private static final String BaiduUrl = "https://api.map.baidu.com/highacciploc/v1?&ak=UfI1Xrva51HSG9B079VGRHF9mqLQGXwm&qterm=pc&extensions=1&coord=bd09ll&coding=utf-8";

    private LocationInfoFetch(){}
    private static LocationInfoFetch instance = new LocationInfoFetch();
    public static LocationInfoFetch getInstance() {
        return instance;
    }
    private static BaiduLocationBean mLocationBean;
    interface IFetchLocationInfoListener{
        void getInfo(BaiduLocationBean baiduLocationBean);
    }

    BaiduLocationBean getInfo(){
        if (mLocationBean != null){
            return mLocationBean;
        }else {
            Log.d(TAG,"mLocationBean == null");
        }
        return null;
    }

    public void getInfo(Context context, final IFetchLocationInfoListener listener){
        if (mLocationBean != null && listener != null){
            listener.getInfo(mLocationBean);
            return;
        }
        StringRequest request = new StringRequest(BaiduUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        BaiduLocationBean locationBean = new Gson().fromJson(response, BaiduLocationBean.class);
                        if (listener != null){
                            listener.getInfo(locationBean);
                        }
                        mLocationBean = locationBean;

                        Log.d(TAG,"locationInfo:" + mLocationBean.getContent().getFormatted_address());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        WRApplication app = (WRApplication) context.getApplicationContext();
        app.addRequest(request);
    }
}
