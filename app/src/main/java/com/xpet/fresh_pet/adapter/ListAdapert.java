package com.xpet.fresh_pet.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpet.fresh_pet.R;

import java.util.List;

/**
 * Created by D on 2017/4/13.
 */

public class ListAdapert extends BaseQuickAdapter<String,BaseViewHolder> {
    public ListAdapert(int layoutResId, List data) {
        super(layoutResId, data);
    }



    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.tv_shopname,item);
        helper.getView(R.id.iv_tuan).setVisibility(View.GONE);
        helper.getView(R.id.iv_huo).setVisibility(View.GONE);
        helper.getView(R.id.tv_list_time).setVisibility(View.GONE);

    }
}
