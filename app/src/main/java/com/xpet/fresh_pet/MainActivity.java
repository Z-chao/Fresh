package com.xpet.fresh_pet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xpet.fresh_pet.adapter.HomeAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main;
    private HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        rv_main.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        ArrayList<String> data = new ArrayList<>();
        data.add("无敌神犬");
        data.add("无敌神犬1");
        data.add("无敌神犬2");
        data.add("无敌神犬3");
        data.add("无敌神犬4");
        data.add("无敌神犬5");
        mHomeAdapter = new HomeAdapter(R.layout.item_home,data);
        View headerView = View.inflate(MainActivity.this, R.layout.home_head, null);
        mHomeAdapter.addHeaderView(headerView);

        rv_main.setAdapter(mHomeAdapter);



    }
}
