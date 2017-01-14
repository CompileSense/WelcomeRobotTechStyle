package com.compilesense.liuyi.welcomerobottechstyle.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.application.WRApplication;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.UISettingHttpBean;
import com.compilesense.liuyi.welcomerobottechstyle.network.BindService;
import com.compilesense.liuyi.welcomerobottechstyle.network.FetchUISetting;
import com.compilesense.liuyi.welcomerobottechstyle.network.LocationInfoFetch;
import com.compilesense.liuyi.welcomerobottechstyle.service.UDPConnectService;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;

public class SplashActivity extends AppCompatActivity {
    private final static String TAG = "SplashActivity";
    private final static int REQUEST_PERMISSION = 111;
    private final static int DELAY_TIME = 1000;

    String cameraIP = null,cameraAccount = null,cameraPassword = null;
    int cameraPort = -1;
    Bitmap bgBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initBG();
        getLocationInfo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startNext();
//        checkPermissionAndDoNext();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                startNext();//TODO 处理
                checkBindStatusAndDoNext();
            }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                Log.e(TAG,"权限申请被拒绝");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bgBitmap.recycle();
        bgBitmap = null;
    }

    private void checkPermissionAndDoNext(){
        checkPermissionAndDoNext(new DoNext() {
            @Override
            public void doNext() {
                checkBindStatusAndDoNext();
            }
        });
    }

    private void checkBindStatusAndDoNext(){

        BindService.getInstance().bind(this, Utils.getMac(), new BindService.BindListener() {
            @Override
            public void succeed(BindService.BindResponse.InfoBean info) {
                if (info.getServiceIp() == null || info.getServiceIp().equals("") || info.getServicePort() == -1){
                    Toast.makeText(SplashActivity.this, "未找到摄像头", Toast.LENGTH_LONG).show();
                }else {
//                    startConnectService(info.getServiceIp(), info.getServicePort());
                }
                cameraIP = info.getCanmeraIp();
                cameraPort = info.getCanmeraPort();
                cameraAccount = info.getCanmeraAccount();
                cameraPassword = info.getCanmeraPassword();
                startNext();
            }

            @Override
            public void failed(BindService.BindResponse.InfoBean info) {
                showDialog();
            }
        });
    }

    private void startConnectService(String serviceIp, int servicePort){
        Intent intent = new Intent(this, UDPConnectService.class);
        intent.putExtra(UDPConnectService.KEY_SERVICE_IP,serviceIp);
        intent.putExtra(UDPConnectService.KEY_SERVICE_PORT, servicePort);
        startService(intent);
    }

    interface DoNext{
        void doNext();
    }

    private void checkPermissionAndDoNext(DoNext doNext){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if (!checkPermission()){
                Log.d(TAG,"checkPermission:no pass!");
                requestPermission();
            }else {
                Log.d(TAG,"checkPermission:pass!");
                doNext.doNext();
            }
        }else {
            doNext.doNext();
        }
    }

    private void startNext(){
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
                finish();
            }
        },DELAY_TIME);
    }

    private void initBG(){
        ImageView imageView = (ImageView) findViewById(R.id.img_launch);
        bgBitmap = Utils.bitmapIntoImageView(this,imageView,R.drawable.luncher_gb);
    }
    //获取地理位置信息
    private void getLocationInfo(){
        LocationInfoFetch.getInstance().getInfo(this, null);
    }

    private boolean checkPermission(){
        Log.d(TAG,"checkPermission");

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ){
            Log.d(TAG,"WRITE_EXTERNAL_STORAGE");
            return false;
        }

        return true;
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_PERMISSION);

        ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_CONTACTS);
    }

    private void showDialog(){
        //创建一个对话框对象
        AlertDialog.Builder builder=new AlertDialog.Builder(SplashActivity.this);
        //对对话框内容进行定义
        builder.setTitle("请与平台绑定");
        builder.setMessage("本机mac地址:"+ Utils.getMac());
        //定义对话框内容的点击事件,注意后面还有个show，否则不会显示对话框
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){
            @Override
            //定义点击对话框按钮后执行的动作
            public void onClick(DialogInterface dialog, int which) {
                Log.e(TAG,"AlertDialog,onClick");
                checkBindStatusAndDoNext();
            }
        }).show();
    }
    private void startMainActivity(){

        //test
        cameraIP=getString(R.string.camera_ip);//ip
        cameraPort= Integer.parseInt(getString(R.string.camera_port));//端口
        cameraAccount=getString(R.string.camera_user);//账户
        cameraPassword=getString(R.string.camera_password);//密码

        String[] cameraParams = {
                cameraIP,//ip
                String.valueOf(cameraPort),//端口
                cameraAccount,//账户
                cameraPassword//密码
        };

        WRApplication app = (WRApplication) getApplication();
        app.setCameraParameters(cameraIP,cameraPort,cameraAccount,cameraPassword);
        MainActivity.startMainActivity(this, cameraParams);
    }
}
