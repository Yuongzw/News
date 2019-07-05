package com.news.yuong.news.mvp.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.news.yuong.news.R;
import com.news.yuong.news.util.Util;

public class CustomPopup extends PopupWindow implements View.OnClickListener {
    //上下文
    private Context mContext;
    // PopupWindow中控件点击事件回调接口
    private IPopuWindowListener mOnClickListener;

    private TextView tv_refresh;
    private TextView tv_share;
    private TextView tv_copy_link;
    private TextView tv_open_with;


    /**
     * @param
     * @description 构造方法
     * @author ldm
     * @time 2016/9/30 9:14
     */
    public CustomPopup(Context mContext, IPopuWindowListener listener) {
        super(mContext);
        this.mContext = mContext;
        this.mOnClickListener = listener;
        //获取布局文件
        View mContentView = LayoutInflater.from(mContext).inflate(R.layout.pop_layout, null);
        //设置布局
        setContentView(mContentView);
        // 设置弹窗的宽度和高度
        setWidth(Util.dip2px(200, mContext));
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置能否获取到焦点
        setFocusable(false);
        //设置PopupWindow进入和退出时的动画效果
        setAnimationStyle(R.style.popwindow_exit_anim_style);
        setTouchable(true); // 默认是true，设置为false，所有touch事件无响应，而被PopupWindow覆盖的Activity部分会响应点击
        // 设置弹窗外可点击,此时点击PopupWindow外的范围，Popupwindow不会消失
        setOutsideTouchable(true);
        //外部是否可以点击，设置Drawable原因可以参考：http://blog.csdn.net/harvic880925/article/details/49278705

//        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xffffff);
//        // 设置弹出窗体的背景
//        this.setBackgroundDrawable(dw);

        // 设置弹窗的布局界面
        initUI();
    }

    /**
     * 初始化弹窗列表
     */
    private void initUI() {
        //获取到按钮
        tv_open_with = getContentView().findViewById(R.id.tv_open_with);
        tv_copy_link = getContentView().findViewById(R.id.tv_copy_link);
        tv_refresh = getContentView().findViewById(R.id.tv_refresh);
        tv_share = getContentView().findViewById(R.id.tv_share);
        tv_refresh.setOnClickListener(this);
        tv_copy_link.setOnClickListener(this);
        tv_share.setOnClickListener(this);
        tv_open_with.setOnClickListener(this);

    }

    /**
     * 显示弹窗列表界面
     */
    public void show(View view) {
//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
        //Gravity.BOTTOM设置在view下方，还可以根据location来设置PopupWindowj显示的位置
        showAtLocation(view, Gravity.TOP, 250, 0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_refresh://刷新
                mOnClickListener.dispose(0);
                break;
            case R.id.tv_copy_link://复制链接
                mOnClickListener.dispose(1);
                break;
            case R.id.tv_share://分享
                mOnClickListener.dispose(2);
                break;
            case R.id.tv_open_with://在浏览器中打开
                mOnClickListener.dispose(3);
                break;
            default:
                break;
        }
    }

    /**
     * type：时间类型
     * 0：刷新
     * 1：复制链接
     * 2：分享
     * 3：在浏览器中打开
     */
    public interface IPopuWindowListener {
        void dispose(int type);
    }
}
