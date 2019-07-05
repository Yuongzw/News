package com.news.yuong.news.mvp.contract;

import com.news.yuong.news.base.BaseContract;
import com.news.yuong.news.bean.NewsBean;
import com.news.yuong.news.bean.NewsDetailBean;
import com.news.yuong.news.net.INetListener;

import java.util.List;

/**
 * Created by Linsa on 2018/8/20:11:23.
 * des:
 */

public interface NewsFragmentContract {


    interface View extends BaseContract.BaseView{
        /** 设置数据源 */
        void  setData(List<NewsDetailBean> news);

        void showNoData();

        void showLoadingView();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        /**
         *获取数据
         */
        void getNewsData(String category, int count);

    }

    interface Model extends BaseContract.BaseModel {
        void getNewsData(String category, int count, INetListener<Object, Throwable, Object> listener);
    }



}
