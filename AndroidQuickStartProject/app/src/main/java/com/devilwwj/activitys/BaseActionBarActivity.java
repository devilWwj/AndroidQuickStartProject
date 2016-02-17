package com.devilwwj.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

/**
 * com.devilwwj.activitys
 * Created by devilwwj on 16/2/17.
 */
public abstract class BaseActionBarActivity extends ActionBarActivity {
    private static final String TAG = "BaseActionBarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
