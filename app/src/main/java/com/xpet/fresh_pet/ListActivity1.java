package com.xpet.fresh_pet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lqr.dropdownLayout.LQRDropdownLayout;
import com.xpet.fresh_pet.adapter.ListAdapert;
import com.xpet.fresh_pet.adapter.ListHeaderAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ListActivity1 extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_kefu;
    private ImageView iv_dingzhi;
    private LQRDropdownLayout dl;
    private ImageView iv_back;
    private ImageView iv_search;
    private View listHeader;
    private RecyclerView rv_list_header;
    private EditText ed_listsearch;
    private ListAdapert mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_listone);
        initView();
        getData();
        setListener();
    }

    private void getData() {

        //下拉菜单的配置
        dl.setCols(3);
       /* TextView tv = new TextView(this);
        tv.setText("我是内容，可以是View，也可以是ViewGroup");*/

        RecyclerView recyclerView = new RecyclerView(ListActivity1.this);

        //列表
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList<String> strings = new ArrayList<>();
        strings.add("商品数据11111111");
        strings.add("商品数据22222222");
        strings.add("商品数据33333333");
        strings.add("商品数据44444444");
        strings.add("商品数据55555555");
        strings.add("商品数据66666666");
        strings.add("商品数据77777777");
        mListAdapter = new ListAdapert(R.layout.item_list, strings);
        listHeader = View.inflate(this, R.layout.list_header, null);
        mListAdapter.addHeaderView(listHeader);
        initHeaderView();

        recyclerView.setAdapter(mListAdapter);

        final List<Map<String, String>> listData = new ArrayList<>();

        Map<String, String> map = new LinkedHashMap<>();
        map.put("全北京 ", "value ");
        listData.add(map);
        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("拉布拉多 ", "value ");
        listData.add(map1);
        Map<String, String> map2 = new LinkedHashMap<>();
        map2.put("价格 ", "value ");
        map2.put("价格2 ", "value ");
        map2.put("价格3 ", "value ");
        listData.add(map2);



        //初始化（该方法必须调用）
        dl.init(recyclerView, listData);


        dl.setOnDropdownListListener(new LQRDropdownLayout.OnDropdownListListener() {
            @Override
            public void OnDropdownListSelected(int indexOfButton, int indexOfList, String textOfList, String valueOfList) {
                Toast.makeText(ListActivity1.this, "点击了" + textOfList, Toast.LENGTH_SHORT).show();
                strings.clear();
                strings.add(textOfList + "--- 商品数据");
                strings.add(textOfList + "--- 商品数据");
                strings.add(textOfList + "--- 商品数据");
                strings.add(textOfList + "--- 商品数据");
                strings.add(textOfList + "--- 商品数据");
                strings.add(textOfList + "--- 商品数据");
                strings.add(textOfList + "--- 商品数据");
                mListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onDropdownListOpen() {

            }

            @Override
            public void onDropdownListClosed() {

            }
        });







    }

    private void initHeaderView() {
        rv_list_header = (RecyclerView) listHeader.findViewById(R.id.rv_list_header);

        rv_list_header.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> headerData = new ArrayList<>();
        headerData.add("头部宠物数据1111111111111");
        headerData.add("头部宠物数据2222222222222");
        headerData.add("头部宠物数据3333333333333");
        ListHeaderAdapter listHeaderAdapter = new ListHeaderAdapter(R.layout.item_list, headerData);
        rv_list_header.setAdapter(listHeaderAdapter);
        listHeaderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(ListActivity1.this, "点击跳转到头部的详细信息", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initView() {
        iv_kefu = (ImageView) findViewById(R.id.iv_kefu); //客服按钮
        iv_dingzhi = (ImageView) findViewById(R.id.iv_dingzhi); //定制按钮
        //rv_list = (RecyclerView) findViewById(R.id.rv_list); //列表
        iv_back = (ImageView) findViewById(R.id.iv_back); //返回按钮
        iv_search = (ImageView) findViewById(R.id.iv_search); //搜索按钮
        ed_listsearch = (EditText) findViewById(R.id.ed_listsearch); //搜索栏
        dl = (LQRDropdownLayout) findViewById(R.id.dl); //下拉菜单







    }


    private void setListener() {
        iv_kefu.setOnClickListener(this);
        iv_dingzhi.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_search.setOnClickListener(this);

        ed_listsearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(ed_listsearch.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    //进行搜索操作的方法，在该方法中可以加入mEditSearchUser的非空判断
                    Toast.makeText(ListActivity1.this, "搜索隐藏", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

        mListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(ListActivity1.this, "跳转到商品的详情页", Toast.LENGTH_SHORT).show();
            }
        });

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
                try {
                    String url = "mqqwpa://im/chat?chat_type=wpa&uin=3209407802";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } catch (Exception error) {
                    Toast.makeText(this, "请安装QQ", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.iv_dingzhi:
                //定制
                startActivity(new Intent(ListActivity1.this, WebViewActivity.class));
                break;

        }

    }
}
