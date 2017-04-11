package com.xpet.fresh_pet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xpet.fresh_pet.adapter.HomeAdapter;
import com.xpet.fresh_pet.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rv_main;
    private HomeAdapter mHomeAdapter;
    private View mHeaderView;
    private LinearLayout ll_homesearch;
    private EditText ed_homeseach;
    private Banner banner_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
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
        mHeaderView = View.inflate(MainActivity.this, R.layout.home_head, null);
        initHeaderView();
        mHomeAdapter.addHeaderView(mHeaderView);

        rv_main.setAdapter(mHomeAdapter);

        setonListener();


    }

    private void setonListener() {
        ll_homesearch.setOnClickListener(this);
        ed_homeseach.setOnClickListener(this);

    }

    private void initHeaderView() {
        ll_homesearch = (LinearLayout) mHeaderView.findViewById(R.id.ll_homesearch);
        banner_home = (Banner) mHeaderView.findViewById(R.id.banner_home);
        ed_homeseach = (EditText) mHeaderView.findViewById(R.id.ed_homeseach);
        ed_homeseach.setInputType(InputType.TYPE_NULL);

        //轮播图中数据的填充

        banner_home.setImageLoader(new GlideImageLoader());
        ArrayList<Integer> imageUrls = new ArrayList<>();
        imageUrls.add(R.mipmap.ic_launcher);
        imageUrls.add(R.mipmap.arrow);
        imageUrls.add(R.mipmap.homedog);
        banner_home.setImages(imageUrls);
        banner_home.setIndicatorGravity(BannerConfig.LEFT);
        banner_home.setDelayTime(1500);
        banner_home.start();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_homesearch:
                //搜索的逻辑

                break;

            case R.id.ed_homeseach:
                //搜索

                break;
            
        }

    }
}
