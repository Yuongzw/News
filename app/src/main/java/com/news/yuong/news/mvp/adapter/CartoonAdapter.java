package com.news.yuong.news.mvp.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.news.yuong.news.R;
import com.news.yuong.news.bean.CartoonDataBean;
import com.news.yuong.news.bean.VideoDataBean;

import java.util.List;

import javax.inject.Inject;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class CartoonAdapter extends BaseQuickAdapter<CartoonDataBean.CartoonBean, BaseViewHolder> {

    @Inject
    public CartoonAdapter() {
        super(R.layout.cartoon_item, null);
    }

    public CartoonAdapter(int layoutResId, @Nullable List<CartoonDataBean.CartoonBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CartoonDataBean.CartoonBean item) {
        helper.setText(R.id.tv_cartoon_title, item.getTitle())
                .setText(R.id.tv_cartoon_source, item.getSource())
                .setText(R.id.tv_cartoon_time, item.getLmodify());
        Glide.with(mContext)
                .load(item.getImgsrc())
                .placeholder(R.mipmap.pic_default)
                .into((ImageView) helper.getView(R.id.iv_cartoon_bg));
    }
}
