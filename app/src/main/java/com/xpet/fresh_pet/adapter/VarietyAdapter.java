package com.xpet.fresh_pet.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xpet.fresh_pet.R;
import com.xpet.fresh_pet.bean.PriceEntity;

import java.util.List;

import me.yokeyword.indexablerv.IndexableHeaderAdapter;

/**
 * Created by D on 2017/4/14.
 */

public class VarietyAdapter extends IndexableHeaderAdapter<PriceEntity> {


    public VarietyAdapter(String index, String indexTitle, List<PriceEntity> datas) {
        super(index, indexTitle, datas);
    }


    @Override
    public int getItemViewType() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        View view = View.inflate(parent.getContext(), R.layout.item_varietyheader, null);
        return new ContentVH(view);
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, PriceEntity entity) {
        ContentVH vh = (ContentVH) holder;
        vh.tvHeader1.setText(entity.getPrice1());
        vh.tvHeader2.setText(entity.getPrice2());
        vh.tvHeader3.setText(entity.getPrice3());
        vh.tvHeader4.setText(entity.getPrice4());
    }

    private class ContentVH extends RecyclerView.ViewHolder {
        TextView tvHeader1;
        TextView tvHeader2;
        TextView tvHeader3;
        TextView tvHeader4;

        public ContentVH(View itemView) {
            super(itemView);
            tvHeader1 = (TextView) itemView.findViewById(R.id.tv_header1);
            tvHeader2 = (TextView) itemView.findViewById(R.id.tv_header2);
            tvHeader3 = (TextView) itemView.findViewById(R.id.tv_header3);
            tvHeader4 = (TextView) itemView.findViewById(R.id.tv_header4);
            //tvMobile = (TextView) itemView.findViewById(R.id.tv_mobile);
        }
    }


}
