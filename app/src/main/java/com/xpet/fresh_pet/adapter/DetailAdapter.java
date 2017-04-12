package com.xpet.fresh_pet.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpet.fresh_pet.R;

import java.util.List;

import static com.xpet.fresh_pet.R.id.tv_shopname;

/**
 * Created by D on 2017/4/12.
 */

public class DetailAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public DetailAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }





    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_shopname, item);
    }
}
