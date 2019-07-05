package com.news.yuong.news.mvp.view;

import android.content.Intent;
import android.os.Handler;

import com.news.yuong.news.R;
import com.news.yuong.news.base.BaseActivity;

/**
 * Description :
 *
 * @author yuong
 * @date 2018/11/9  16:49
 * - generate by MvpAutoCodePlus plugin.
 */

public class FlashActivity extends BaseActivity {

    @Override
    public int inflateContentView() {
        return R.layout.flash_activity_layout;
    }

    @Override
    protected void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FlashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

}

