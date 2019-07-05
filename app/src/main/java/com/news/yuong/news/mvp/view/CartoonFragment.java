package com.news.yuong.news.mvp.view;

import android.content.Intent;
import android.os.Bundle;
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
import com.news.yuong.news.bean.CartoonDataBean;
import com.news.yuong.news.mvp.adapter.CartoonAdapter;
import com.news.yuong.news.mvp.contract.CartoonFragmentContract;
import com.news.yuong.news.mvp.presenter.CartoonFragmentImp;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CartoonFragment extends BaseFragment<CartoonFragmentImp> implements CartoonFragmentContract.View {

    @BindView(R.id.rv_cartoon)
    RecyclerView rvCartoon;
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.loading)
    LottieAnimationView loading;
    @BindView(R.id.ll_loading)
    LinearLayout llLoading;
    private List<CartoonDataBean.CartoonBean> cartoonBeans;

    @Inject
    CartoonAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.cartoon_fragment_layout;
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
        rvCartoon.setLayoutManager(linearLayoutManager);
        rvCartoon.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                new FinestWebView.Builder(mFragmentComponent.getActivity()).show(cartoonBeans.get(position).getUrl());
                startActivity(new Intent(mFragmentComponent.getActivity(), WebActivity.class)
                        .putExtra("url", cartoonBeans.get(position).getUrl())
                        .putExtra("title", cartoonBeans.get(position).getTitle())
                        .putExtra("isShowTitle", true));
            }
        });
        mPresenter.getCartoonData();
        tvNoData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llLoading.setVisibility(View.VISIBLE);
                tvNoData.setVisibility(View.GONE);
                mPresenter.getCartoonData();
            }
        });
    }

    @Override
    public void setData(List<CartoonDataBean.CartoonBean> cartoonBeans) {
        tvNoData.setVisibility(View.GONE);
        rvCartoon.setVisibility(View.VISIBLE);
        llLoading.setVisibility(View.GONE);
        this.cartoonBeans = cartoonBeans;
        adapter.setNewData(cartoonBeans);
    }

    @Override
    public void showNoData() {
        tvNoData.setVisibility(View.VISIBLE);
        rvCartoon.setVisibility(View.GONE);
        llLoading.setVisibility(View.GONE);
    }

}
