package com.news.yuong.news.mvp.view;

import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.just.agentweb.AgentWeb;
import com.news.yuong.news.R;
import com.news.yuong.news.base.BaseActivity;
import com.news.yuong.news.mvp.widget.CustomPopup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity implements CustomPopup.IPopuWindowListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.iv_pre)
    ImageView ivPre;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private AgentWeb mAgentWeb;

    private boolean isUp = false;
    private boolean isShowTitle;
    private CustomPopup mPop;

    @Override
    public int inflateContentView() {
        return R.layout.activity_web;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initData() {

        isShowTitle = getIntent().getBooleanExtra("isShowTitle", true);
        if (!isShowTitle) {
            toolbar.setVisibility(View.GONE);
        }

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(linearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(getIntent().getStringExtra("url"));
        String title = mAgentWeb.getWebCreator().getWebView().getTitle();
        if (title.equals("")) {
            title = getIntent().getStringExtra("title");
        }
        tvTitle.setText(title);
        ivPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mAgentWeb.back()) {
                    finish();
                } else {
                    mAgentWeb.back();
                }
            }
        });
        //初始化PopupWindow这里通过数据200来设置PopupWindow高度
        mPop = new CustomPopup(this, this);//这里的this是指当前Activity实现了PopupWindow中IPopuWindowListener接口


        mAgentWeb.getWebCreator().getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int l, int t, int oldl, int oldt) {
                if (t > oldt && t - oldt > 50) {
                    //下滑
                    hiidTop(toolbar);
                } else if ((t < oldt && oldt - t > 50)) {
                    //上滑
                    showTop(toolbar);
                }
                Log.e("mAgentWeb", mAgentWeb.getWebCreator().getWebView().getScrollY() + "   " + t + "  " + oldt);

            }
        });
    }


    //隐藏头部
    private void hiidTop(final View mTarget) {
        // 这种效果最好
        ValueAnimator va = ValueAnimator.ofFloat(0, -mTarget.getHeight());//
        va.setDuration(800);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                /**
                 * 通过这样一个监听事件，我们就可以获取
                 * 到ValueAnimator每一步所产生的值。
                 *
                 * 通过调用getAnimatedValue()获取到每个时间因子所产生的Value。
                 * */
                mTarget.setY((Float) valueAnimator.getAnimatedValue());
            }
        });
        if (!isUp) {
            va.start();
            isUp = true;
        }
    }

    //显示头部
    private void showTop(final View mTarget) {
        //这种效果最好
        ValueAnimator va = ValueAnimator.ofFloat(-mTarget.getHeight(), 0);
        va.setDuration(800);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mTarget.setY((Float) valueAnimator.getAnimatedValue());
            }
        });
        if (isUp) {
            va.start();
            isUp = false;
        }

    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAgentWeb.getWebLifeCycle().onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAgentWeb.getWebLifeCycle().onResume();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //导入菜单布局
        getMenuInflater().inflate(R.menu.web_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //创建菜单项的点击事件
        switch (item.getItemId()) {
            case R.id.menu_refresh://刷新
                mAgentWeb.getWebCreator().getWebView().reload();
                break;
            case R.id.menu_share://分享
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, mAgentWeb.getWebCreator().getWebView().getUrl());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            case R.id.menu_copy_link://复制链接
                //添加到剪切板
                ClipboardManager clipboardManager =
                        (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                /**之前的应用过期的方法，clipboardManager.setText(copy);*/
                assert clipboardManager != null;
                clipboardManager.setPrimaryClip(ClipData.newPlainText(null,mAgentWeb.getWebCreator().getWebView().getUrl()));
                if (clipboardManager.hasPrimaryClip()){
                    clipboardManager.getPrimaryClip().getItemAt(0).getText();
                }
                Toast.makeText(this, "链接已复制到剪贴板", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_open_with://在浏览器中打开
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mAgentWeb.getWebCreator().getWebView().getUrl()));
                startActivity(browserIntent);
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (!mAgentWeb.back()) {
                finish();
            } else {
                mAgentWeb.back();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void dispose(int type) {
        switch (type) {
            case 0://刷新
                mAgentWeb.getWebCreator().getWebView().reload();
                mPop.dismiss();
                break;
            case 1://复制链接
//                ClipboardManagerUtil.setText(mAgentWeb.getWebCreator().getWebView().getUrl());
                //添加到剪切板
                ClipboardManager clipboardManager =
                        (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                /**之前的应用过期的方法，clipboardManager.setText(copy);*/
                assert clipboardManager != null;
                clipboardManager.setPrimaryClip(ClipData.newPlainText(null,mAgentWeb.getWebCreator().getWebView().getUrl()));
                if (clipboardManager.hasPrimaryClip()){
                    clipboardManager.getPrimaryClip().getItemAt(0).getText();
                }
                Toast.makeText(this, "链接已复制到剪贴板", Toast.LENGTH_SHORT).show();
                mPop.dismiss();
                break;
            case 2://分享
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, mAgentWeb.getWebCreator().getWebView().getUrl());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                mPop.dismiss();
                break;
            case 3://在浏览器中打开
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mAgentWeb.getWebCreator().getWebView().getUrl()));
                startActivity(browserIntent);
                mPop.dismiss();
                break;
            default:
                break;
        }
    }
}
