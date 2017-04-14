package com.xpet.fresh_pet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import com.xpet.fresh_pet.utils.TranslucentStatus;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        startMain();
       // initData();
    }

    private void initData() {
        //判断有没有 token  如果有token  说明之前登录过 那么自动登录

    }

    /**
     * 延时操作 进入Main
     */
    private void startMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },2500);

    }

    private void initView() {
        getSupportActionBar().hide();
        TranslucentStatus.setTranslucentStatus(this);// 设置通知栏变色
        setContentView(R.layout.activity_splash);
    }


}
