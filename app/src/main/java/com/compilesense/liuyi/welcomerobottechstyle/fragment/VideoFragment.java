package com.compilesense.liuyi.welcomerobottechstyle.fragment;


import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.application.WRApplication;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_DEVICEINFO_V30;
import com.hikvision.netsdk.NET_DVR_PREVIEWINFO;
import com.hikvision.netsdk.RealPlayCallBack;

import org.MediaPlayer.PlayM4.Player;
import org.MediaPlayer.PlayM4.PlayerCallBack;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment {
    private static final String TAG = "VideoFragment";
    private static final String ARG_IP = "ip";
    private static final String ARG_PORT = "port";
    private static final String ARG_ACCOUNT = "account";
    private static final String ARG_PASSWORD = "password";

    String cameraIP = null,cameraAccount = null,cameraPassword = null;
    int cameraPort = -1;

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    private NET_DVR_DEVICEINFO_V30 m_oNetDvrDeviceInfoV30;//设备信息
    private int m_iStartChan = 0;//起始通道
    private int m_iChanNum = 0;//通道个数
    int playId = -1;//网络库PlayId
    int logId = -1;//网络库登录Id

    public SurfaceView mSurfaceView;//显示摄像头预览
    SurfaceHolder mSurfaceHolder;
    int m_iPort = -1;//显示通道

    Timer timer;

    byte[] data;
    int params1;
    int params2;
    int params3;

    public static VideoFragment newInstance(){
        Log.d(TAG,"newInstance");
        return new VideoFragment();
    }
    public VideoFragment() {
        // Required empty public constructor
    }

    public static VideoFragment newInstance(String ip, int port, String account, String password) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_IP, ip);
        args.putInt(ARG_PORT, port);
        args.putString(ARG_ACCOUNT, account);
        args.putString(ARG_PASSWORD, password);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            cameraIP = getArguments().getString(ARG_IP);
            cameraPort = getArguments().getInt(ARG_PORT);
            cameraAccount = getArguments().getString(ARG_ACCOUNT);
            cameraPassword = getArguments().getString(ARG_PASSWORD);
        }else {
            WRApplication app = (WRApplication) getContext().getApplicationContext();
            cameraIP = app.cameraIP;
            cameraPort = app.cameraPort;
            cameraAccount = app.cameraAccount;
            cameraPassword = app.cameraPassword;
        }
        timer = new Timer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onActivityCreated");
        //video bg
//        ImageView videoBg = (ImageView) getView().findViewById(R.id.img_video_bg);
//        Utils.bitmapIntoImageView(getContext(), videoBg, R.drawable.video_bg2,2);
        initSurfaceView();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
        previewRestart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        logoutDevice(logId);
    }

    //启动摄像头:登录、开启预览
    void starNetWorkCamera(){
        String ip = cameraIP;
        int port = cameraPort;
        String user = cameraAccount;
        String password = cameraPassword;
        if (ip == null || port== -1){
            Log.d(TAG,"没有摄像头参数");
            return;
        }
//        String ip = getString(R.string.camera_ip);
//        String port = getString(R.string.camera_port);
//        String user = getString(R.string.camera_user);
//        String password = getString(R.string.camera_password);
        loginDevice(ip, port, user, password);
        Log.d(TAG,"登录camera:" +logId);
        startSinglePreview();
    }

    //初始化SurfaceView
    void initSurfaceView(){
        mSurfaceView = (SurfaceView) getView().findViewById(R.id.sv);

//        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//                mSurfaceHolder = holder;
//                starNetWorkCamera();
//                wkorking = true;
//                new Thread(drawWorker).start();
//                //开启工作线程并设置预览区域和对调
////                Worker.getInstance()
////                        .setCallBack(new Worker.IFaceDetectionCallBack() {
////                            @Override
////                            public void catchFace(Mat[] faces, int faceCount) {
////                                if (faces != null && faceCount > 0 ){
////                                    if (!isRecognizing){
////                                        isRecognizing = true;
////                                        Message message = new Message();
////                                        message.what = MESSAGE_CATCH_FACE;
////                                        message.obj = faces;
////                                        message.arg1 = faceCount;
////                                        mHandler.sendMessage(message);
////                                    }
////                                }
////                            }
////                        })
////                        .setSurfaceHolder(holder,mSurfaceView)
////                        .loadFaceDetector(MainActivity.this)
////                        .startWork();
//            }
//
//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//                mSurfaceHolder = holder;
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
////                Worker.getInstance().stopWork();
//                wkorking = false;
//                mSurfaceHolder = null;
//                stopSinglePreview();
//            }
//        });

        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mSurfaceHolder = holder;
                mSurfaceView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
                Log.i(TAG, "surface is created" + m_iPort);
                if (-1 == m_iPort) {
                    return;
                }
                Surface surface = holder.getSurface();
                if (surface.isValid()) {
                    if (!Player.getInstance().setVideoWindow(m_iPort, 0, holder)) {
                        Log.e(TAG, "Player setVideoWindow failed!");
                    }
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                mSurfaceHolder = holder;
                Log.d(TAG,"surfaceChanged");
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mSurfaceHolder = null;
                Log.i(TAG, "Player setVideoWindow release!" + m_iPort);
                if (-1 == m_iPort)
                {
                    return;
                }
                if (holder.getSurface().isValid()) {
                    if (!Player.getInstance().setVideoWindow(m_iPort, 0, null)) {
                        Log.e(TAG, "Player setVideoWindow failed!");
                    }
                }
                stopSinglePreview();
            }
        });
    }

    //登录设备
    private void loginDevice(String strIP, int nPort, String strUser, String strPsd) {
        // get instance
        m_oNetDvrDeviceInfoV30 = new NET_DVR_DEVICEINFO_V30();
        if (null == m_oNetDvrDeviceInfoV30) {
            Log.e(TAG, "HKNetDvrDeviceInfoV30 new is failed!");
            logId =  -1;
        }
        int iLogID = HCNetSDK.getInstance().NET_DVR_Login_V30(strIP, nPort, strUser, strPsd, m_oNetDvrDeviceInfoV30);
        if (iLogID < 0) {
            Log.e(TAG, "NET_DVR_Login is failed!Err:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
            logId =  -1;
        }
        if (m_oNetDvrDeviceInfoV30.byChanNum > 0) {
            m_iStartChan = m_oNetDvrDeviceInfoV30.byStartChan;
            m_iChanNum = m_oNetDvrDeviceInfoV30.byChanNum;
        } else if (m_oNetDvrDeviceInfoV30.byIPChanNum > 0) {
            m_iStartChan = m_oNetDvrDeviceInfoV30.byStartDChan;
            m_iChanNum = m_oNetDvrDeviceInfoV30.byIPChanNum + m_oNetDvrDeviceInfoV30.byHighDChanNum * 256;
        }

        Log.i(TAG, "NET_DVR_Login is Successful!");
        Log.d(TAG, "通道个数:" + m_iChanNum);
        Log.d(TAG, "起始通道:" + m_iStartChan);
        logId =  iLogID;
    }

    //登出设备
    void logoutDevice(int logId) {
        if (!HCNetSDK.getInstance().NET_DVR_Logout_V30(logId)) {
            Log.e(TAG, " NET_DVR_Logout is failed!");
        }
    }

    //开启预览
    int startSinglePreview() {

        RealPlayCallBack fRealDataCallBack = new RealPlayCallBack() {
            public void fRealDataCallBack(int iRealHandle, int iDataType, byte[] pDataBuffer, int iDataSize) {
                processRealData(iDataType, pDataBuffer, iDataSize, Player.STREAM_REALTIME);
            }
        };

        NET_DVR_PREVIEWINFO previewInfo = new NET_DVR_PREVIEWINFO();
        previewInfo.lChannel = m_iStartChan;
        previewInfo.dwStreamType = 2; //substream
        previewInfo.bBlocked = 0;
        // HCNetSDK start preview
        playId = HCNetSDK.getInstance().NET_DVR_RealPlay_V40(logId, previewInfo, fRealDataCallBack);
        if (playId < 0) {
            Log.e(TAG, "NET_DVR_RealPlay is failed!Err:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
            return -1;
        }
        Log.i(TAG, "NetSdk Play success ***********************3***************************");
        Log.d(TAG,"开始play playId:" + playId + ", port: " + m_iPort);
        return playId;
    }

    //停止预览
    void stopSinglePreview() {
        if (!HCNetSDK.getInstance().NET_DVR_StopRealPlay(playId)) {
            Log.e(TAG, "StopRealPlay is failed!Err:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
            return;
        }
        playId = -1;
        stopSinglePlayer();
    }
    private void stopSinglePlayer() {
        Player.getInstance().stopSound();
        // player stop play
        if (!Player.getInstance().stop(m_iPort))
        {
            Log.e(TAG, "stop is failed!");
            return;
        }

        if(!Player.getInstance().closeStream(m_iPort))
        {
            Log.e(TAG, "closeStream is failed!");
            return;
        }
        if(!Player.getInstance().freePort(m_iPort))
        {
            Log.e(TAG, "freePort is failed!" + m_iPort);
            return;
        }
        m_iPort = -1;
        Log.d(TAG,"停止play playId:" + playId + ", port: " + m_iPort);
    }


    //处理网络库中的数据
    void processRealData(int iDataType, byte[] pDataBuffer, int iDataSize, int iStreamMode){

        if(HCNetSDK.NET_DVR_SYSHEAD == iDataType){
            if (m_iPort >= 0){
                return;
            }

            m_iPort = Player.getInstance().getPort();//获取端口
            if(m_iPort == -1) {
                Log.e(TAG, "getPort is failed with: " + Player.getInstance().getLastError(m_iPort));
                return;
            }
            Log.i(TAG, "getPort succ with: " + m_iPort);
//            Log.d(TAG,"处理数据 playId:" + playId + ", port: " + m_iPort);
            if (iDataSize > 0){
                if (!Player.getInstance().setStreamOpenMode(m_iPort, iStreamMode))  //set stream mode
                {
                    Log.e(TAG, "setStreamOpenMode failed");
                    return;
                }
                if (!Player.getInstance().openStream(m_iPort, pDataBuffer, iDataSize, 6*1024*1024)) //open stream
                {
                    Log.e(TAG, "openStream failed");
                    return;
                }

//                if (!Player.getInstance().setDecodeCB(m_iPort, new PlayerCallBack.PlayerDecodeCB() {
//                    @Override
//                    public void onDecode(int i, byte[] bytes, int i1, int i2, int i3, int i4, int i5, int i6) {
//                        synchronized (this){
//                            data = bytes;
//                            params1 = i5;//type
//                            params2 = i3;//h
//                            params3 = i2;//w
//                        }
//                    }
//                })) {
//                    Log.e(TAG, "setDecodeCB failed");
//                    return;
//                }
                if (!Player.getInstance().setDisplayCB(m_iPort, new PlayerCallBack.PlayerDisplayCB() {
                    @Override
                    public void onDisplay(int i, byte[] bytes, int i1, int i2, int i3, int i4, int i5, int i6) {
//                        Log.d("displayCallBack","width:" + i2);
//                        Log.d("displayCallBack","height:" + i3);
//                        Log.d("displayCallBack","nDataType:" + i5);
//                        Log.d(TAG,"displayCallBackdata size:" + i1);
//                        Log.d("displayCallBack","data first:" + bytes[0] + "mid1:"+bytes[i1 / 4] + "mid2:"+bytes[i1 / 2] + "mid3:"+bytes[i1 * 3 / 4]  + "last:" + bytes[i1 - 1]);

//                            YuvImage
                    }
                })){
                    Log.e(TAG, "setDisplayCB failed");
                    return;
                }
                if (!Player.getInstance().play(m_iPort, mSurfaceView.getHolder())) {
                    Log.e(TAG, "play failed");
                    return;
                }
            }
        } else {
            if (!Player.getInstance().inputData(m_iPort, pDataBuffer, iDataSize))
            {
//		    		Log.e(TAG, "inputData failed with: " + Player.getInstance().getLastError(m_iPort));
//                for(int i = 0; i < 4000 && playId >=0 ; i++)
//                {
//                    if (!Player.getInstance().inputData(m_iPort, pDataBuffer, iDataSize)){
//                        //                        Log.e(TAG, "inputData failed with: " + Player.getInstance().getLastError(m_iPort));
//                    }
//                    else
//                        break;
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
            }

        }
    }


//    boolean wkorking = false;
//    Bitmap bitmapCache;
//    Runnable drawWorker = new Runnable() {
//        @Override
//        public void run() {
//            while (wkorking){
//
//                if (data == null) {
//                    continue;
//                }
//                if (params1 != VideoFrame.TYPE_YV12) {
//                    Log.e("VideoFrame", "srcType != TYPE_YV12");
//                    continue;
//                }
//                VideoFrame videoFrame = new VideoFrame(params1, params2, params3);
//                synchronized (this) {
//                    videoFrame.putData(data);
//                }
//                videoFrame.useData();
//                Mat rgba = videoFrame.rgba();
//
//                if (bitmapCache == null){
//                    bitmapCache = Bitmap.createBitmap(rgba.width(),rgba.height(), Bitmap.Config.ARGB_8888);
//                    Log.d(TAG,"cacheBitmap:"+bitmapCache.getWidth()+"*"+bitmapCache.getHeight());
//                    Log.d(TAG,"mRgba:"+rgba.width()+"*"+rgba.height());
//                }
//                if (bitmapCache.getHeight() != rgba.height() || bitmapCache.getWidth() != rgba.width()){
//                    Log.d(TAG,"cacheBitmap:"+bitmapCache.getWidth()+"*"+bitmapCache.getHeight());
//                    Log.d(TAG,"mRgba:"+rgba.width()+"*"+rgba.height());
//                    bitmapCache.recycle();
//                    bitmapCache = Bitmap.createBitmap(rgba.width(),rgba.height(), Bitmap.Config.ARGB_8888);
//                }
//                org.opencv.android.Utils.matToBitmap(rgba,bitmapCache);
//                Canvas canvas = mSurfaceHolder.lockCanvas();
//                if (canvas == null){
//                    Log.e(TAG,"canvas == null");
//                    continue;
//                }
//                canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
//                canvas.drawBitmap(bitmapCache,null,new android.graphics.Rect(0, 0, bitmapCache.getWidth(), bitmapCache.getHeight()),null);
//                mSurfaceHolder.unlockCanvasAndPost(canvas);
//                videoFrame.release();
//            }
//        }
//    };


    boolean previewShowing = false;

    void previewRestart(){

        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!previewShowing){
                    starNetWorkCamera();
                    previewShowing = true;
                }else {
                    stopSinglePreview();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int r = startSinglePreview();
                    if (r == -1){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        startSinglePreview();
                    }
                }
            }
        }, 1000L,1000*60*30L, TimeUnit.MILLISECONDS);
    }
}
