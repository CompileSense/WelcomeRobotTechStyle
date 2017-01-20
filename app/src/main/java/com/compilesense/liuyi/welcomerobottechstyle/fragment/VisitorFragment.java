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
public class VisitorFragment extends Fragment {

    private static final String TAG = "VisitorFragment";
    public static final int VISITOR_TYPE_STAFF = 0;//员工
    public static final int VISITOR_TYPE_STRANGER = 1;//访客
    private int type = 1;
    private String personInfo;
    private ImageView imgHeader,imgBg;
    private TextView tvName,tvInfo,tvNotice;

    public static VisitorFragment newInstance(int type){
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        VisitorFragment fragment =  new VisitorFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    public static VisitorFragment newInstance(VisitorsInfoBean visitorsInfoBean){
        Bundle bundle = new Bundle();
        bundle.putInt("type",visitorsInfoBean.getMessage().getVisitors().get(0).getPersonType());
        bundle.putString("id",visitorsInfoBean.getMessage().getVisitors().get(0).getPersonId());
        VisitorFragment fragment =  new VisitorFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setPersonInfo(String personInfo){
        this.personInfo = personInfo;
        fetchVisitorInfo();
    }

    public VisitorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        type = getArguments().getInt("type",VISITOR_TYPE_STAFF);
        if (type == VISITOR_TYPE_STRANGER){
            return inflater.inflate(R.layout.fragment_visitor, container, false);
        }else {
            return inflater.inflate(R.layout.fragment_visitor2, container, false);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    void initViews(){
        imgBg = (ImageView) getView().findViewById(R.id.img_visitor_bg);
        if (type == VISITOR_TYPE_STRANGER){
            Utils.bitmapIntoImageView(getContext(),imgBg,R.drawable.visitor_bg,4);
        }else {
            Utils.bitmapIntoImageView(getContext(),imgBg,R.drawable.visitor_bg2,4);
        }


        imgHeader = (ImageView) getView().findViewById(R.id.img_visitor_head);
        String url = "http://imgsrc.baidu.com/forum/w%3D580/sign=2ba75b788882b9013dadc33b438ca97e/d8828ceef01f3a29c9aea5919b25bc315d607c65.jpg";
        Picasso.with(getContext())
                .load(url)
                .resizeDimen(R.dimen.visitor_header_size,R.dimen.visitor_header_size)
                .transform(new PicassoCircleImageTransformation())
                .into(imgHeader);

        tvName = (TextView) getView().findViewById(R.id.tv_visitor_name);
        tvInfo = (TextView) getView().findViewById(R.id.tv_visitor_info);
        type = getArguments().getInt("type",VISITOR_TYPE_STAFF);
        if (type == VISITOR_TYPE_STAFF){
            tvNotice = (TextView) getView().findViewById(R.id.tv_person_notice);
        }

    }

    private void fetchVisitorInfo(){
        FetchPersonInfo.getInstance().fetch(getContext(), personInfo,
                new FetchPersonInfo.FetchListener() {
                    @Override
                    public void onSucceed(Object response, int type) {
                        if (type == 0){
                            FetchPersonInfo.PersonInfoResponse personInfoResponse = (FetchPersonInfo.PersonInfoResponse) response;
                            String name = null, jobNumber = null, imageUrl = null;
                            try {
                                name = personInfoResponse.getPersonList().get(0).getPersonName();
                                jobNumber = personInfoResponse.getPersonList().get(0).getPersonJobNumber();
                                imageUrl = personInfoResponse.getPersonList().get(0).getPersonImageUrl().get(0);
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                            if (name == null || jobNumber == null || imageUrl == null){
                                Log.e(TAG,"人员信息抓取错误");
                                return;
                            }
                            tvName.setText(name);
                            tvInfo.setText("工号:"+jobNumber);
                            if (!imageUrl.equals("")){
                                String url = getString(R.string.service_ip)+imageUrl;
                                Picasso.with(getContext())
                                        .load(url)
                                        .transform(new PicassoCircleImageTransformation())
                                        .into(imgHeader);
                            }

                        }else if (type == 1){
                            FetchPersonInfo.VisitorInfoResponse visitorInfoResponse = (FetchPersonInfo.VisitorInfoResponse) response;
                            String name = null, jobNumber = null, imageUrl = null;
                            try {
                                name = visitorInfoResponse.personList.get(0).personName;
                                jobNumber = visitorInfoResponse.personList.get(0).companyName;
                                imageUrl = visitorInfoResponse.personList.get(0).personImageUrl.get(0);
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                            if (name == null || jobNumber == null || imageUrl == null){
                                Log.e(TAG,"人员信息抓取错误");
                                return;
                            }

                            tvName.setText(name);
                            tvName.setText("人员信息:"+jobNumber);
                            if (!imageUrl.equals("")){
                                String url = getString(R.string.service_ip)+imageUrl;
                                Picasso.with(getContext())
                                        .load(url)
                                        .transform(new PicassoCircleImageTransformation())
                                        .into(imgHeader);
                            }
                        }

                    }

                    @Override
                    public void onFailed() {

                    }
                });

//        String testUrl = "http://pic.962.net/up/2016-12/201612051532164275404.jpg";
//        Picasso.with(getContext())
//                .load(testUrl)
//                .transform(new PicassoCircleImageTransformation())
//                .into(imageView);
    }
}
