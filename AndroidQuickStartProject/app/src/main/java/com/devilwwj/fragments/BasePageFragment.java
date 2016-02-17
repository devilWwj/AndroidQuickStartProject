package com.devilwwj.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * com.devilwwj.fragments
 * Created by devilwwj on 16/2/17.
 */
public abstract class BasePageFragment extends Fragment {
    private boolean isReadyToRefresh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }


    @Override
    public void onResume() {
        super.onResume();
        // UI可见
        isReadyToRefresh = true;
    }

    /**
     * 交给子类实现
     */
    public abstract void fetchData();


    public boolean prepareFetchData() {
        if (isReadyToRefresh) {
            fetchData();
            return true;
        }
        return false;
    }

}
