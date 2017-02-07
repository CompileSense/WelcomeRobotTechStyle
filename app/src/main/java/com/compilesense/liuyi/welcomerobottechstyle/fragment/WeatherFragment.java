package com.compilesense.liuyi.welcomerobottechstyle.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.javabean.WeatherBean;
import com.compilesense.liuyi.welcomerobottechstyle.network.WeatherInfoRequest;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    private final static String TAG = "WeatherFragment";
    private static final String tempUnit = "°C";

    private static final int[] WEATHER_ICON_IDS = {
            R.drawable.wtr_sunny,
            R.drawable.wtr_overcast,
            R.drawable.wtr_cloud,
            R.drawable.wtr_rain,
            R.drawable.wtr_snow,
            R.drawable.wtr_wind};
    int crtWeatherIconId = -1, tmrWeatherIconId = -1;
    Bitmap crtWeatherBitmap, tmrWeatherBitmap;
    MyAdapter mAdapter;
    List<WeatherItem> weatherItems = new ArrayList<>();

    //需要更新的views
    ImageView imgCrtWeather,imgTmrWeather;
    TextView tvWind,tvCrtTemp,tvCrtWtrDescribe,tvNotify,tvTmrTemp,tvTmrWtrDescritbe;


    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        fetchWeather();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    void initViews(){
        ImageView bg = (ImageView) getView().findViewById(R.id.img_weather_bg);
        Utils.bitmapIntoImageView(getContext(),bg, R.drawable.weather_bg,2);

        imgCrtWeather = (ImageView) getView().findViewById(R.id.img_weather_ic_current);
        imgTmrWeather = (ImageView) getView().findViewById(R.id.img_weather_ic_tomorrow);

        tvCrtTemp = (TextView) getView().findViewById(R.id.tv_current_temp);
        tvNotify = (TextView) getView().findViewById(R.id.tv_current_notice);
        tvWind = (TextView) getView().findViewById(R.id.tv_wind);
        tvCrtWtrDescribe = (TextView) getView().findViewById(R.id.tv_current_describe);

        tvTmrTemp = (TextView) getView().findViewById(R.id.tv_tomorrow_temp);
        tvTmrWtrDescritbe = (TextView) getView().findViewById(R.id.tv_tomorrow_describe);

        initRecyclerView();
    }

    void initRecyclerView(){
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.rc_weather);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter();
        recyclerView.setAdapter(mAdapter);
        for (int i = 0;i < 7;i++){
            weatherItems.add(new WeatherItem("1."+(i+1),R.drawable.ic_weather_could,5,-3));
        }
        mAdapter.setWeatherItemList(weatherItems);
    }


    void fetchWeather(){
        if (getContext()==null){
            return;
        }

        WeatherInfoRequest.getInstance().getInfo(getContext(), new WeatherInfoRequest.IFetchWeatherListener() {
            @Override
            public void FetchWeather(WeatherBean weatherBean) {

                List<WeatherBean.ResultBean.HourlyBean.WindBean> windBeanList = weatherBean.getResult().getHourly().getWind();
                tvWind.setText( String.valueOf(windBeanList.get(0).getSpeed()+"μm/m"));

                WeatherBean.ResultBean.DailyBean.SkyconBean crtSkyconBean = weatherBean.getResult().getDaily().getSkycon().get(0);
                switch (crtSkyconBean.getValue()) {
                    case "CLEAR_DAY":
                    case "CLEAR_NIGHT":
                        crtWeatherIconId = WEATHER_ICON_IDS[0];
                        break;
                    case "PARTLY_CLOUDY_DAY":
                    case "PARTLY_CLOUDY_NIGHT":
                        crtWeatherIconId = WEATHER_ICON_IDS[1];
                        break;
                    case "CLOUDY":
                        crtWeatherIconId = WEATHER_ICON_IDS[2];
                        break;
                    case "SLEET":
                    case "RAIN":
                        crtWeatherIconId = WEATHER_ICON_IDS[3];
                        break;
                    case "SNOW":
                        crtWeatherIconId = WEATHER_ICON_IDS[4];
                        break;
                    case "WIND":
                        crtWeatherIconId = WEATHER_ICON_IDS[5];
                        break;
                    case "FOG":
                    case "HAZE":
                        crtWeatherIconId = WEATHER_ICON_IDS[2];
                        break;
                }
                setWeatherIcon(true, crtWeatherIconId);
                String crtWtrDes = crtSkyconBean.getValue().replace("PARTLY_","").replace("_","");
                tvCrtWtrDescribe.setText(crtWtrDes);
                double ct = weatherBean.getResult().getDaily().getTemperature().get(0).getAvg();
                String crtTemp = String.valueOf((int)(ct*10)/10);
                tvCrtTemp.setText(crtTemp+tempUnit);

                WeatherBean.ResultBean.DailyBean.SkyconBean tmrSkyconBean = weatherBean.getResult().getDaily().getSkycon().get(1);
                switch (tmrSkyconBean.getValue()) {
                    case "CLEAR_DAY":
                    case "CLEAR_NIGHT":
                        tmrWeatherIconId = WEATHER_ICON_IDS[0];
                        break;
                    case "PARTLY_CLOUDY_DAY":
                    case "PARTLY_CLOUDY_NIGHT":
                        tmrWeatherIconId = WEATHER_ICON_IDS[1];
                        break;
                    case "CLOUDY":
                        tmrWeatherIconId = WEATHER_ICON_IDS[2];
                        break;
                    case "SLEET":
                    case "RAIN":
                        tmrWeatherIconId = WEATHER_ICON_IDS[3];
                        break;
                    case "SNOW":
                        tmrWeatherIconId = WEATHER_ICON_IDS[4];
                        break;
                    case "WIND":
                        tmrWeatherIconId = WEATHER_ICON_IDS[5];
                        break;
                    case "FOG":
                    case "HAZE":
                        tmrWeatherIconId = WEATHER_ICON_IDS[2];
                        break;
                }
                setWeatherIcon(false, tmrWeatherIconId);
                String tmrWtrDes = crtSkyconBean.getValue().replace("PARTLY_","").replace("_","").replace("DAY","");
                tvTmrWtrDescritbe.setText(tmrWtrDes);
                double tt = weatherBean.getResult().getDaily().getTemperature().get(1).getAvg();
                String tmrTemp = String.valueOf((int)(tt*10)/10);
                tvTmrTemp.setText(tmrTemp+tempUnit);

                tvNotify.setText(weatherBean.getResult().getHourly().getDescription());

                WeatherBean.ResultBean.DailyBean dailyBean = weatherBean.getResult().getDaily();
                List<WeatherBean.ResultBean.DailyBean.TemperatureBean> temperatureBeen = dailyBean.getTemperature();
                List<WeatherBean.ResultBean.DailyBean.SkyconBean> skyconBeen = dailyBean.getSkycon();

                for (int i = 0 ; i < temperatureBeen.size(); i++){

                    if (i>=7){
                        break;
                    }

                    WeatherBean.ResultBean.DailyBean.SkyconBean skyconBean = skyconBeen.get(i);
                    int iconId;
                    switch (skyconBean.getValue()) {
                        case "CLEAR_DAY":
                        case "CLEAR_NIGHT":
                            iconId = WEATHER_ICON_IDS[0];
                            break;
                        case "PARTLY_CLOUDY_DAY":
                        case "PARTLY_CLOUDY_NIGHT":
                            iconId = WEATHER_ICON_IDS[1];
                            break;
                        case "CLOUDY":
                            iconId = WEATHER_ICON_IDS[2];
                            break;
                        case "SLEET":
                        case "RAIN":
                            iconId = WEATHER_ICON_IDS[3];
                            break;
                        case "SNOW":
                            iconId = WEATHER_ICON_IDS[4];
                            break;
                        case "WIND":
                            iconId = WEATHER_ICON_IDS[5];
                            break;
                        case "FOG":
                        case "HAZE":
                            iconId = WEATHER_ICON_IDS[2];
                            break;
                        default:
                            iconId = WEATHER_ICON_IDS[0];
                    }
                    String date = skyconBean.getDate().substring(5).replace("-",".");
                    double max = temperatureBeen.get(i).getMax();
                    double min = temperatureBeen.get(i).getMin();
                    float ht = ((int)(max*10))/10;
                    float lt = ((int)(min*10))/10;
//                    WeatherItem item = new WeatherItem(date,iconId,ht,lt);
                    weatherItems.get(i).setDatas(date,iconId,ht,lt);
                }
                int usefulSize = temperatureBeen.size();
                if (usefulSize<7){
                    for (int i = 0 ; i < 7 - usefulSize; i++){
                        WeatherItem lastItem = weatherItems.get(usefulSize-1);
                        int indexOfDot = lastItem.date.indexOf(".");
                        String dates1 =  lastItem.date.substring(0,indexOfDot);
                        String dates2 =  lastItem.date.substring(indexOfDot);
                        int day = Integer.parseInt(dates2.substring(1));
                        day += i+1;
                        String date = dates1 + "." + day;
                        weatherItems.get(i+usefulSize).setDatas(date,lastItem.iconID,lastItem.hightestTemp,lastItem.lowestTemp);
                    }
                }
                mAdapter.setWeatherItemList(weatherItems);
            }
        });
    }

    private void setWeatherIcon(boolean isToday ,int iconId){
        if (iconId < 0){
            Log.d(TAG,"iconId < 0");
            return;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();

        if (isToday){
            options.inSampleSize = Utils.calculateInSampleSize(getContext(),iconId,imgCrtWeather);
            if (crtWeatherBitmap != null && !crtWeatherBitmap.isRecycled()){
                crtWeatherBitmap.recycle();
                crtWeatherBitmap = null;
            }
            crtWeatherBitmap = BitmapFactory.decodeResource(getResources(),iconId,options);
            imgCrtWeather.setImageBitmap(crtWeatherBitmap);
        }else {
            options.inSampleSize = Utils.calculateInSampleSize(getContext(),iconId,imgCrtWeather);
            if (tmrWeatherBitmap != null && !tmrWeatherBitmap.isRecycled()){
                tmrWeatherBitmap.recycle();
                tmrWeatherBitmap = null;
            }
            tmrWeatherBitmap = BitmapFactory.decodeResource(getResources(),iconId,options);
            imgTmrWeather.setImageBitmap(tmrWeatherBitmap);
        }

    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        List<WeatherItem> weatherItemList = new ArrayList<>();

        public void setWeatherItemList(List<WeatherItem> weatherItemList) {
            this.weatherItemList = weatherItemList;
            notifyDataSetChanged();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.view_weather,parent,false));
        }

        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
            holder.date.setText(weatherItemList.get(position).date);
            holder.icon.setImageDrawable(getContext().getResources().getDrawable(weatherItemList.get(position).iconID));
            holder.hTemp.setText(weatherItemList.get(position).hightestTemp+tempUnit);
            holder.lTemp.setText(weatherItemList.get(position).lowestTemp+tempUnit);
        }

        @Override
        public int getItemCount() {
            return weatherItemList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView date,hTemp,lTemp;
            ImageView icon;

            MyViewHolder(View itemView) {
                super(itemView);
                date = (TextView) itemView.findViewById(R.id.tv_item_weather_date);
                hTemp = (TextView) itemView.findViewById(R.id.tv_item_weather_h_t);
                lTemp = (TextView) itemView.findViewById(R.id.tv_item_weather_l_t);
                icon = (ImageView) itemView.findViewById(R.id.img_item_weather);
            }
        }
    }

    class WeatherItem {
        String date;
        int iconID;
        float hightestTemp;
        float lowestTemp;

        WeatherItem(String date,int iconID, float hightestTemp,  float lowestTemp) {
            this.date = date;
            this.hightestTemp = hightestTemp;
            this.iconID = iconID;
            this.lowestTemp = lowestTemp;
        }

        void setDatas(String date,int iconID, float hightestTemp,  float lowestTemp){
            this.date = date;
            this.hightestTemp = hightestTemp;
            this.iconID = iconID;
            this.lowestTemp = lowestTemp;
        }
    }
}
