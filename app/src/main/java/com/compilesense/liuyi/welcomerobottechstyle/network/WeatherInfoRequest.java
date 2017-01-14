package com.compilesense.liuyi.welcomerobottechstyle.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.compilesense.liuyi.welcomerobottechstyle.application.WRApplication;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.BaiduLocationBean;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.WeatherBean;
import com.google.gson.Gson;

/**
 * Created by shenjingyuan002 on 2016/12/2.
 */

public class WeatherInfoRequest {
    private static final String TAG = "WeatherInfoRequest";
    private static final String URL = "https://api.caiyunapp.com/v2/RG-dcxFGCcHnXo5C/121.6544,25.1552/forecast.json";
    private static final String url1 = "https://api.caiyunapp.com/v2/RG-dcxFGCcHnXo5C/";
    private static final String url2 = "/forecast.json";

    private WeatherInfoRequest(){}
    private static WeatherInfoRequest instance = new WeatherInfoRequest();
    public static WeatherInfoRequest getInstance() {
        return instance;
    }
    public interface IFetchWeatherListener{
        void FetchWeather(WeatherBean weatherBean);
    }
    public void getInfo(Context context, final IFetchWeatherListener listener){
        BaiduLocationBean locationBean = LocationInfoFetch.getInstance().getInfo();
        String url;
        if (locationBean != null){
            String lng = String.valueOf(locationBean.getContent().getLocation().getLng());
            String lat = String.valueOf(locationBean.getContent().getLocation().getLat());
            url = url1 + lng + "," + lat + url2;
        }else {
            url = URL;
        }
        Log.e(TAG,"url:" + url);
        StringRequest request = new StringRequest(
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(TAG,"response:" + response);
                        Gson gson = new Gson();
                        WeatherBean weather = gson.fromJson(response, WeatherBean.class);
                        if (weather.getStatus().equals("failed")){
                            Log.e(TAG,"获取天气信息失败");
                            return;
                        }
                        listener.FetchWeather(weather);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        WRApplication app = (WRApplication) context.getApplicationContext();
        app.addRequest(request);
    }
}
