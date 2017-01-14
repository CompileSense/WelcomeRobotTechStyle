package com.compilesense.liuyi.welcomerobottechstyle.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.compilesense.liuyi.welcomerobottechstyle.R;
import com.compilesense.liuyi.welcomerobottechstyle.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    private static final String tempUnit = "°C";

    MyAdapter mAdapter;
    List<WeatherItem> weatherItems = new ArrayList<>();

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
        initBg();
        initRecyclerView();
    }

    void initBg(){
        ImageView bg = (ImageView) getView().findViewById(R.id.img_weather_bg);
        Utils.bitmapIntoImageView(getContext(),bg, R.drawable.weather_bg,2);
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

        public WeatherItem(String date,int iconID, float hightestTemp,  float lowestTemp) {
            this.date = date;
            this.hightestTemp = hightestTemp;
            this.iconID = iconID;
            this.lowestTemp = lowestTemp;
        }
    }
}
