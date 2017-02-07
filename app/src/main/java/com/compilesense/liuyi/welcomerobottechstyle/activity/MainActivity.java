package com.compilesense.liuyi.welcomerobottechstyle.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.fragment.BirthdayFragment;
import com.compilesense.liuyi.welcomerobottechstyle.fragment.FaceFragment;
import com.compilesense.liuyi.welcomerobottechstyle.fragment.NotifyFragment;
import com.compilesense.liuyi.welcomerobottechstyle.fragment.RecordFragment;
import com.compilesense.liuyi.welcomerobottechstyle.fragment.TimeFragment;
import com.compilesense.liuyi.welcomerobottechstyle.fragment.VideoFragment;
import com.compilesense.liuyi.welcomerobottechstyle.fragment.VisitorFragment;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.UISettingBean;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.UISettingHttpBean;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.VisitorsInfoBean;
import com.compilesense.liuyi.welcomerobottechstyle.network.FetchUISetting;
import com.compilesense.liuyi.welcomerobottechstyle.service.UDPConnectService;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    public static final String KEY_CAMERA_PARAMS = "cameraParameters";

    private FrameLayout flVisitorContainer;

    //不想在程序中新初始化VisitorFragment实例,在这里实例化4个来复用。
    private VisitorFragment[] visitorFragmentsStaff = new VisitorFragment[2];
    private VisitorFragment[] visitorFragmentsStranger = new VisitorFragment[2];
    private int indexVF = -1;

    private VideoFragment videoFragment;
    private ImageView tdc;
    private FrameLayout videoFrameLayout,faceFrameLayout,notifyFragment,
            timeFrameLayout,recordFrameLayout,weatherFrameLayout,birthdayFrameLayout;

    private List<View> decorViewList = new ArrayList<>();
    private boolean layoutStatus = true;//true 为本来样式,false 改变后
    private final float VIDEO_SCALE_ARG = 1.5f;
    private int disW; //屏幕宽度

    //visitor
    //来宾信息队列
    private final static int MAX_PERSON_COUNT = 5;
    private final static int DURATION_ONE_PERSON = 2000;//mm

    private final static int SHOW_NONE = 0;
    private final static int SHOW_ONE = 1;
    private final static int SHOW_ADD = 2;
    private final static int SHOW_CHANGEING = 9;

    private BlockingQueue<String> personQueue = new ArrayBlockingQueue<>(MAX_PERSON_COUNT);
    private Thread mShowVisitorWorkerThread;
    boolean showVisitorWorkerRunning;
    int showVisitorStatus = SHOW_NONE;//定义显示状态


    private int recordCount = 0;
    private TextView tvRecordCount;

    private static final int MSG_UP_DATA_RECORD = 898;

    /**
     * 来宾广播接收机,后台 Service 接收到平台下发的来宾信息会发送广播,本 Receiver 接受该广播并展示来宾数据。
     * 最开始设计为直接收来宾广播,后来要接收用户设置更新广播。
     */
    public class VisitorArriveBroadcastReceiver extends BroadcastReceiver {
        public static final String ACTION = "com.compilesense.liuyi.welcomerobot.visitorcoming";
        public static final String KEY_PERSON_INFO = "personIds";

        public static final String KEY_UI_UPDATA = "uiUpData";
        @Override
        public void onReceive(Context context, Intent intent) {

            String personInfo = intent.getStringExtra(KEY_PERSON_INFO);
            String uiSettingJsonString = intent.getStringExtra(KEY_UI_UPDATA);

            if (personInfo != null){
                Log.e(TAG,"收到广播,类型:personInfo" + personInfo);
                boolean offer = personQueue.offer(personInfo);
                if (offer){
                    recordCount++;
                }
            }else if (uiSettingJsonString != null){
                Log.e(TAG,"收到广播,类型:uiSetting");
                UISettingBean uiSettingBean = new Gson().fromJson(uiSettingJsonString, UISettingBean.class);
                Log.d(TAG,"onReceive WeatherBg:"+ uiSettingBean.getMessage().getWeatherBg());
                //TODO upDataViews(uiSettingBean);
            }
        }
    }
    VisitorArriveBroadcastReceiver mBroadcastReceiver = new VisitorArriveBroadcastReceiver();

    static public void startMainActivity(Context context, String[] cameraParams){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(KEY_CAMERA_PARAMS,cameraParams);
        context.startActivity(intent);
    }

    boolean visitorShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initFragments();
        initWorkers();
    }

    void initWorkers(){
        ShowVisitorWorker showVisitorWorker = new ShowVisitorWorker();
        showVisitorWorkerRunning = true;
        mShowVisitorWorkerThread = new Thread(showVisitorWorker);
        mShowVisitorWorkerThread.start();
    }

    void initViews(){
        WindowManager wm = this.getWindowManager();
        disW = wm.getDefaultDisplay().getWidth();

        flVisitorContainer = (FrameLayout) findViewById(R.id.fl_visitor_container);
        //bg
        ImageView bg = (ImageView) findViewById(R.id.img_bg);
        Utils.bitmapIntoImageView(this, bg, R.drawable.mian_bg,4);
        //logo
        ImageView logo = (ImageView) findViewById(R.id.img_logo);
        Utils.bitmapIntoImageView(this, logo, R.drawable.logo,4);
        //record count bg
        ImageView rcBg = (ImageView) findViewById(R.id.img_record_count_bg);
        Utils.bitmapIntoImageView(this, rcBg, R.drawable.recod_count_bg,4);
        //scan deco text
        ImageView sdBg = (ImageView) findViewById(R.id.img_scan_deco_text);
        Utils.bitmapIntoImageView(this, sdBg, R.drawable.scan_text_deco,4);

        tdc = (ImageView) findViewById(R.id.img_tdc);
        Utils.bitmapIntoImageView(this, tdc, R.drawable.tdcode,4);

        videoFrameLayout = (FrameLayout) findViewById(R.id.fl_video);
        faceFrameLayout     = (FrameLayout) findViewById(R.id.fl_face);
        timeFrameLayout     = (FrameLayout) findViewById(R.id.fl_time);
        recordFrameLayout   = (FrameLayout) findViewById(R.id.fl_record);
        weatherFrameLayout   = (FrameLayout) findViewById(R.id.fl_weather);
        birthdayFrameLayout = (FrameLayout) findViewById(R.id.fl_birthday);
        notifyFragment = (FrameLayout) findViewById(R.id.fl_notify);

        View tvScan = findViewById(R.id.tv_scan);
        View imgScan = findViewById(R.id.img_scan_deco_text);
        decorViewList.add(tvScan);
        decorViewList.add(imgScan);

        tvRecordCount = (TextView) findViewById(R.id.tv_record_count_number);

        FetchUISetting.getInstance().fetchTodayRecord(this, new FetchUISetting.TodayRecordListner() {
            @Override
            public void get(final String todayRecord) {
                tvRecordCount.post(new Runnable() {
                    @Override
                    public void run() {
                        tvRecordCount.setText(todayRecord);
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        videoFragment = VideoFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_video_container,videoFragment).commit();
        registerReceiver();

        FetchUISetting.getInstance().fetch(this, new FetchUISetting.UISettingListener() {
            @Override
            public void get(UISettingHttpBean bean) {
                upDataViews(bean);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
//        stopService();
//        unregisterReceiver();
        finish();   //TODO 记得开启
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService();
        unregisterReceiver();
    }

    void upDataViews(UISettingHttpBean bean){
        NotifyFragment notifyFragment = (NotifyFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_notify);
        notifyFragment.setNotify(bean.getNotifyContent(),
                bean.getNotifyDate(),
                bean.getNotifyTime(),
                bean.getNotifyDuration());

        BirthdayFragment birthdayFragment = (BirthdayFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_birthday);
        List<UISettingHttpBean.PersonBirthdayBean> personBirthdayBeen = bean.getPersonBirthday();
        birthdayFragment.setBirthdayInfo(personBirthdayBeen);
    }

    //注册宾客到达广播接收机
    void registerReceiver(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VisitorArriveBroadcastReceiver.ACTION);
        registerReceiver(mBroadcastReceiver,intentFilter);
    }

    //注销宾客到达广播接收机
    void unregisterReceiver(){
        unregisterReceiver(mBroadcastReceiver);
    }

    void stopService(){
        Intent intent = new Intent(this, UDPConnectService.class);
        stopService(intent);
    }

    void initFragments(){
        visitorFragmentsStaff[0] = VisitorFragment.newInstance(VisitorFragment.VISITOR_TYPE_STAFF);
        visitorFragmentsStaff[1] = VisitorFragment.newInstance(VisitorFragment.VISITOR_TYPE_STAFF);
        visitorFragmentsStranger[0] = VisitorFragment.newInstance(VisitorFragment.VISITOR_TYPE_STRANGER);
        visitorFragmentsStranger[1] = VisitorFragment.newInstance(VisitorFragment.VISITOR_TYPE_STRANGER);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //test
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            recordCount++;//test
            if (flVisitorContainer.getVisibility() == View.GONE){
                flVisitorContainer.setVisibility(View.VISIBLE);
                visitorShowing = true;
                indexVF = 0;
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_top, R.anim.slide_out_bottom)
                        .add(R.id.fl_visitor_container, visitorFragmentsStaff[indexVF])
                        .commitNow();
                visitorFragmentsStaff[indexVF].setPersonInfo(VisitorsInfoBean.testJsonString1);
            }else if (flVisitorContainer.getVisibility() == View.VISIBLE && visitorShowing) {
                Log.d(TAG,"AddVisitor");
                handAddVisitor(R.id.fl_visitor_container);
            }
            return true;
        }

        //test
        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN ) {

            if (flVisitorContainer.getVisibility() == View.VISIBLE){
                flVisitorContainer.setVisibility(View.GONE);
                visitorShowing = false;

                if (indexVF > 1) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .remove(visitorFragmentsStranger[indexVF - 2])
                            .commit();
                }else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .remove(visitorFragmentsStaff[indexVF])
                            .commit();
                }
            }
            //test
            if (layoutStatus){
                setRecordVisitorsInfo();
                tvRecordCount.setText(String.valueOf(recordCount));
            }
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT && !visitorShowing) {
            handReLayout();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //test 用
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    void handAddVisitor(int id){
        if (indexVF > 1){
            indexVF = 0;
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_top, R.anim.slide_out_bottom)
                    .replace(id,visitorFragmentsStaff[indexVF])//test
                    .commitNow();
            visitorFragmentsStaff[indexVF].setPersonInfo(VisitorsInfoBean.testJsonString2);

        }else {
            indexVF = 2;
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_top, R.anim.slide_out_bottom)
                    .replace(id,visitorFragmentsStranger[indexVF-2])
                    .commitNow();
            visitorFragmentsStranger[indexVF-2].setPersonInfo(VisitorsInfoBean.testJsonString3);
        }
    }

    void handVisitorShow(final int status, final int type, final String personInfo){
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                if (status == SHOW_NONE){
                    if (flVisitorContainer.getVisibility() == View.GONE){
                        flVisitorContainer.setVisibility(View.VISIBLE);
                    }
                    visitorShowing = true;
                    if (type == VisitorFragment.VISITOR_TYPE_STAFF){
                        indexVF = 0;
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_top, R.anim.slide_out_bottom)
                                .add(R.id.fl_visitor_container, visitorFragmentsStaff[indexVF])
                                .commitNow();
                        visitorFragmentsStaff[indexVF].setPersonInfo(personInfo);
                    }else {
                        indexVF = 2;
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_top, R.anim.slide_out_bottom)
                                .add(R.id.fl_visitor_container, visitorFragmentsStranger[indexVF-2])
                                .commitNow();
                        visitorFragmentsStranger[indexVF-2].setPersonInfo(personInfo);
                    }

                }else if (status == SHOW_ADD){
                    if (type == VisitorFragment.VISITOR_TYPE_STAFF){
                        if (indexVF > 1){
                            indexVF = 0;
                        }else {
                            indexVF = (indexVF == 0) ? 1:0;
                        }
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_top, R.anim.slide_out_bottom)
                                .replace(R.id.fl_visitor_container,visitorFragmentsStaff[indexVF])
                                .commitNow();
                        visitorFragmentsStaff[indexVF].setPersonInfo(personInfo);
                    }else {
                        if (indexVF > 1){
                            indexVF = (indexVF == 2) ? 3:2;
                        }else {
                            indexVF = 2;
                        }
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_top, R.anim.slide_out_bottom)
                                .replace(R.id.fl_visitor_container,visitorFragmentsStranger[indexVF -2])
                                .commitNow();
                        visitorFragmentsStranger[indexVF -2].setPersonInfo(personInfo);
                    }
                }
            }
        });
    }

    void finishVisitorShow(){
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                if (flVisitorContainer.getVisibility() == View.VISIBLE){
                    flVisitorContainer.setVisibility(View.GONE);
                    visitorShowing = false;

                    if (indexVF > 1) {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .remove(visitorFragmentsStranger[indexVF - 2])
                                .commitNowAllowingStateLoss();
                    }else {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .remove(visitorFragmentsStaff[indexVF])
                                .commitNowAllowingStateLoss();
                    }
                }
            }
        });
    }

    void handReLayout(){
        if (layoutStatus){
            layoutStatus = false;

            int nl = notifyFragment.getLeft();
            int nw = notifyFragment.getWidth();

            ObjectAnimator animNotify = ObjectAnimator
                    .ofFloat(notifyFragment, View.TRANSLATION_X, 0.0F, (disW-nl-nw)*1.08f);


            ObjectAnimator[] tdcA = animFade(   tdc                 );
            ObjectAnimator[] faceA = animFade(  faceFrameLayout     );
            ObjectAnimator[] recordA = animFade(recordFrameLayout   );
            ObjectAnimator[] timeA = animFade(  timeFrameLayout     );

            final int w = videoFrameLayout.getWidth();
            final int h = videoFrameLayout.getHeight();
            ObjectAnimator animVideoTY = ObjectAnimator.ofFloat(videoFrameLayout, View.TRANSLATION_Y,
                    0.0f,  0f);
            ObjectAnimator animVideoTX = ObjectAnimator.ofFloat(videoFrameLayout, View.TRANSLATION_X,
                    0.0f, -w/4);
            ObjectAnimator animVideoSX = ObjectAnimator.ofFloat(videoFrameLayout, View.SCALE_X,
                    1.0f, VIDEO_SCALE_ARG);
            ObjectAnimator animVideoSY = ObjectAnimator.ofFloat(videoFrameLayout, View.SCALE_Y,
                    1.0f, VIDEO_SCALE_ARG);

            final ObjectAnimator animVideoSXEnd = ObjectAnimator.ofFloat(videoFrameLayout, View.SCALE_X,
                    VIDEO_SCALE_ARG,1.0f).setDuration(1);
            final ObjectAnimator animVideoSYEnd = ObjectAnimator.ofFloat(videoFrameLayout, View.SCALE_Y,
                    VIDEO_SCALE_ARG,1.0f).setDuration(1);
            animVideoSXEnd.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ViewGroup.LayoutParams lp = videoFrameLayout.getLayoutParams();
                    lp.height = (int) (h*VIDEO_SCALE_ARG);
                    lp.width = (int) (w*VIDEO_SCALE_ARG);
                    videoFrameLayout.setTranslationX(videoFrameLayout.getTranslationX());
                    videoFrameLayout.setTranslationY(-videoFrameLayout.getHeight()/4);
                    videoFrameLayout.setLayoutParams(lp);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            AnimatorSet animSet = new AnimatorSet();
            animSet.play(tdcA[0]).with(faceA[0]).with(recordA[0]).with(timeA[0]).before(animVideoTY);

            animSet.play(animVideoTY).with(animVideoTX).with(animVideoSX)
                    .with(animVideoSY).with(animNotify);
            animSet.setDuration(1500);
            animSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    for (View v: decorViewList){
                        v.setVisibility(View.GONE);
                    }

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    AnimatorSet animSet = new AnimatorSet();
                    animSet.play(animVideoSXEnd)
                            .with(animVideoSYEnd);
                    animSet.setDuration(1);
                    animSet.start();

                    tdc.setVisibility(View.GONE);
                    faceFrameLayout.setVisibility(View.GONE);
                    recordFrameLayout.setVisibility(View.GONE);
                    timeFrameLayout.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            animSet.start();
        }else {
            layoutStatus = true;

            ObjectAnimator[] tdcA = animShow(tdc);
            ObjectAnimator[] faceA = animShow(faceFrameLayout);
            ObjectAnimator[] recordA = animShow(recordFrameLayout);
            ObjectAnimator[] timeA = animShow(timeFrameLayout);

            ViewGroup.LayoutParams lp = videoFrameLayout.getLayoutParams();
            lp.height = (int) (videoFrameLayout.getHeight()/1.5);
            lp.width = (int) (videoFrameLayout.getWidth()/1.5);
            videoFrameLayout.setLayoutParams(lp);

            int nl = notifyFragment.getLeft();
            int nw = notifyFragment.getWidth();

            ObjectAnimator animNotify = ObjectAnimator
                    .ofFloat(notifyFragment, View.TRANSLATION_X, disW-nl-nw, 0.0F);

            int w = videoFrameLayout.getWidth();
            int h = videoFrameLayout.getHeight();
            ObjectAnimator animVideoTY = ObjectAnimator.ofFloat(videoFrameLayout, View.TRANSLATION_Y,
                    0.0f, 0.0f);
            ObjectAnimator animVideoTX = ObjectAnimator.ofFloat(videoFrameLayout, View.TRANSLATION_X,
                    -w/4, 0.0f);
            ObjectAnimator animVideoSX = ObjectAnimator.ofFloat(videoFrameLayout, View.SCALE_X,
                    1.5f, 1.f);
            ObjectAnimator animVideoSY = ObjectAnimator.ofFloat(videoFrameLayout, View.SCALE_Y,
                    1.5f, 1.f);
            AnimatorSet animSet = new AnimatorSet();
            animSet.play(tdcA[0]).with(faceA[0]).with(recordA[0]).with(timeA[0]).after(animVideoTY);
            animSet.play(animVideoTY).with(animVideoTX).with(animVideoSX)
                    .with(animVideoSY).with(animNotify);
            animSet.setDuration(1500);
            animSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    tdc.setVisibility(View.VISIBLE);
                    faceFrameLayout.setVisibility(View.VISIBLE);
                    recordFrameLayout.setVisibility(View.VISIBLE);
                    timeFrameLayout.setVisibility(View.VISIBLE);

                    for (View v: decorViewList){
                        v.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            animSet.start();
        }
    }

    ObjectAnimator[] animFade(final View view){
        ObjectAnimator scale = ObjectAnimator.ofFloat(view, View.SCALE_Y,1,1/view.getWidth());
        return new ObjectAnimator[]{scale};
    }
    ObjectAnimator[] animShow(final View view){
        ObjectAnimator scale = ObjectAnimator.ofFloat(view, View.SCALE_Y,1/view.getWidth(),1);
        return new ObjectAnimator[]{scale};
    }


    private void setRecordVisitorsInfo(){
        RecordFragment recordFragment = (RecordFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_record);
        recordFragment.setPersons();
        FaceFragment faceFragment = (FaceFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_face);
        faceFragment.setFace();
    }

    private class ShowVisitorWorker implements Runnable{

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void run() {

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            FinishShowVisitorWorker fSVWorker = new FinishShowVisitorWorker();
            while (showVisitorWorkerRunning){
                try {
                    final String person = personQueue.take();//阻塞

                    VisitorsInfoBean visitorsInfoBean = new Gson().fromJson(person,VisitorsInfoBean.class);
                    if (fSVWorker.showPersonCount == 0){
                        showVisitorStatus = SHOW_NONE;
                        //开启控制结束的线程
                        executor.schedule(fSVWorker,(long) DURATION_ONE_PERSON, TimeUnit.MILLISECONDS);
                    }else if (fSVWorker.showPersonCount > 0){
                        showVisitorStatus = SHOW_ADD;
                    }

                    fSVWorker.showPersonCount++;

                    handVisitorShow(showVisitorStatus,
                            visitorsInfoBean.getMessage().getVisitors().get(0).getPersonType(),
                            person);
                    Thread.sleep(DURATION_ONE_PERSON);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class FinishShowVisitorWorker implements Runnable{

        int showPersonCount = 0;
        @Override
        public void run() {
            while (showPersonCount > 0){
                try {
                    Thread.sleep(DURATION_ONE_PERSON);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                showPersonCount --;
            }
            finishVisitorShow();
            if (layoutStatus){
                getWindow().getDecorView().post(new Runnable() {
                    @Override
                    public void run() {
                        setRecordVisitorsInfo();
                        tvRecordCount.setText(String.valueOf(recordCount));
                    }
                });
            }
        }
    }
}
