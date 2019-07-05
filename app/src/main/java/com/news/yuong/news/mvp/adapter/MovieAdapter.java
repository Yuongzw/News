package com.news.yuong.news.mvp.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.news.yuong.news.R;
import com.news.yuong.news.bean.JokeDataBean;
import com.news.yuong.news.bean.MovieDataBean;

import java.util.List;

import javax.inject.Inject;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class MovieAdapter extends BaseQuickAdapter<MovieDataBean.SubjectsBean, BaseViewHolder> {

    @Inject
    public MovieAdapter() {
        super(R.layout.movie_item, null);
    }

    public MovieAdapter(int layoutResId, @Nullable List<MovieDataBean.SubjectsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieDataBean.SubjectsBean item) {
        helper.setText(R.id.tv_movie_title, item.getTitle())
                .setText(R.id.tv_movie_original_title, item.getOriginal_title())
                .setText(R.id.tv_movie_directors, item.getDirectors().get(0).getName())
                .setText(R.id.tv_movie_average, item.getRating().getAverage() + "")
                .setText(R.id.tv_movie_num, item.getCollect_count() + "")
                .setText(R.id.tv_movie_year, item.getYear());

        String casts = "";
        String category = "";
        for (MovieDataBean.SubjectsBean.CastsBean castsBean : item.getCasts()) {
            casts = casts + castsBean.getName() + "、";
        }
        for (String str : item.getGenres()) {
            category = category + str + "、";
        }
        if (casts.length() > 0) {
            helper.setText(R.id.tv_movie_casts, casts.substring(0, casts.length() - 1));
        }
        helper.setText(R.id.tv_movie_category, category.substring(0, category.length() - 1));

        Glide.with(mContext)
                .load(item.getImages().getLarge())
                .placeholder(R.mipmap.pic_default)
                .into((ImageView) helper.getView(R.id.iv_movie_bg));

    }
}
