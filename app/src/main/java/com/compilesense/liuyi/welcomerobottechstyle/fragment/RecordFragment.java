package com.compilesense.liuyi.welcomerobottechstyle.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecordFragment extends Fragment {


    public RecordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    void initViews(){
        ImageView p1image = (ImageView) getView().findViewById(R.id.img_record_1);
        Utils.bitmapIntoImageView(getContext(),p1image,R.drawable.liux);
        ImageView p2image = (ImageView) getView().findViewById(R.id.img_record_2);
        Utils.bitmapIntoImageView(getContext(),p2image,R.drawable.liyi);
        ImageView p3image = (ImageView) getView().findViewById(R.id.img_record_3);
        Utils.bitmapIntoImageView(getContext(),p3image,R.drawable.yao);
    }
}
