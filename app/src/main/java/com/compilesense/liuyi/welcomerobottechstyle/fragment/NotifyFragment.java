package com.compilesense.liuyi.welcomerobottechstyle.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compilesense.liuyi.welcomerobottechstyle.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotifyFragment extends Fragment {

    TextView tvContent,tvDate,tvTime,tvEta;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public NotifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notify, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvContent = (TextView) getView().findViewById(R.id.tv_notify_content);
        tvDate = (TextView) getView().findViewById(R.id.tv_notify_date_value);
        tvTime = (TextView) getView().findViewById(R.id.tv_notify_time_value);
        tvEta = (TextView) getView().findViewById(R.id.tv_notify_eta_value);
    }

    public void setNotify(String content,String dateS){
        tvContent.setText(content);
        tvDate.setText(dateS);
        tvTime.setText("null");
        tvEta.setText("null");
    }
}
