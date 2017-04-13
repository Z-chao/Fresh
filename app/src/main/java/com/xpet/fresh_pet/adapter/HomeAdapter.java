package com.xpet.fresh_pet.adapter;



import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpet.fresh_pet.ListActivity1;
import com.xpet.fresh_pet.R;


import java.util.List;

/**
 * Created by D on 2017/4/10.
 */

public class HomeAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    private final List<String> data;

    public HomeAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        this.data = data;
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_home1, item);
        ImageView imageView = helper.getView(R.id.iv_home1);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                context.startActivity(new Intent(context, ListActivity1.class));
            }
        });

    }
}
