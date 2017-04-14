package com.xpet.fresh_pet.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpet.fresh_pet.R;

import java.util.List;

/**
 * Created by D on 2017/4/13.
 */

public class ListPriceAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public ListPriceAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_name, item);
    }
}
