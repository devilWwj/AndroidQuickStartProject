package com.devilwwj.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.devilwwj.app.R;
import com.devilwwj.model.Module;
import com.devilwwj.pull.PullToRefreshBase;

import java.util.ArrayList;

import static android.widget.AdapterView.OnItemClickListener;

/**
 * com.devilwwj.fragments
 * Created by devilwwj on 16/2/17.
 */
public class ListFragment extends BaseListFragment implements OnItemClickListener{

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    private ViewHolder mViewHolder;
    private ArrayList<Module> modules = new ArrayList<Module>();


    @Override
    public void fetchData() {

    }

    @Override
    public int getAdapterCount() {
        return modules != null ? modules.size() : 0;
    }

    @Override
    public Object getAdapterItem(int position) {
        return modules.get(position);
    }

    @Override
    protected View getAdapterViewAtPosition(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getActivity()).inflate(R.layout.activity_pull_list_item, parent, false);
            mViewHolder.mPullListItemImg = (ImageView) convertView.findViewById(R.id.mPullListItemImg);
            mViewHolder.mPullListItemLabel = (TextView) convertView.findViewById(R.id.mPullListItemLabel);
            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        // TODO: 设置数据
        Module module = modules.get(position);
        mImageLoader.displayImage(module.getImageUrl(), mViewHolder.mPullListItemImg);
        mViewHolder.mPullListItemLabel.setText(module.getModuleName());

        return convertView;
    }

    @Override
    public void onRefresh(PullToRefreshBase<ListView> refreshView) {

    }

    static class ViewHolder {
        ImageView mPullListItemImg;
        TextView mPullListItemLabel;
    }
}
