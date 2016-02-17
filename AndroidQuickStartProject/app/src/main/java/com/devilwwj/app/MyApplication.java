package com.devilwwj.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by devilwwj on 16/2/15.
 */
public class MyApplication extends Application {

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

}
