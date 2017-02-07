package com.compilesense.liuyi.welcomerobottechstyle.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.UISettingHttpBean;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;
import com.compilesense.liuyi.welcomerobottechstyle.view.PicassoCircleImageTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BirthdayFragment extends Fragment {

    ImageView imgBg,imgLeft,imgCenter,imgRight;
    TextView tvNameLeft,tvDateLeft,tvNameCenter,tvDateCenter,tvNameRight,tvDateRight;

    public BirthdayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_birthday, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imgBg = (ImageView) getView().findViewById(R.id.img_birthday_bg);
        imgLeft = (ImageView) getView().findViewById(R.id.img_birthday_left);
        imgCenter = (ImageView) getView().findViewById(R.id.img_birthday_center);
        imgRight = (ImageView) getView().findViewById(R.id.img_birthday_right);
        Utils.bitmapIntoImageView(getContext(), imgBg, R.drawable.birthday_bg,2);
        tvNameLeft = (TextView) getView().findViewById(R.id.tv_birthday_left_name);
        tvDateLeft = (TextView) getView().findViewById(R.id.tv_birthday_left_date);
        tvNameCenter = (TextView) getView().findViewById(R.id.tv_birthday_center_name);
        tvDateCenter = (TextView) getView().findViewById(R.id.tv_birthday_center_date);
        tvNameRight = (TextView) getView().findViewById(R.id.tv_birthday_right_name);
        tvDateRight = (TextView) getView().findViewById(R.id.tv_birthday_right_date);
    }

    public void setBirthdayInfo(List<UISettingHttpBean.PersonBirthdayBean> personBirthdayBeanList){
        tvNameLeft.setText(personBirthdayBeanList.get(0).getPersonName());
        tvDateLeft.setText(personBirthdayBeanList.get(0).getPersonBirth());
        tvNameCenter.setText(personBirthdayBeanList.get(1).getPersonName());
        tvDateCenter.setText(personBirthdayBeanList.get(1).getPersonBirth());
        tvNameRight.setText(personBirthdayBeanList.get(2).getPersonName());
        tvDateRight.setText(personBirthdayBeanList.get(2).getPersonBirth());
        String urlBase = getString(R.string.service_ip);
        String url1 = personBirthdayBeanList.get(0).getPersonImgPath();
        if (url1 != null && url1.equals("")){
            Picasso.with(getContext())
                    .load(urlBase + url1)
                    .resizeDimen(imgLeft.getMaxWidth(),imgLeft.getMaxHeight())
                    .into(imgLeft);
        }
        String url2 = personBirthdayBeanList.get(1).getPersonImgPath();
        if (url2 != null && url2.equals("")){
            Picasso.with(getContext())
                    .load(urlBase + url2)
                    .resizeDimen(imgLeft.getMaxWidth(),imgLeft.getMaxHeight())
                    .into(imgCenter);
        }
        String url3 = personBirthdayBeanList.get(2).getPersonImgPath();
        if (url3 != null && url3.equals("")){
            Picasso.with(getContext())
                    .load(urlBase + url3)
                    .resizeDimen(imgLeft.getMaxWidth(),imgLeft.getMaxHeight())
                    .into(imgRight);
        }
    }
}
