package com.example.dinesh.fuckupfuckup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dinesh.fuckupfuckup.models.DrawerItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DrawerItem> mDrawerItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addtolist();
        RecyclerView recList = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        RecyclerAdapter mAdapter = new RecyclerAdapter(mDrawerItemList,this);
        recList.setAdapter(mAdapter);

    }

    public void addtolist() {
        mDrawerItemList = new ArrayList<DrawerItem>();
        DrawerItem item = new DrawerItem();
        item.setIcon(R.drawable.header_image_2);
        item.setTitle("Inbox");
        item.setFlag(0);
        item.setUrl("http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        item.setUrl1("http://cdn3.nflximg.net/images/3093/2043093.jpg");
        mDrawerItemList.add(item);

        DrawerItem item2 = new DrawerItem();
        item2.setIcon(R.drawable.header_sliding);
        item2.setTitle("Qpay");
        item2.setFlag(0);
        item2.setUrl("http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        item2.setUrl1("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        mDrawerItemList.add(item2);

        DrawerItem item3 = new DrawerItem();
        item3.setIcon(R.drawable.send);
        item3.setTitle("Test");
        item3.setFlag(1);
        mDrawerItemList.add(item3);

        DrawerItem item4 = new DrawerItem();
        item4.setIcon(R.drawable.send);
        item4.setTitle("Fuck");
        item4.setFlag(1);
        mDrawerItemList.add(item4);

        DrawerItem item5 = new DrawerItem();
        item5.setIcon(R.drawable.send);
        item5.setTitle("Send");
        item5.setFlag(1);
        mDrawerItemList.add(item5);
    }

}