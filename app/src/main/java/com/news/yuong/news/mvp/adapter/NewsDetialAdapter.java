package com.news.yuong.news.mvp.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.news.yuong.news.R;
import com.news.yuong.news.bean.NewsDetailBean;
import com.news.yuong.news.util.Util;

import java.util.List;

import javax.inject.Inject;

public class NewsDetialAdapter extends BaseQuickAdapter<NewsDetailBean, BaseViewHolder> {

    @Inject
    public NewsDetialAdapter() {
        super(R.layout.news_item, null);
    }

    public NewsDetialAdapter(int layoutResId, @Nullable List<NewsDetailBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsDetailBean item) {
        helper.setText(R.id.tv_news_title, item.getTitle())
        .setText(R.id.tv_news_source, item.getSource())
        .setText(R.id.tv_news_time, Util.getDateToString(item.getBehot_time() + "", "yyyy-MM-dd HH:mm"));
        if (item.getMiddle_image() != null) {
            Glide.with(mContext)
                    .load(item.getMiddle_image().getUrl())
                    .into((ImageView) helper.getView(R.id.iv_news));
            helper.getView(R.id.iv_news).setVisibility(View.VISIBLE);
        }else {
            helper.getView(R.id.iv_news).setVisibility(View.GONE);
        }


    }
}
