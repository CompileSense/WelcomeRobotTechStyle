package com.compilesense.liuyi.welcomerobottechstyle.activity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;
import com.compilesense.liuyi.welcomerobottechstyle.view.FaceView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaceFragment extends Fragment {


    public FaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_face, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        ImageView bg = (ImageView) getView().findViewById(R.id.img_face_bg);
//        Utils.bitmapIntoImageView(getContext(),bg,R.drawable.face_bg1);
        FaceView faceView = (FaceView) getView().findViewById(R.id.face_view);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap test =BitmapFactory.decodeResource(getResources(),R.drawable.liyi,options);
        faceView.setBitmap(test);
    }
}
