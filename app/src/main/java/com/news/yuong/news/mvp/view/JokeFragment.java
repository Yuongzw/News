package com.news.yuong.news.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.news.yuong.news.R;
import com.news.yuong.news.base.BaseFragment;
import com.news.yuong.news.bean.JokeDataBean;
import com.news.yuong.news.bean.MovieDataBean;
import com.news.yuong.news.mvp.adapter.JokeAdapter;
import com.news.yuong.news.mvp.adapter.MovieAdapter;
import com.news.yuong.news.mvp.contract.JokeFragmentContract;
import com.news.yuong.news.mvp.presenter.JokeFragmentImp;
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

public class JokeFragment extends BaseFragment<JokeFragmentImp> implements JokeFragmentContract.View {
    @BindView(R.id.rv_joke)
    RecyclerView rvJoke;
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.loading)
    LottieAnimationView loading;
    @BindView(R.id.ll_loading)
    LinearLayout llLoading;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    @Inject
    JokeAdapter adapter;

    @Inject
    MovieAdapter movieAdapter;


    private List<MovieDataBean.SubjectsBean> subjectsBeans = new ArrayList<>();
    private int count = 10;
    private boolean isRefresh = true;

    @Override
    public int getLayoutId() {
        return R.layout.joke_fragment_layout;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mFragmentComponent.getActivity(), LinearLayoutManager.VERTICAL, false);
        rvJoke.setLayoutManager(linearLayoutManager);
        //添加Android自带的分割线
        rvJoke.addItemDecoration(new DividerItemDecoration(mFragmentComponent.getActivity(), DividerItemDecoration.VERTICAL));
        rvJoke.setAdapter(movieAdapter);
//        mPresenter.getJokeData(10);
        movieAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                new FinestWebView.Builder(mFragmentComponent.getActivity()).show(subjectsBeans.get(position).getAlt());
                startActivity(new Intent(mFragmentComponent.getActivity(), WebActivity.class)
                        .putExtra("url", subjectsBeans.get(position).getAlt())
                        .putExtra("title", subjectsBeans.get(position).getTitle())
                        .putExtra("isShowTitle", false));
            }
        });
        assert mPresenter != null;
        mPresenter.getMovieData(0, count);
        tvNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRefresh = true;
                count = 10;
                llLoading.setVisibility(View.VISIBLE);
                tvNoData.setVisibility(View.GONE);
                mPresenter.getMovieData(0, count);
            }
        });
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                isRefresh = true;
                count = 10;
                tvNoData.setVisibility(View.GONE);
                mPresenter.getMovieData(0, count);
            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isRefresh = false;
                int pre = count;
                count = count + 10;
                mPresenter.getMovieData(pre, count);
            }
        });
    }

    @Override
    public void setData(List<JokeDataBean.JokeBean> jokeBeans) {
        tvNoData.setVisibility(View.GONE);
        smartRefreshLayout.setVisibility(View.VISIBLE);
        llLoading.setVisibility(View.GONE);
        adapter.setNewData(jokeBeans);

    }

    @Override
    public void setMovieData(List<MovieDataBean.SubjectsBean> subjectsBeans) {
        if (isRefresh) {
           this.subjectsBeans.clear();
            smartRefreshLayout.finishRefresh();
        }else {
            smartRefreshLayout.finishLoadmore();
        }
        this.subjectsBeans.addAll(subjectsBeans);
        tvNoData.setVisibility(View.GONE);
        llLoading.setVisibility(View.GONE);
        smartRefreshLayout.setVisibility(View.VISIBLE);
        movieAdapter.setNewData(this.subjectsBeans);
    }

    @Override
    public void showNoData() {
        tvNoData.setVisibility(View.VISIBLE);
        llLoading.setVisibility(View.GONE);
        smartRefreshLayout.setVisibility(View.GONE);
    }
}
