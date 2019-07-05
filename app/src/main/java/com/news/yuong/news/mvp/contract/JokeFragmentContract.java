package com.news.yuong.news.mvp.contract;

import com.news.yuong.news.base.BaseContract;
import com.news.yuong.news.bean.CartoonDataBean;
import com.news.yuong.news.bean.JokeDataBean;
import com.news.yuong.news.bean.MovieDataBean;
import com.news.yuong.news.net.INetListener;

import java.util.List;

/**
 * Created by Linsa on 2018/8/20:11:23.
 * des:
 */

public interface JokeFragmentContract {


    interface View extends BaseContract.BaseView{
        /** 设置数据源  */
        void  setData(List<JokeDataBean.JokeBean> jokeBeans);

        /** 设置数据源  */
        void  setMovieData(List<MovieDataBean.SubjectsBean> subjectsBeans);

        void showNoData();

    }

    interface Presenter extends BaseContract.BasePresenter<View>{

        /**
         *获取数据
         */
        void getJokeData(int size);

        /**
         *获取数据
         */
        void getMovieData(int start, int count);


    }

    interface Model extends BaseContract.BaseModel {

        void getJokeData(int size, INetListener<Object, Throwable, Object> listener);

        void getMovieData(int start, int count, INetListener<Object, Throwable, Object> listener);
    }



}
