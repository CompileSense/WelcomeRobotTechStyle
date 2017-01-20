package com.compilesense.liuyi.welcomerobottechstyle.application;

import android.app.Application;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.hikvision.netsdk.ExceptionCallBack;
import com.hikvision.netsdk.HCNetSDK;

/**
 * Created by shenjingyuan002 on 2017/1/9.
 */

public class WRApplication extends Application {
    private final static String TAG = "WRApplication";
    private RequestQueue mRequestQueue;
    public String cameraIP = null,cameraAccount = null,cameraPassword = null;
    public int cameraPort = -1;
    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
        mRequestQueue.start();
        initHKSDK();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        releaseHKDSK();
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
    //启动海康网络SDK
    void initHKSDK() {
        //init net sdk
        if (!HCNetSDK.getInstance().NET_DVR_Init()) {
            Log.e(TAG, "HCNetSDK init is failed!");
            return;
        }
        setExceptionCallBack();

//        HCNetSDK.getInstance().NET_DVR_SetLogToFile(3, "/mnt/sdcard/sdklog/",true);
    }

    //释放海康网络SDK
    void releaseHKDSK() {
        // release net SDK resource
        HCNetSDK.getInstance().NET_DVR_Cleanup();
    }
    //设置网络库错误回调
    void setExceptionCallBack() {
        ExceptionCallBack oexceptionCbf = new ExceptionCallBack() {
            public void fExceptionCallBack(int iType, int iUserID, int iHandle) {
                System.out.println("recv exception, type:" + iType);
            }
        };

        if (oexceptionCbf == null) {
            Log.e(TAG, "ExceptionCallBack object is failed!");
            return;
        }

        if (!HCNetSDK.getInstance().NET_DVR_SetExceptionCallBack(oexceptionCbf)) {
            Log.e(TAG, "NET_DVR_SetExceptionCallBack is failed!");
            return;
        }
    }
}
