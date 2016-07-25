package com.example.dinesh.fuckupfuckup;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dinesh.fuckupfuckup.models.DrawerItem;

import java.util.ArrayList;

/**
 * Created by dinesh on 7/25/16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";
    private int[] mDataSetTypes;
    public static final int WEATHER = 0;
    public static final int SCORE = 1;
    public static final int NEWS = 2;
    private ArrayList<DrawerItem> drawerMenuList;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public class WeatherViewHolder extends ViewHolder {
        TextView temp;

        public WeatherViewHolder(View v) {
            super(v);
            this.temp = (TextView) v.findViewById(R.id.temp);
        }
    }

    public class ScoreViewHolder extends ViewHolder {
        TextView score;

        public ScoreViewHolder(View v) {
            super(v);
            this.score = (TextView) v.findViewById(R.id.score);
        }
    }

    public class NewsViewHolder extends ViewHolder {
        TextView headline;
        Button read_more;

        public NewsViewHolder(View v) {
            super(v);
            this.headline = (TextView) v.findViewById(R.id.headline);
            this.read_more = (Button) v.findViewById(R.id.read_more);
        }
    }


    public CustomAdapter(ArrayList<DrawerItem> drawerMenuList, int[] dataSetTypes) {
        this.drawerMenuList = drawerMenuList;
        this.mDataSetTypes = dataSetTypes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == WEATHER) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.weather_card, viewGroup, false);

            return new WeatherViewHolder(v);
        } else if (viewType == NEWS) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.news_card, viewGroup, false);
            return new NewsViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.score_card, viewGroup, false);
            return new ScoreViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (viewHolder.getItemViewType() == WEATHER) {
            WeatherViewHolder holder = (WeatherViewHolder) viewHolder;
            holder.temp.setText(drawerMenuList.get(position).getTitle());
        }
        else if (viewHolder.getItemViewType() == NEWS) {
            NewsViewHolder holder = (NewsViewHolder) viewHolder;
            holder.headline.setText(drawerMenuList.get(position).getTitle());
        }
        else {
            ScoreViewHolder holder = (ScoreViewHolder) viewHolder;
            holder.score.setText(drawerMenuList.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return drawerMenuList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSetTypes[position];
    }
}