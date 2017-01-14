package com.compilesense.liuyi.welcomerobottechstyle.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;
import com.hikvision.netsdk.ExceptionCallBack;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_DEVICEINFO_V30;
import com.hikvision.netsdk.NET_DVR_PREVIEWINFO;
import com.hikvision.netsdk.RealPlayCallBack;

import org.MediaPlayer.PlayM4.Player;
import org.MediaPlayer.PlayM4.PlayerCallBack;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    public static final String KEY_CAMERA_PARAMS = "cameraParameters";

    private NET_DVR_DEVICEINFO_V30 m_oNetDvrDeviceInfoV30;//设备信息
    private int m_iStartChan = 0;//起始通道
    private int m_iChanNum = 0;//通道个数
    int playId = -1;//网络库PlayId
    int logId = -1;//网络库登录Id

    SurfaceView mSurfaceView;//显示摄像头预览
    SurfaceHolder mSurfaceHolder;
    int m_iPort = -1;//显示通道
    static public void startMainActivity(Context context, String[] cameraParams){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(KEY_CAMERA_PARAMS,cameraParams);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageViews();
    }

    void initImageViews(){
        //bg
        ImageView bg = (ImageView) findViewById(R.id.img_bg);
        Utils.bitmapIntoImageView(this, bg, R.drawable.mian_bg,2);
        //logo
        ImageView logo = (ImageView) findViewById(R.id.img_logo);
        Utils.bitmapIntoImageView(this, logo, R.drawable.logo);
        //record count bg
        ImageView rcBg = (ImageView) findViewById(R.id.img_record_count_bg);
        Utils.bitmapIntoImageView(this, rcBg, R.drawable.recod_count_bg,4);
        //scan deco text
        ImageView sdBg = (ImageView) findViewById(R.id.img_scan_deco_text);
        Utils.bitmapIntoImageView(this, sdBg, R.drawable.scan_text_deco);
    }
}
