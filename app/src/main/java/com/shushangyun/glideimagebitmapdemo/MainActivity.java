package com.shushangyun.glideimagebitmapdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mData = new ArrayList<>();
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SpaceItemDecoration itemDecoration = new SpaceItemDecoration(this);
        itemDecoration.setHeight(10);
        itemDecoration.setColor(Color.WHITE);
        recyclerView.addItemDecoration(itemDecoration);

        mAdapter = new ImageAdapter(R.layout.item_image,mData);
        recyclerView.setAdapter(mAdapter);
        init();

    }

    private void init(){
        mData.add("http://p3.so.qhimgs1.com/t0102719cecb7bbf933.jpg");
        mData.add("http://p1.so.qhmsg.com/t017ed5ad0208e708f6.jpg");
        mData.add("http://p2.so.qhmsg.com/t01ef99f2cf7231e787.jpg");
        mData.add("http://p5.so.qhimgs1.com/t0149ea6712aacc26eb.jpg");
        mData.add("http://p0.so.qhmsg.com/t0162f5d87724e7d7a5.jpg");
        mData.add("http://p0.so.qhmsg.com/t01cf5427bcc78454f5.jpg");
        mData.add("http://p0.so.qhimgs1.com/t01af1b9098eedd60f4.jpg");
        mData.add("http://p0.so.qhimgs1.com/t0130186c5816ed1d7c.jpg");
        mData.add("http://p5.so.qhimgs1.com/t01ddc47c4b83d2050b.jpg");
        mAdapter.notifyDataSetChanged();
    }


}
