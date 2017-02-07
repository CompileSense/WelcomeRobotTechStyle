package com.compilesense.liuyi.welcomerobottechstyle.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.VisitorsInfoBean;
import com.compilesense.liuyi.welcomerobottechstyle.network.FetchPersonInfo;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;
import com.compilesense.liuyi.welcomerobottechstyle.view.PicassoCircleImageTransformation;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecordFragment extends Fragment {
    private final static String TAG = "RecordFragment";

    TextView tvNameP1,tvNameP2,tvNameP3,tvTimeP1,tvTimeP2,tvTimeP3;
    ImageView imgP1,imgP2,imgP3;

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
        imgP1 = (ImageView) getView().findViewById(R.id.img_record_1);
        Utils.bitmapIntoImageView(getContext(),imgP1,R.drawable.ic_default_person);
        imgP2 = (ImageView) getView().findViewById(R.id.img_record_2);
        Utils.bitmapIntoImageView(getContext(),imgP2,R.drawable.ic_default_person);
        imgP3 = (ImageView) getView().findViewById(R.id.img_record_3);
        Utils.bitmapIntoImageView(getContext(),imgP3,R.drawable.ic_default_person);

        tvNameP1 = (TextView) getView().findViewById(R.id.tv_record_1_name);
        tvNameP2 = (TextView) getView().findViewById(R.id.tv_record_2_name);
        tvNameP3 = (TextView) getView().findViewById(R.id.tv_record_3_name);
        tvTimeP1 = (TextView) getView().findViewById(R.id.tv_record_1_time);
        tvTimeP2 = (TextView) getView().findViewById(R.id.tv_record_2_time);
        tvTimeP3 = (TextView) getView().findViewById(R.id.tv_record_3_time);
    }

    public void setPersons(){
        Log.d(TAG,"setPersons");

        if (tvNameP1 == null){
            return;
        }
        FetchPersonInfo.IPersonInfo[] visitorsCache = FetchPersonInfo.getInstance().getVisitorsInfoBeenCache();

        //p1
        FetchPersonInfo.IPersonInfo v1 = visitorsCache[0];
        if (v1 != null){
            tvNameP1.setText(v1.getName());
            String v1Img = v1.getImage();
            if (!v1Img.equals("")){
                String url = getString(R.string.service_ip)+v1Img;
                Log.d(TAG,"p1 图片地址:" + url);

                Picasso.with(getContext())
                        .load(url)
                        .resize(imgP1.getMaxWidth(),imgP1.getMaxHeight())
                        .into(imgP1);

                Log.d(TAG,"p1 had load");
            }

            tvTimeP1.setText(v1.getFetchTime());
        }

        //p2
        FetchPersonInfo.IPersonInfo v2 = visitorsCache[1];
        if (v2 != null){
            tvNameP2.setText(v2.getName());
            tvTimeP2.setText(v2.getFetchTime());
            String v2Img = v2.getImage();
            if (!v2Img.equals("")){
                String url = getString(R.string.service_ip)+v2Img;
                Picasso.with(getContext())
                        .load(url)
                        .resize(imgP2.getMaxWidth(),imgP2.getMaxHeight())
                        .into(imgP2);
            }
        }

        //p3
        FetchPersonInfo.IPersonInfo v3 = visitorsCache[2];
        if (v3 != null){
            tvNameP3.setText(v3.getName());
            tvTimeP3.setText(v3.getFetchTime());
            String v3Img = v3.getImage();
            if (!v3Img.equals("")){
                String url = getString(R.string.service_ip)+v3Img;
                Picasso.with(getContext())
                        .load(url)
                        .resize(imgP3.getMaxWidth(),imgP3.getMaxHeight())
                        .into(imgP3);
            }
        }
    }


}
