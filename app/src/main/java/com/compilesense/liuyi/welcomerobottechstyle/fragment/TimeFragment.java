package com.compilesense.liuyi.welcomerobottechstyle.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compilesense.liuyi.welcomerobottechstyle.R;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends Fragment {
    private static final int MESSAGE_TIME_UPDATE = 123;

    private TextView time,date;
    private final CalendarFragmentHandler mHandler = new CalendarFragmentHandler(this);
    //使用弱引用避免 Timer 引起的内存泄露。
    private static class CalendarFragmentHandler extends Handler {
        private final WeakReference<TimeFragment> mFragment;
        CalendarFragmentHandler(TimeFragment fragment){
            mFragment = new WeakReference<>(fragment);
        }
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MESSAGE_TIME_UPDATE){
                String[] dateString = mFragment.get().getDate();
                mFragment.get().time.setText(dateString[0]);
                mFragment.get().date.setText(dateString[1]);
            }
        }
    }
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(MESSAGE_TIME_UPDATE);
        }
    };

    public TimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        time = (TextView) getView().findViewById(R.id.tv_time);
        date = (TextView) getView().findViewById(R.id.tv_date);

        Timer mTimer = new Timer();
        mTimer.schedule(timerTask,new Date(System.currentTimeMillis()),1000*30);
    }

    private String[] getDate(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE,MMMMM dd", Locale.CHINA);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm",Locale.CANADA);
        String dateString = dateFormat.format(date);
        String timeString = timeFormat.format(date);
        return new String[]{timeString,dateString};
    }

}
