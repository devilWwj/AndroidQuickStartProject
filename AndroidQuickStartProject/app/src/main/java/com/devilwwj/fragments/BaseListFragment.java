package com.devilwwj.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.devilwwj.app.R;
import com.devilwwj.pull.PullToRefreshBase;
import com.devilwwj.pull.PullToRefreshListView;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * com.devilwwj.fragments
 * Created by devilwwj on 16/2/17.
 */
public abstract class BaseListFragment extends BasePageFragment implements AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener<ListView> {

    protected PullToRefreshListView mPullListView;
    protected PullAdatper adapter;
    protected ImageLoader mImageLoader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageLoader = ImageLoader.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_pull, null);
        mPullListView = (PullToRefreshListView) view.findViewById(R.id.mPullListLsv);
        adapter = new PullAdatper();
        mPullListView.getRefreshableView().setAdapter(adapter);
        mPullListView.getRefreshableView().setOnItemClickListener(this);
        mPullListView.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    public void fetchData() {
        mPullListView.setRefreshing();
    }

    private class PullAdatper extends BaseAdapter {

        @Override
        public int getCount() {
            return getAdapterCount();
        }

        @Override
        public Object getItem(int position) {
            return getAdapterItem(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getAdapterViewAtPosition(position, convertView, parent);
        }
    }


    public abstract int getAdapterCount();
    public abstract Object getAdapterItem(int position);
    protected abstract View getAdapterViewAtPosition(int position, View convertView, ViewGroup parent);

}
