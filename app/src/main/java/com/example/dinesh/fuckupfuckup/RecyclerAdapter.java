package com.example.dinesh.fuckupfuckup;

/**
 * Created by dinesh on 7/25/16.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.dinesh.fuckupfuckup.models.DrawerItem;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<DrawerItem> dataList;
    private TextSliderView textSliderView;
    Context context;


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        DrawerItem ru = dataList.get(position);

        if(ru.getFlag()==1)
        {
            //typecast
            DataViewHolder dataViewHolder=(DataViewHolder) viewHolder;

            dataViewHolder.title.setText(ru.getTitle());
            dataViewHolder.subTitle.setText(ru.getTitle());

        }
        else
        {
            DataViewHolder2 dataViewHolder2=(DataViewHolder2) viewHolder;
            dataViewHolder2.title.setText(ru.getTitle());
            textSliderView=new TextSliderView(context);
            TextSliderView textSliderView1 = new TextSliderView(context);

            textSliderView.image(ru.getUrl());
            textSliderView1.image(ru.getUrl1());
            dataViewHolder2.img_first.addSlider(textSliderView1);
            dataViewHolder2.img_first.addSlider(textSliderView);
        }

    }

    public RecyclerAdapter(ArrayList<DrawerItem> dataList,Context context)
    {
        this.dataList = dataList;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView;
        RecyclerView.ViewHolder viewHold;
        switch(viewType)
        {
            case 0:
                itemView = LayoutInflater.
                        from(viewGroup.getContext()).
                        inflate(R.layout.layout_view1, viewGroup, false);
                viewHold= new DataViewHolder(itemView);
                break;

            default:
                itemView = LayoutInflater.
                        from(viewGroup.getContext()).
                        inflate(R.layout.layout_view2, viewGroup, false);
                viewHold= new DataViewHolder2(itemView);
                break;
        }

        return viewHold;
    }

    @Override
    public int getItemViewType(int position) {
        //More to come
        if(dataList.get(position).getFlag()==1)
        {
            return 0;
        }
        else
        {
            return 1;
        }

    }


    public static class DataViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView subTitle;

        public DataViewHolder(View v) {
            super(v);
            title =  (TextView) v.findViewById(R.id.iTitle);
            subTitle = (TextView)  v.findViewById(R.id.iSubTitle);
        }
    }

    public static class DataViewHolder2 extends RecyclerView.ViewHolder {

        protected TextView title;
        protected SliderLayout img_first;

        public DataViewHolder2(View v) {
            super(v);
            title =  (TextView) v.findViewById(R.id.uTitle);

            img_first=(SliderLayout)v.findViewById(R.id.slider);
        }
    }
}