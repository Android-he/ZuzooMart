package com.zuzoo.zuzoomart.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class HomeViewpagerAdapter extends PagerAdapter {
	
	private List<View> viewList;

	public HomeViewpagerAdapter(List<View> viewList) {
		this.viewList=viewList;
	}

	@Override
	public int getCount() {
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(viewList.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view=viewList.get(position);
		container.addView(view);
		return view;
	}

}
