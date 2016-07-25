package com.wisdom.viewpager;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerAdapter extends PagerAdapter {

	/**
	 * 保存当前activity引用
	 */
	private ViewPagerActivity mContext;
	/**
	 * 保存当前所有页面
	 */
	private ArrayList<View> mViewItems;
	/**
	 * 当前页面的布局
	 */
	private View convertView;

	public ViewPagerAdapter(ViewPagerActivity context, ArrayList<View> viewItems) {
		mContext = context;
		mViewItems = viewItems;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViewItems.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		convertView = mViewItems.get(position);
		// 此处自定义页面数据处理
		container.addView(mViewItems.get(position));
		return mViewItems.get(position);
	}

	@Override
	public int getCount() {
		if (mViewItems == null || mViewItems.size() == 0)
			return 1;
		return mViewItems.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

}
