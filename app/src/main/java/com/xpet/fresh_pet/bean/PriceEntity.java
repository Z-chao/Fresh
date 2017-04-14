package com.xpet.fresh_pet.bean;

import me.yokeyword.indexablerv.IndexableEntity;

/**
 * Created by D on 2017/4/14.
 */

public class PriceEntity implements IndexableEntity {
    private String price1;
    private String price2;
    private String price3;
    private String price4;

    public PriceEntity(String price1, String price2, String price3, String price4) {
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.price4 = price4;
    }


    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getPrice3() {
        return price3;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
    }

    public String getPrice4() {
        return price4;
    }

    public void setPrice4(String price4) {
        this.price4 = price4;
    }

    @Override
    public String getFieldIndexBy() {
        return null;
    }

    @Override
    public void setFieldIndexBy(String indexField) {

    }

    @Override
    public void setFieldPinyinIndexBy(String pinyin) {

    }
}
