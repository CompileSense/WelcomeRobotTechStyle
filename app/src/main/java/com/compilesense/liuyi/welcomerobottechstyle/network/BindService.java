package com.compilesense.liuyi.welcomerobottechstyle.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.application.WRApplication;
import com.google.gson.Gson;

/**
 * 与服务器的后台进行绑定
 * Created by shenjingyuan002 on 2016/12/5.
 */

public class BindService {
    private final static String TAG = "BindService";
    private final static String URL = "Services/TVServices.ashx?";
    private BindService(){}
    private static BindService mInstance = new BindService();
    public static BindService getInstance() {
        return mInstance;
    }

    public void bind(final Context context, String mac, final BindListener listener){
        String url = context.getString(R.string.service_ip) + URL +
                "action=GetBinding" +
                "&clientId=" + mac;

        Log.d(TAG,"url:"+url);
        StringRequest request = new StringRequest(
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG,"response:"+ response);
                        BindResponse bindResponse = new Gson().fromJson(response, BindResponse.class);
                        if (bindResponse.getStatus().equals("Unbound")){
                            listener.failed(bindResponse.info);
                        }else {
                            listener.succeed(bindResponse.info);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,"没有连接到服务器",Toast.LENGTH_LONG).show();
                    }
                });

        WRApplication app = (WRApplication) context.getApplicationContext();
        app.addRequest(request);

    }

    public interface BindListener{
        void succeed(BindResponse.InfoBean info);
        void failed(BindResponse.InfoBean info);
    }

    public class BindResponse{

        /**
         * status : Unbound
         * info : {"serviceIp":"","servicePort":0,"canmeraIp":"","canmeraPort":0,"canmeraAccount":"","canmeraPassword":""}
         */

        public String status;
        /**
         * serviceIp :
         * servicePort : 0
         * canmeraIp :
         * canmeraPort : 0
         * canmeraAccount :
         * canmeraPassword :
         */

        public InfoBean info;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public class InfoBean {
            private String serviceIp;
            private int servicePort;
            private String canmeraIp;
            private int canmeraPort;
            private String canmeraAccount;
            private String canmeraPassword;

            public String getServiceIp() {
                return serviceIp;
            }

            public void setServiceIp(String serviceIp) {
                this.serviceIp = serviceIp;
            }

            public int getServicePort() {
                return servicePort;
            }

            public void setServicePort(int servicePort) {
                this.servicePort = servicePort;
            }

            public String getCanmeraIp() {
                return canmeraIp;
            }

            public void setCanmeraIp(String canmeraIp) {
                this.canmeraIp = canmeraIp;
            }

            public int getCanmeraPort() {
                return canmeraPort;
            }

            public void setCanmeraPort(int canmeraPort) {
                this.canmeraPort = canmeraPort;
            }

            public String getCanmeraAccount() {
                return canmeraAccount;
            }

            public void setCanmeraAccount(String canmeraAccount) {
                this.canmeraAccount = canmeraAccount;
            }

            public String getCanmeraPassword() {
                return canmeraPassword;
            }

            public void setCanmeraPassword(String canmeraPassword) {
                this.canmeraPassword = canmeraPassword;
            }
        }
    }
}
