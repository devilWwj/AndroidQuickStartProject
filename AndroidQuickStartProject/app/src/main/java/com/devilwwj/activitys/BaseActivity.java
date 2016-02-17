package com.devilwwj.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by devilwwj on 16/2/15.
 */
public abstract class BaseActivity extends Activity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView();
        initData();
        initViews();
    }


    // 这些通用方法交给子类实现
    protected abstract void setContentView();
    protected abstract void initData();
    protected abstract void initViews();



    public final <E extends View> E getView(int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            Log.e(TAG, "Could not cast View to concrete class.", ex);
            throw ex;
        }
    }

}
