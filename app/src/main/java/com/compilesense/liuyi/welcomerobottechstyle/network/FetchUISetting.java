package com.compilesense.liuyi.welcomerobottechstyle.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.application.WRApplication;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.UISettingHttpBean;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;
import com.google.gson.Gson;

/**
 * Created by shenjingyuan002 on 2016/12/6.
 */

public class FetchUISetting {
    private final static String TAG = "FetchUISetting";
    private FetchUISetting(){}
    private static final FetchUISetting instance = new FetchUISetting();
    public static FetchUISetting getInstance() {
        return instance;
    }

    public void fetchTodayRecord(Context context, final TodayRecordListner listner){
        String url = context.getString(R.string.service_ip)+"Services/TVServices.ashx?action=TotalRecognition";
        Log.d(TAG,"fetchTodayRecord url:"+url);
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        try {
                            TodayRecordResponse recordResponse = gson.fromJson(response,TodayRecordResponse.class);
                            if (recordResponse.getStatus().equals("successful")){
                                listner.get(recordResponse.getTotal());
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
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



    public void fetch(Context context, final UISettingListener listener){
//        String url = "http://192.168.0.62:9002/"+"Services/TVServices.ashx?action=GetUIInfo&clientId=00:9e:c8:8c:5e:12";
        String url = context.getString(R.string.service_ip)+"Services/TVServices.ashx?action=GetUIInfo&clientId="+ Utils.getMac();
        Log.d(TAG,"url:"+url);
        StringRequest request = new StringRequest(
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(TAG,"response:"+response);
                        try {
                            UISettingHttpBean uiSettingHttpBean = new Gson().fromJson(response,UISettingHttpBean.class);
                            String content = uiSettingHttpBean.getNotifyContent();
                            Log.d(TAG,"con:" + content);
                            listener.get(uiSettingHttpBean);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
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
//        Volley.newRequestQueue(context).add(request);
    }

    public interface UISettingListener{
        void get(UISettingHttpBean bean);
    }

    public interface TodayRecordListner{
        void get(String todayRecord);
    }

    public class TodayRecordResponse{

        /**
         * status : successful
         * total : 0
         */

        private String status;
        private String total;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }

}
