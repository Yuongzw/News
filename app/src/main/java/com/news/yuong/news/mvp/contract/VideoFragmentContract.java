package com.news.yuong.news.mvp.contract;

import com.news.yuong.news.base.BaseContract;
import com.news.yuong.news.bean.NewsDetailBean;
import com.news.yuong.news.bean.VideoDataBean;
import com.news.yuong.news.net.INetListener;

import java.util.List;

/**
 * Created by Linsa on 2018/8/20:11:23.
 * des:
 */

public interface VideoFragmentContract {


    interface View extends BaseContract.BaseView{
        /** 设置数据源  */
        void  setData(List<VideoDataBean.VideoBean> videoBeans);

        void showNoData();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        /**
         *获取数据
         */
        void getVideoData(int size);

    }

    interface Model extends BaseContract.BaseModel{
        void getVideoData(int size, INetListener<Object, Throwable, Object> listener);
    }



}
