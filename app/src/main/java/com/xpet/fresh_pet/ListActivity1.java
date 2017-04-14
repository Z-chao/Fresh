package com.xpet.fresh_pet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhouwei.library.CustomPopWindow;
import com.xpet.fresh_pet.adapter.ContactAdapter;
import com.xpet.fresh_pet.adapter.ListAdapert;
import com.xpet.fresh_pet.adapter.ListHeaderAdapter;
import com.xpet.fresh_pet.adapter.ListPriceAdapter;
import com.xpet.fresh_pet.adapter.VarietyAdapter;
import com.xpet.fresh_pet.bean.PriceEntity;
import com.xpet.fresh_pet.bean.UserEntity;
import com.xpet.fresh_pet.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;
import me.yokeyword.indexablerv.SimpleHeaderAdapter;


public class ListActivity1 extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_kefu;
    private ImageView iv_dingzhi;
    private ImageView iv_back;
    private ImageView iv_search;
    private View listHeader;
    private RecyclerView rv_list_header;
    private EditText ed_listsearch;
    private ListAdapert mListAdapter;
    private RecyclerView rv_list;
    private TextView tv_chengshi;
    private TextView tv_pingzhong;
    private TextView tv_jiage;
    private DisplayMetrics metrics;
    private CustomPopWindow mListPopWindow;
    private LinearLayout ll_price;
    private LinearLayout ll_pingzhong;

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

        rv_list.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> strings = new ArrayList<>();
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

        rv_list.setAdapter(mListAdapter);



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
        rv_list = (RecyclerView) findViewById(R.id.rv_list); //列表
        iv_back = (ImageView) findViewById(R.id.iv_back); //返回按钮
        iv_search = (ImageView) findViewById(R.id.iv_search); //搜索按钮
        ed_listsearch = (EditText) findViewById(R.id.ed_listsearch); //搜索栏
        tv_chengshi = (TextView) findViewById(R.id.tv_chengshi); //城市
        tv_pingzhong = (TextView) findViewById(R.id.tv_pingzhong); //品种
        tv_jiage = (TextView) findViewById(R.id.tv_jiage); //价格
        ll_price = (LinearLayout) findViewById(R.id.ll_price); //价格下拉
        ll_pingzhong = (LinearLayout) findViewById(R.id.ll_pingzhong); //品种下拉


        //获取屏幕的高度
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

    }


    private void setListener() {
        iv_kefu.setOnClickListener(this);
        iv_dingzhi.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        ll_pingzhong.setOnClickListener(this);
        ll_price.setOnClickListener(this);

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
               // Toast.makeText(ListActivity1.this, "跳转到商品的详情页", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ListActivity1.this,DetailActivity.class));

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

            case R.id.ll_pingzhong:
                //品种下拉选项
                showVariety();

                break;

            case R.id.ll_price:
                //价格下拉选项
                showPrice();



                break;

        }

    }

    /**
     * 品种下拉选项菜单
     */
    private void showVariety() {
        View varietyView = LayoutInflater.from(this).inflate(R.layout.pop_varietylist,null);
        IndexableLayout indexView = (IndexableLayout) varietyView.findViewById(R.id.indexView);
        indexView.setLayoutManager(new LinearLayoutManager(this));
        ContactAdapter mAdapter = new ContactAdapter(this);
        indexView.setAdapter(mAdapter);
        mAdapter.setDatas(initDatas());

        indexView.setCompareMode(IndexableLayout.MODE_FAST);
        List<UserEntity> list = new ArrayList<>();
        list.add(new UserEntity("不限", "10000"));
        indexView.addHeaderAdapter(new SimpleHeaderAdapter<>(mAdapter, "☆", "全部品种", list));

        List<PriceEntity> hotdata = new ArrayList<>();
        hotdata.add(new PriceEntity("热门狗1","冷门狗1","看门狗1","嗓门狗1"));
        hotdata.add(new PriceEntity("热门狗2","冷门狗2","看门狗2","嗓门狗2"));
        hotdata.add(new PriceEntity("热门狗3","冷门狗3","看门狗3","嗓门狗3"));
        indexView.addHeaderAdapter(new VarietyAdapter(null,"热门品种",hotdata));

        indexView.setOverlayStyle_Center();

        int heightPixels1 = metrics.heightPixels;
        double v = heightPixels1 * 0.3;
        mListPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(varietyView)
                .enableBackgroundDark(false) //弹出popWindow时，背景是否变暗
                .size(ViewGroup.LayoutParams.MATCH_PARENT, (int) (heightPixels1 - v))//显示大小
                .create()
                .showAsDropDown(ll_pingzhong, 0, 0);


        mAdapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<UserEntity>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, UserEntity entity) {
                if (originalPosition >= 0) {
                    //ToastUtil.showShort(ListActivity1.this, "选中:" + entity.getNick() + "  当前位置:" + currentPosition + "  原始所在数组位置:" + originalPosition);
                    tv_pingzhong.setText(entity.getNick());
                    mListPopWindow.dissmiss();
                } else {
                   // ToastUtil.showShort(ListActivity1.this, "选中Header/Footer:" + entity.getNick() + "  当前位置:" + currentPosition);
                    tv_pingzhong.setText(entity.getNick());
                    mListPopWindow.dissmiss();
                }
            }
        });

        mAdapter.setOnItemTitleClickListener(new IndexableAdapter.OnItemTitleClickListener() {
            @Override
            public void onItemClick(View v, int currentPosition, String indexTitle) {
                ToastUtil.showShort(ListActivity1.this, "选中:" + indexTitle + "  当前位置:" + currentPosition);
            }
        });



    }

    /**
     * 价格下拉选项菜单
     */
    private void showPrice() {

        View priceView= LayoutInflater.from(this).inflate(R.layout.pop_pricelist,null);
        int heightPixels = metrics.heightPixels;
        RecyclerView rv_list = (RecyclerView) priceView.findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(ListActivity1.this));
        final List<String> data = new ArrayList<>();
        data.add("不限");
        data.add("500 - 1000");
        data.add("1000 - 1500");
        data.add("1500 - 2000");
        data.add("2500 - 3000");
        data.add("3000 - 5000");
        data.add("5000元以上");
        data.add("自定义价格");
        ListPriceAdapter adapter = new ListPriceAdapter(R.layout.item_contact, data);
        rv_list.setAdapter(adapter);


        mListPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(priceView)
                .enableBackgroundDark(false) //弹出popWindow时，背景是否变暗
                .size(ViewGroup.LayoutParams.MATCH_PARENT, heightPixels - 500)//显示大小
                .create()
                .showAsDropDown(ll_price, 0, 0);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                tv_jiage.setText(data.get(position));
                mListPopWindow.dissmiss();
            }
        });

    }

    /**
     * 假数据    配上接口以后 删除
     * @return
     */
    private List<UserEntity> initDatas() {
        List<UserEntity> list = new ArrayList<>();
        // 初始化数据
        List<String> contactStrings = Arrays.asList(getResources().getStringArray(R.array.contact_array));
        List<String> mobileStrings = Arrays.asList(getResources().getStringArray(R.array.mobile_array));
        for (int i = 0; i < contactStrings.size(); i++) {
            UserEntity contactEntity = new UserEntity(contactStrings.get(i), mobileStrings.get(i));
            list.add(contactEntity);
        }
        return list;
    }




}
