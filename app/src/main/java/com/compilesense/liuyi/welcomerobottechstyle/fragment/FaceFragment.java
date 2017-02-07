package com.compilesense.liuyi.welcomerobottechstyle.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.WeatherBean;
import com.compilesense.liuyi.welcomerobottechstyle.network.FetchPersonInfo;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;
import com.compilesense.liuyi.welcomerobottechstyle.view.FaceView;
import com.compilesense.liuyi.welcomerobottechstyle.view.PicassoCircleImageTransformation;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaceFragment extends Fragment {
    private final static String TAG = "FaceFragment";
    FaceView faceView;
    Bitmap faceBitmap;
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
        faceView = (FaceView) getView().findViewById(R.id.face_view);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap test =BitmapFactory.decodeResource(getResources(),R.drawable.ic_default_person,options);
        faceView.setBitmap(test);
    }

    public void setFace( ) {
        if (faceView==null){
            return;
        }

        FetchPersonInfo.IPersonInfo personInfo = FetchPersonInfo.getInstance().getVisitorsInfoBeenCache()[0];
        String imageUrl = personInfo.getImage();
        final String url = getString(R.string.service_ip)+imageUrl;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    faceBitmap = Picasso.with(getContext()).load(url).get();
                    faceView.post(new Runnable() {
                        @Override
                        public void run() {
                            faceView.setBitmap(faceBitmap);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
