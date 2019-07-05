package com.news.yuong.news.mvp.adapter;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.news.yuong.news.R;
import com.news.yuong.news.bean.NewsDetailBean;
import com.news.yuong.news.bean.VideoDataBean;
import com.news.yuong.news.util.Util;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.inject.Inject;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class VideoAdapter extends BaseQuickAdapter<VideoDataBean.VideoBean, BaseViewHolder> {

    @Inject
    public VideoAdapter() {
        super(R.layout.video_item, null);
    }

    public VideoAdapter(int layoutResId, @Nullable List<VideoDataBean.VideoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoDataBean.VideoBean item) {
        JzvdStd jzvdStd = helper.getView(R.id.video_player);
        String playCount = "";
        if (item.getPlayCount() < 10000) {
            playCount = item.getPlayCount() + "次播放";
        } else {
            double n = (double) item.getPlayCount() / 10000;
            playCount = n + "万次播放";
        }
        jzvdStd.setUp(
                item.getMp4_url(),
                item.getTitle(), playCount, Jzvd.SCREEN_WINDOW_LIST);
        helper.setText(R.id.tv_video_source, item.getVideosource())
                .setText(R.id.tv_video_time, item.getPtime())
                .setText(R.id.tv_video_category, item.getCategory());
//        jzvdStd.thumbImageView.setImageBitmap(Util.getNetVideoBitmap(item.getMp4_url()));
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Util.getNetVideoBitmap(item.getMp4_url()).compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte[] bytes=baos.toByteArray();

        Glide.with(mContext)
                .load(item.getFirstFrameImg())
                .into(jzvdStd.thumbImageView);
    }
}
