package com.wangdaye.mysplash._common.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wangdaye.mysplash.Mysplash;
import com.wangdaye.mysplash._common.utils.DisplayUtils;
import com.wangdaye.mysplash._common.utils.LanguageUtils;
import com.wangdaye.mysplash._common.utils.NotificationUtils;

/**
 * Mysplash Activity
 * */

public abstract class MysplashActivity extends AppCompatActivity
        implements NotificationUtils.SnackbarContainer {
    // data.
    private boolean started = false;

    /** <br> life cycle. */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mysplash.getInstance().addActivity(this);
        setTheme();
        LanguageUtils.setLanguage(this);
        DisplayUtils.setWindowTop(this);
        DisplayUtils.setStatusBarTextDark(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Mysplash.getInstance().removeActivity(this);
    }

    /** <br> data. */

    public void setStarted() {
        started = true;
    }

    public boolean isStarted() {
        return started;
    }

    protected abstract void setTheme();

    protected abstract void backToTop();
}
