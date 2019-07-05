package com.news.yuong.news.mvp.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.news.yuong.news.R;
import com.news.yuong.news.base.BaseActivity;
import com.news.yuong.news.base.BaseFragment;
import com.news.yuong.news.mvp.widget.MyViewPager;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_main)
    MyViewPager vp_main;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private List<BaseFragment> fragmentList = new ArrayList<>();
    private MyPagerAdapter adapter;

    @Override
    public int inflateContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        ivBack.setVisibility(View.GONE);
        //获取管理者
//        supportFragmentManager = getSupportFragmentManager();
        //开启事务
//        fragmentTransaction = supportFragmentManager.beginTransaction();
        //碎片
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CartoonFragment());
        fragmentList.add(new VideoFragment());
        fragmentList.add(new JokeFragment());
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
        vp_main.setAdapter(adapter);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
//                hideFrag();
//                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                switch (tabId) {
                    case R.id.tab1:
                        vp_main.setCurrentItem(0);
                        Toast.makeText(MainActivity.this, "主页", Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("主页");
                        break;
                    case R.id.tab2:
                        vp_main.setCurrentItem(1);
                        Toast.makeText(MainActivity.this, "漫画", Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("漫画");
                        break;
                    case R.id.tab3:
                        vp_main.setCurrentItem(2);
                        Toast.makeText(MainActivity.this, "视频", Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("视频");
                        break;
                    case R.id.tab4:
                        vp_main.setCurrentItem(3);
//                        if (home_fragment4 == null) {
//                            //实例化fragment2
//                            home_fragment4 = new HomeFragment();
//                            fragmentTransaction.add(R.id.frameLayout, home_fragment4).commit();
//                        } else {
//                            //有的话就显示
//                            fragmentTransaction.show(home_fragment4).commit();
//                        }
                        Toast.makeText(MainActivity.this, "段子", Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("段子");
                        break;
                    default:
                        toolbar.setTitle("主页");
                        break;
                }
            }
        });

    }

//    private void hideFrag() {
//        //再重新获取一个开启事务
//        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//        //不等于空或者是否添加的时候
//        if (home_fragment1 != null && home_fragment1.isAdded()) {
//            fragmentTransaction.hide(home_fragment1);
//        }
//        if (home_fragment2 != null && home_fragment2.isAdded()) {
//            fragmentTransaction.hide(home_fragment2);
//        }
//        if (home_fragment3 != null && home_fragment3.isAdded()) {
//            fragmentTransaction.hide(home_fragment3);
//        }
//        if (home_fragment4 != null && home_fragment4.isAdded()) {
//            fragmentTransaction.hide(home_fragment4);
//        }
//        fragmentTransaction.commit();
//    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private List<BaseFragment> mfragmentList;

        public MyPagerAdapter(FragmentManager fm,List<BaseFragment> fragmentList) {
            super(fm);
            this.mfragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return mfragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mfragmentList.size();
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
        }
    }



    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
