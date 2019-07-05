package com.news.yuong.news.mvp.contract;

import com.news.yuong.news.base.BaseContract;
import com.news.yuong.news.bean.CartoonDataBean;
import com.news.yuong.news.bean.VideoDataBean;
import com.news.yuong.news.net.INetListener;

import java.util.List;

/**
 * Created by yuong on 2018/11/15.
 * des:
 */

public interface CartoonFragmentContract {


    interface View extends BaseContract.BaseView{
        /** 设置数据源  */
        void  setData(List<CartoonDataBean.CartoonBean> cartoonBeans);

        void showNoData();

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        /**
         *获取数据
         */
        void getCartoonData();

    }

    interface Model extends BaseContract.BaseModel {
        /**
         *获取数据
         */
        void getCartoonData(INetListener<Object, Throwable, Object> listener);
    }



}
