package com.news.yuong.news.mvp.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.news.yuong.news.R;
import com.news.yuong.news.base.BaseFragment;
import com.news.yuong.news.bean.VideoDataBean;
import com.news.yuong.news.mvp.adapter.VideoAdapter;
import com.news.yuong.news.mvp.contract.VideoFragmentContract;
import com.news.yuong.news.mvp.presenter.VideoFragmentImp;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jzvd.Jzvd;

public class VideoFragment extends BaseFragment<VideoFragmentImp> implements VideoFragmentContract.View {

    @BindView(R.id.rv_video)
    RecyclerView rvVideo;
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.loading)
    LottieAnimationView loading;
    @BindView(R.id.ll_loading)
    LinearLayout llLoading;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    private List<VideoDataBean.VideoBean> videoBeans = new ArrayList<>();
    private boolean isRefresh = true;
    @Inject
    VideoAdapter adapter;
    private int size = 10;

    @Override
    public int getLayoutId() {
        return R.layout.video_fragment_layout;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    protected void loadData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvVideo.setLayoutManager(linearLayoutManager);
        //添加Android自带的分割线
//        rvVideo.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rvVideo.setAdapter(adapter);
        mPresenter.getVideoData(size);
        tvNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size = 10;
                isRefresh = true;
                llLoading.setVisibility(View.VISIBLE);
                tvNoData.setVisibility(View.GONE);
                mPresenter.getVideoData(size);
            }
        });
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                size = 10;
                isRefresh = true;
                mPresenter.getVideoData(size);
            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isRefresh = false;
                size = size + 10;
                mPresenter.getVideoData(size);
            }
        });
    }

    @Override
    public void setData(List<VideoDataBean.VideoBean> videoBeans) {
        if (isRefresh) {
            smartRefreshLayout.finishRefresh();
            this.videoBeans.clear();
        } else {
            smartRefreshLayout.finishLoadmore();
        }
        smartRefreshLayout.setVisibility(View.VISIBLE);
        tvNoData.setVisibility(View.GONE);
        llLoading.setVisibility(View.GONE);
        this.videoBeans.addAll(videoBeans);
        adapter.setNewData(this.videoBeans);
    }

    @Override
    public void showNoData() {
        tvNoData.setVisibility(View.VISIBLE);
        llLoading.setVisibility(View.GONE);
        smartRefreshLayout.setVisibility(View.GONE);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser) {
            Jzvd.releaseAllVideos();
        }
    }

}
