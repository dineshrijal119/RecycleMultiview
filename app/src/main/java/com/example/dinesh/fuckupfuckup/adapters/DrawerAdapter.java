package com.example.dinesh.fuckupfuckup.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dinesh.fuckupfuckup.R;
import com.example.dinesh.fuckupfuckup.models.DrawerItem;

import java.util.ArrayList;

/**
 * Created by darshanz on 7/6/15.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder> {

    public final static int TYPE_HEADER = 0;
    public final static int TYPE_MENU = 1;


    private ArrayList<DrawerItem> drawerMenuList;

    private OnItemSelecteListener mListener;

    public DrawerAdapter(ArrayList<DrawerItem> drawerMenuList) {
        this.drawerMenuList = drawerMenuList;
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_HEADER){

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_drawer_header, parent, false);

        }else{

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_menu_item, parent, false);
        }


        return new DrawerViewHolder(view, viewType);
    }


    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        if(position == 0) {
            if (drawerMenuList.get(position).getFlag()==0){
                holder.headerText.setText(drawerMenuList.get(position).getTitle());
                holder.iconhedear.setImageResource(drawerMenuList.get(position).getIcon());
                Log.d("dinesh","for flag zero :"+drawerMenuList.get(position).getTitle());
            }


        }else{
            if (drawerMenuList.get(position).getFlag()==1){
                holder.title.setText(drawerMenuList.get(position).getTitle());
                holder.icon.setImageResource(drawerMenuList.get(position).getIcon());
                Log.d("dinesh","for flag one :"+drawerMenuList.get(position).getTitle());
            }

        }

    }

    @Override
    public int getItemCount() {
        return drawerMenuList.size();
    }


    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return  TYPE_HEADER;
        }
        return TYPE_MENU;

    }

    class DrawerViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView headerText;
        ImageView icon,iconhedear;

        public DrawerViewHolder(View itemView, int viewType) {
            super(itemView);


            if(viewType == 0){
                headerText = (TextView)itemView.findViewById(R.id.headerText);
                iconhedear=(ImageView) itemView.findViewById(R.id.icon_header);
            }else {
                title = (TextView) itemView.findViewById(R.id.title);
                icon = (ImageView) itemView.findViewById(R.id.icon);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemSelected(view, getAdapterPosition());

                }
            });
        }

    }




    public void setOnItemClickLister(OnItemSelecteListener mListener) {
        this.mListener = mListener;
    }

   public interface OnItemSelecteListener{
        public void onItemSelected(View v, int position);
    }

}