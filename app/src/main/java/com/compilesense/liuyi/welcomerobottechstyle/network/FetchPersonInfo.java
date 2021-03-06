package com.compilesense.liuyi.welcomerobottechstyle.network;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.application.WRApplication;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.VisitorsInfoBean;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by shenjingyuan002 on 2016/12/5.
 */

public class FetchPersonInfo {
    private final static String TAG = "FetchPersonInfo";
    private final static String URL = "Services/TVServices.ashx?";

    //record
    final static int VISITOR_CACHE_SIZE = 3;
    private IPersonInfo[] iPersonInfoCache = new IPersonInfo[VISITOR_CACHE_SIZE];
    private int indexPersonInfo = -1;

    private FetchPersonInfo(){}
    static private FetchPersonInfo instance = new FetchPersonInfo();
    public static FetchPersonInfo getInstance() {
        return instance;
    }


    private void recordVisitors(IPersonInfo visitorsInfoBean){
        indexPersonInfo = (indexPersonInfo >= VISITOR_CACHE_SIZE-1)? 0 : ++indexPersonInfo;
        iPersonInfoCache[indexPersonInfo] = visitorsInfoBean;
    }

    public IPersonInfo[] getVisitorsInfoBeenCache(){
        if (indexPersonInfo < 0 || indexPersonInfo > iPersonInfoCache.length-1){
            return null;
        }

        if (iPersonInfoCache[indexPersonInfo] == null){
            return null;
        }

        IPersonInfo[] offer = new IPersonInfo[VISITOR_CACHE_SIZE];
        int index = indexPersonInfo;
        for (int i = 0; i < VISITOR_CACHE_SIZE; i++){
            offer[i] = iPersonInfoCache[index];
            if (offer[i] == null){
                break;
            }
            index = (index <= 0)? VISITOR_CACHE_SIZE-1 : --index;
        }

        return offer;

    }


    public void fetch(Context context,String personInfo,final FetchListener listener){
        VisitorsInfoBean visitorsInfoBean = null;
        try {
            visitorsInfoBean = new Gson().fromJson(personInfo,VisitorsInfoBean.class);

        }catch (Exception e){
            Log.e(TAG,"personInfo"+ personInfo);
            e.printStackTrace();
        }

        if (visitorsInfoBean == null){
            Log.e(TAG,"visitorsInfoBean == null");
            return;
        }

        String personId = visitorsInfoBean.getMessage().getVisitors().get(0).getPersonId();
        final int pT = visitorsInfoBean.getMessage().getVisitors().get(0).getPersonType();
        final String action;
//        Log.d(TAG,"personType:" + pT);
        if (pT == 0){
            action = "PersonInfoList";
        }else if (pT == 1){
            action = "VisitorInfoList";
        }else {
            Log.e(TAG, "personType ==" + pT);
            return;
        }

        String url = context.getString(R.string.service_ip) + URL+"action="+action+"&personId="+personId;
        Log.d(TAG,"url:" + url);
        StringRequest request = new StringRequest(
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG,"personInfo response:" + response);

                        if (pT == 0){
                            try {
                                PersonInfoResponse personInfoResponse = new Gson().fromJson(response, PersonInfoResponse.class);
                                if (personInfoResponse.getStatus().equals("successful")){
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.CHINA);
                                    personInfoResponse.date = dateFormat.format(new Date(System.currentTimeMillis()));
                                    recordVisitors(personInfoResponse);
                                    listener.onSucceed(personInfoResponse, pT);
                                }else {
                                    listener.onFailed();
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }else if (pT == 1){
                            try {
                                VisitorInfoResponse visitorInfoResponse = new Gson().fromJson(response, VisitorInfoResponse.class);
                                if (visitorInfoResponse.status.equals("successful")){
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.CHINA);
                                    visitorInfoResponse.date = dateFormat.format(new Date(System.currentTimeMillis()));
                                    recordVisitors(visitorInfoResponse);
                                    listener.onSucceed(visitorInfoResponse, pT);
                                }else {
                                    listener.onFailed();
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        WRApplication app = (WRApplication) context.getApplicationContext();
        app.addRequest(request);
//        Volley.newRequestQueue(context).add(request);
    }

    public interface FetchListener{
        void onSucceed(Object response, int type);
        void onFailed();
    }

    public interface IPersonInfo{
        String getName();
        String getFetchTime();
        String getImage();
    }

    public class VisitorInfoResponse implements IPersonInfo{
        public String status;
        public List<PersonListBean> personList;
        @Expose(deserialize = false,serialize = false)
        public String date="";

        @Override
        public String getName() {
            return personList.get(0).personName;
        }

        @Override
        public String getFetchTime() {
            return date;
        }

        @Override
        public String getImage() {
            return personList.get(0).personImageUrl.get(0);
        }

        public class PersonListBean {
            public int personId;
            public String personName;
            public String companyName;
            public String jobName;
            public List<String> personImageUrl;
        }
    }

    public class PersonInfoResponse implements IPersonInfo{

        /**
         * status : successful
         * personList : [{"personId":3,"personName":"4321","personImageUrl":["Upload/Person/1.jpg","Upload/Person/2.jpg","Upload/Person/3.jpg"],"personDepartmentId":1,"personJobNumber":"143214321"}]
         */

        private String status;
        /**
         * personId : 3
         * personName : 4321
         * personImageUrl : ["Upload/Person/1.jpg","Upload/Person/2.jpg","Upload/Person/3.jpg"]
         * personDepartmentId : 1
         * personJobNumber : 143214321
         */

        private List<PersonListBean> personList;

        @Expose(deserialize = false,serialize = false)
        public String date="";

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<PersonListBean> getPersonList() {
            return personList;
        }

        public void setPersonList(List<PersonListBean> personList) {
            this.personList = personList;
        }

        @Override
        public String getName() {
            return personList.get(0).personName;
        }

        @Override
        public String getFetchTime() {
            return date;
        }

        @Override
        public String getImage() {
            return personList.get(0).getPersonImageUrl().get(0);
        }

        public class PersonListBean {
            private int personId;
            private String personName;
            private int personDepartmentId;
            private String personJobNumber;
            private List<String> personImageUrl;

            public int getPersonId() {
                return personId;
            }

            public void setPersonId(int personId) {
                this.personId = personId;
            }

            public String getPersonName() {
                return personName;
            }

            public void setPersonName(String personName) {
                this.personName = personName;
            }

            public int getPersonDepartmentId() {
                return personDepartmentId;
            }

            public void setPersonDepartmentId(int personDepartmentId) {
                this.personDepartmentId = personDepartmentId;
            }

            public String getPersonJobNumber() {
                return personJobNumber;
            }

            public void setPersonJobNumber(String personJobNumber) {
                this.personJobNumber = personJobNumber;
            }

            public List<String> getPersonImageUrl() {
                return personImageUrl;
            }

            public void setPersonImageUrl(List<String> personImageUrl) {
                this.personImageUrl = personImageUrl;
            }
        }
    }
}
