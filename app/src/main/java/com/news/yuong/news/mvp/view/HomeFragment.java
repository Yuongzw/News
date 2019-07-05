package com.news.yuong.news.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.news.yuong.news.R;
import com.news.yuong.news.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Description :
 *
 * @author yuong
 * @date 2018/11/11  17:52
 * - generate by MvpAutoCodePlus plugin.
 */

public class HomeFragment extends BaseFragment  {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vp_home)
    ViewPager vpHome;

    private MyViewPagerAdapter pagerAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.home_fragment_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView() {
    }

    @Override
    protected void loadData() {
        pagerAdapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager());
        vpHome.setAdapter(pagerAdapter);
        vpHome.setCurrentItem(0);
        tabLayout.setupWithViewPager(vpHome);
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {
        private List<String> titles;
        private List<String>categorys;

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
            this.titles = new ArrayList<>();
            this.categorys = new ArrayList<>();
            titles.add("热点");
            titles.add("视频");
            titles.add("社会");
            titles.add("娱乐");
            titles.add("问答");
            titles.add("图片");
            titles.add("科技");
            titles.add("汽车");
            titles.add("财经");
            titles.add("军事");
            titles.add("国际");

            categorys.add("news_hot");
            categorys.add("video");
            categorys.add("news_society");
            categorys.add("news_entertainment");
            categorys.add("question_and_answer");
            categorys.add("组图");
            categorys.add("news_tech");
            categorys.add("news_car");
            categorys.add("news_finance");
            categorys.add("news_military");
            categorys.add("news_world");
        }


        @Override
        public Fragment getItem(int position) {
            NewsFragment fragment = new NewsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("category", categorys.get(position));
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return titles.size();
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title = titles.get(position);
            if (title == null) {
                title = "";
            }
            return title;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
        }

    }

}

