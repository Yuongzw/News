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
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.news.yuong.news.R;
import com.news.yuong.news.base.BaseFragment;
import com.news.yuong.news.bean.NewsDetailBean;
import com.news.yuong.news.mvp.adapter.NewsDetialAdapter;
import com.news.yuong.news.mvp.contract.NewsFragmentContract;
import com.news.yuong.news.mvp.presenter.NewsFragmentImp;
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

/**
 * Description :
 *
 * @author yuong
 * @date 2018/11/11  18:41
 * - generate by MvpAutoCodePlus plugin.
 */

public class NewsFragment extends BaseFragment<NewsFragmentImp> implements NewsFragmentContract.View {

    @BindView(R.id.rv_news)
    RecyclerView rvNews;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.ll_loading)
    LinearLayout llLoading;
    @BindView(R.id.animation_view)
    LottieAnimationView animationView;
    @BindView(R.id.loading)
    LottieAnimationView loading;

    @Inject
    NewsDetialAdapter adapter;

    private List<NewsDetailBean> news = new ArrayList<>();
    private int count = 20;
    private boolean isRefresh = true;

    @Override
    public int getLayoutId() {
        return R.layout.news_fragment_layout;
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
        Bundle bundle = getArguments();
        assert bundle != null;
        final String category = bundle.getString("category");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mFragmentComponent.getActivity(), LinearLayoutManager.VERTICAL, false);
        rvNews.setLayoutManager(linearLayoutManager);
        //添加Android自带的分割线
        rvNews.addItemDecoration(new DividerItemDecoration(mFragmentComponent.getActivity(), DividerItemDecoration.VERTICAL));
        rvNews.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort(news.get(position).getArticle_url());
//                new FinestWebView.Builder(mFragmentComponent.getActivity()).show(news.get(position).getArticle_url());
//                AgentWeb.with(mFragmentComponent.getActivity())
//                        .setAgentWebParent( linearLayout, new LinearLayout.LayoutParams(-1, -1))
//                        .useDefaultIndicator()
//                        .createAgentWeb()
//                        .ready()
//                        .go(news.get(position).getArticle_url());
                startActivity(new Intent(mFragmentComponent.getActivity(), WebActivity.class)
                        .putExtra("url", news.get(position).getArticle_url())
                        .putExtra("title", news.get(position).getTitle())
                        .putExtra("isShowTitle", true));
            }
        });
//        loading.setProgress(0f);
//        loading.playAnimation();
        mPresenter.getNewsData(category, count);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                isRefresh = true;
                count = 20;
                mPresenter.getNewsData(category, count);
            }
        });

        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isRefresh = false;
                count = count + 10;
                mPresenter.getNewsData(category, count);
            }
        });

        tvNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRefresh = true;
                count = 20;
                llLoading.setVisibility(View.VISIBLE);
                tvNoData.setVisibility(View.GONE);
                mPresenter.getNewsData(category, count);
            }
        });
    }

    @Override
    public void setData(List<NewsDetailBean> news) {
        if (isRefresh) {
            smartRefreshLayout.finishRefresh();
            this.news.clear();
        } else {
            smartRefreshLayout.finishLoadmore();
        }
        smartRefreshLayout.setVisibility(View.VISIBLE);
        tvNoData.setVisibility(View.GONE);
        llLoading.setVisibility(View.GONE);
//        loading.cancelAnimation();
        this.news.addAll(news);
        adapter.setNewData(this.news);
    }

    @Override
    public void showNoData() {
        tvNoData.setVisibility(View.VISIBLE);
        smartRefreshLayout.setVisibility(View.GONE);
        llLoading.setVisibility(View.GONE);
    }

    @Override
    public void showLoadingView() {
//        llLoading.setVisibility(View.VISIBLE);
//        tvNoData.setVisibility(View.GONE);
//        smartRefreshLayout.setVisibility(View.GONE);
    }

}

