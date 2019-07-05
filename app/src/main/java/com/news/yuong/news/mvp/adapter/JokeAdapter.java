package com.news.yuong.news.mvp.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.news.yuong.news.R;
import com.news.yuong.news.bean.CartoonDataBean;
import com.news.yuong.news.bean.JokeDataBean;

import java.util.List;

import javax.inject.Inject;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class JokeAdapter extends BaseQuickAdapter<JokeDataBean.JokeBean, BaseViewHolder> {

    @Inject
    public JokeAdapter() {
        super(R.layout.joke_item, null);
    }

    public JokeAdapter(int layoutResId, @Nullable List<JokeDataBean.JokeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JokeDataBean.JokeBean item) {
        JzvdStd jzvdStd = helper.getView(R.id.joke_player);
        String playCount = "";
        if (item.getVideoinfo() != null) {
            if (item.getVideoinfo().getPlayCount() < 10000) {
                playCount = item.getVideoinfo().getPlayCount() + "次播放";
            } else {
                double n = (double) item.getVideoinfo().getPlayCount() / 10000;
                playCount = n + "万次播放";
            }
            helper.setVisible(R.id.rl_iv, false);
            helper.setVisible(R.id.joke_player, true);
            helper.setText(R.id.tv_joke_title, item.getVideoinfo().getTitle())
                    .setText(R.id.tv_joke_source,"来源:" +  item.getVideoinfo().getVideosource());
            Glide.with(mContext)
                    .load(item.getVideoinfo().getCover())
                    .placeholder(R.mipmap.pic_default)
                    .into(((JzvdStd) helper.getView(R.id.joke_player)).thumbImageView);
            jzvdStd.setUp(
                    item.getVideoinfo().getMp4_url(),
                    item.getVideoinfo().getTitle(), playCount, Jzvd.SCREEN_WINDOW_LIST);
        } else {
            helper.setVisible(R.id.rl_iv, true);
            helper.setVisible(R.id.joke_player, false);
            helper.setText(R.id.tv_joke_title, item.getTitle())
                    .setText(R.id.tv_joke_source, "来源:" + item.getSource());
            Glide.with(mContext)
                    .load(item.getImgsrc())
                    .placeholder(R.mipmap.pic_default)
                    .into((ImageView) helper.getView(R.id.iv_joke_bg));
        }

    }
}
