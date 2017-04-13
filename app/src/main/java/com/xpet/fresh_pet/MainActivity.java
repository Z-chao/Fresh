package com.xpet.fresh_pet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xpet.fresh_pet.adapter.HomeAdapter;
import com.xpet.fresh_pet.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

import static android.view.KeyEvent.KEYCODE_ENTER;
import static android.view.KeyEvent.KEYCODE_SEARCH;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rv_main;
    private HomeAdapter mHomeAdapter;
    private View mHeaderView;
    private LinearLayout ll_homesearch;
    private EditText ed_homeseach;
    private Banner banner_home;
    private ImageView iv_dingzhi;
    private ImageView iv_kefu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        iv_dingzhi = (ImageView) findViewById(R.id.iv_dingzhi); //定制
        iv_kefu = (ImageView) findViewById(R.id.iv_kefu); //客服
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
        iv_dingzhi.setOnClickListener(this);
        iv_kefu.setOnClickListener(this);
        ed_homeseach.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(ed_homeseach.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    //进行搜索操作的方法，在该方法中可以加入mEditSearchUser的非空判断
                    Toast.makeText(MainActivity.this, "搜索隐藏", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

    }

    private void initHeaderView() {
        ll_homesearch = (LinearLayout) mHeaderView.findViewById(R.id.ll_homesearch);
        banner_home = (Banner) mHeaderView.findViewById(R.id.banner_home);
        ed_homeseach = (EditText) mHeaderView.findViewById(R.id.ed_homeseach);


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
            case R.id.iv_dingzhi:
                //定制
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                break;
            case R.id.iv_kefu:
                //客服
                try {
                    String url = "mqqwpa://im/chat?chat_type=wpa&uin=3209407802";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } catch (Exception error) {
                    Toast.makeText(this, "请安装QQ", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
