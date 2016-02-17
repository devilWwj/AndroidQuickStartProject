package com.devilwwj.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devilwwj.utils.LogUtils;

/**
 * com.devilwwj.fragments
 * Created by devilwwj on 16/2/17.
 */
public class PageFragment extends BasePageFragment {

    public static PageFragment newInstance(String title) {
        PageFragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key_fragment_title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String title;
    private TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("key_fragment_title");
    }

    @Override
    public void fetchData() {
        // request
        tv.setText(title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.e("onCreateView", title);
        tv = new TextView(getActivity());
        return tv;
    }

}
