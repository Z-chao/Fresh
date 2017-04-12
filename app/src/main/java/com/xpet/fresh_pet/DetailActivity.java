package com.xpet.fresh_pet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xpet.fresh_pet.adapter.DetailAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rv_detail;
    private Banner detail_banner;
    private TextView tv_detail_name;
    private TextView tv_yimiao;
    private TextView tv_price;
    private TextView tv_looknum;
    private TextView tv_time;
    private TextView tv_pingji;
    private ImageView iv_pingji;
    private TextView tv_birthday;
    private TextView tv_yimiaoor;
    private TextView tv_quchong;
    private TextView tv_more;
    private ImageView iv_back;
    private ImageView iv_share;
    private LinearLayout ll_share;
    private TextView tv_kefu;
    private TextView tv_dingzhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail);
        initView();
        getdata();
        setListener();
    }

    private void setListener() {
        tv_kefu.setOnClickListener(this);
        tv_dingzhi.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_share.setOnClickListener(this);
        ll_share.setOnClickListener(this);

    }


    private void initView() {
        rv_detail = (RecyclerView) findViewById(R.id.rv_detail); //相关推荐的列表
        detail_banner = (Banner) findViewById(R.id.detail_banner); //轮播图
        tv_detail_name = (TextView) findViewById(R.id.tv_detail_name); //商品的名称
        tv_yimiao = (TextView) findViewById(R.id.tv_yimiao); //是否打了疫苗和驱虫
        tv_price = (TextView) findViewById(R.id.tv_price); //价格
        tv_looknum = (TextView) findViewById(R.id.tv_looknum); //多少次查看
        tv_time = (TextView) findViewById(R.id.tv_time); //时间
        tv_pingji = (TextView) findViewById(R.id.tv_pingji); //宠物品级
        tv_birthday = (TextView) findViewById(R.id.tv_birthday); //生日
        tv_yimiaoor = (TextView) findViewById(R.id.tv_yimiaoor); //是否打了疫苗
        tv_quchong = (TextView) findViewById(R.id.tv_quchong); //是否驱虫
        tv_more = (TextView) findViewById(R.id.tv_more); //更多描述
        tv_kefu = (TextView) findViewById(R.id.tv_kefu); //去客服
        tv_dingzhi = (TextView) findViewById(R.id.tv_dingzhi); //去定制的界面


        iv_pingji = (ImageView) findViewById(R.id.iv_pingji); //宠物品级的图片
        iv_back = (ImageView) findViewById(R.id.iv_back); //返回的按钮
        iv_share = (ImageView) findViewById(R.id.iv_share); //分享的按钮
        ll_share = (LinearLayout) findViewById(R.id.ll_share); //分享的底部栏



    }


    /**
     * 数据的填充
     *
     */
    private void getdata() {
        rv_detail.setLayoutManager(new LinearLayoutManager(this));
        List<String> data = new ArrayList<>();
        data.add("这是第一窝宠物");
        data.add("这是第二窝宠物");
        data.add("这是第三窝宠物");
        rv_detail.setAdapter(new DetailAdapter(R.layout.item_detail,data));

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //返回按钮
                finish();
                break;
            case R.id.iv_share:
                //分享按钮
                shareData();
                break;
            case R.id.ll_share:
                //底部分享按钮
                shareData();
                break;
            case R.id.tv_dingzhi:
                //定制功能
                startActivity(new Intent(DetailActivity.this, WebViewActivity.class));
                break;
            case R.id.tv_kefu:
                //客服功能
                String url="mqqwpa://im/chat?chat_type=wpa&uin=3209407802";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                break;
        }


    }

    private void shareData() {


    }
}
