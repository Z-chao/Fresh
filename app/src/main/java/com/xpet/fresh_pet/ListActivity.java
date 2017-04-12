package com.xpet.fresh_pet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lqr.dropdownLayout.LQRDropdownLayout;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_kefu;
    private ImageView iv_dingzhi;
    private RecyclerView rv_list;
    private LQRDropdownLayout dl;
    private ImageView iv_back;
    private ImageView iv_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
        setListener();
    }



    private void initView() {

        iv_kefu = (ImageView) findViewById(R.id.iv_kefu); //客服按钮
        iv_dingzhi = (ImageView) findViewById(R.id.iv_dingzhi); //定制按钮
        rv_list = (RecyclerView) findViewById(R.id.rv_list); //列表
        dl = (LQRDropdownLayout) findViewById(R.id.dl); //下拉菜单
        iv_back = (ImageView) findViewById(R.id.iv_back); //返回按钮
        iv_search = (ImageView) findViewById(R.id.iv_search); //搜索按钮

    }


    private void setListener() {
        iv_kefu.setOnClickListener(this);
        iv_dingzhi.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //返回键
                finish();
                break;

            case R.id.iv_search:
                //搜索按钮

                break;

            case R.id.iv_kefu:
                //客服
                String url="mqqwpa://im/chat?chat_type=wpa&uin=3209407802";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                break;

            case R.id.iv_dingzhi:
                //定制
                startActivity(new Intent(ListActivity.this, WebViewActivity.class));
                break;

        }

    }
}
