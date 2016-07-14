package com.zuzoo.zuzoomart.fragments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.zuzoo.zuzoomart.R;
import com.zuzoo.zuzoomart.adapter.HomeViewpagerAdapter;
import com.zuzoo.zuzoomart.adapter.HotSellAdapter;
import com.zuzoo.zuzoomart.adapter.RecyclerAdapter;
import com.zuzoo.zuzoomart.adapter.RecyclerNewAdapter;
import com.zuzoo.zuzoomart.model.Advertising;
import com.zuzoo.zuzoomart.model.Product;
import com.zuzoo.zuzoomart.view.CustomGridView;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
public class HomeFragment extends Fragment{	private ViewPager mPager;
private View life_adv1, life_adv2, life_adv3, life_adv4, life_adv0;
private ImageView adimage1, adimage2, adimage3, adimage4, adimage0;
private ScheduledExecutorService scheduledExecutorService;
private List<View> viewList;
private int currentItem = 1;
private ImageView icon_dot1;
private ImageView icon_dot2;
private ImageView icon_dot3;
private List<Advertising> advertisings;
private HomeViewpagerAdapter adapter;

private Handler handler = new Handler() {
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		mPager.setCurrentItem(currentItem);
	}
};

private LayoutInflater inflater;
private List<Product> newproducts;

private RecyclerView recycler_new;
private RecyclerView recyclerview_saleandspecials;
private CustomGridView hotsellgridview;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	this.inflater = inflater;

	viewList = new ArrayList<View>();
	advertisings = new ArrayList<Advertising>();
	advertisings.clear();
	advertisings.add(new Advertising(1, "aaa", "aaa", "aaaa", "", "", ""));
	advertisings.add(new Advertising(1, "aaa", "aaa", "aaaa", "", "", ""));
	advertisings.add(new Advertising(1, "aaa", "aaa", "aaaa", "", "", ""));
	View view = inflater.inflate(R.layout.fragment_home, null, false);
	initView(view);
	initAdvertising(view);
	setView(inflater);
	DownImage(advertisings);
	showStart();
	return view;
}

private void initView(View v) {
	newproducts = new ArrayList<Product>();
	newproducts.add(new Product("小米手机", "11:11:11", "无敌小米", "9.9元",
			"http://c1.mifile.cn/f/i/15/item/buyphone-mimax/main.jpg",
			"已抢完", "1"));
	newproducts.add(new Product("小米手机", "11:11:11", "无敌小米", "9.9元",
			"http://c1.mifile.cn/f/i/15/item/buyphone-mimax/main.jpg",
			"已抢完", "0"));
	newproducts.add(new Product("小米手机", "11:11:11", "无敌小米", "9.9元",
			"http://c1.mifile.cn/f/i/15/item/buyphone-mimax/main.jpg",
			"已抢完", "11111"));
	newproducts.add(new Product("小米手机", "11:11:11", "无敌小米", "9.9元",
			"http://c1.mifile.cn/f/i/15/item/buyphone-mimax/main.jpg",
			"已抢完", "1"));
	LinearLayoutManager lm = new LinearLayoutManager(getActivity());
	LinearLayoutManager lm1 = new LinearLayoutManager(getActivity());
	lm.setOrientation(LinearLayoutManager.HORIZONTAL);
	lm1.setOrientation(LinearLayoutManager.HORIZONTAL);

	recycler_new = (RecyclerView) v.findViewById(R.id.recyclerview_new);
	recyclerview_saleandspecials = (RecyclerView) v
			.findViewById(R.id.recyclerview_saleandspecials);
	hotsellgridview = (CustomGridView) v
			.findViewById(R.id.gridview_hotsell);
	recycler_new.setLayoutManager(lm1);
	recyclerview_saleandspecials.setLayoutManager(lm);

	RecyclerAdapter sasadapter = new RecyclerAdapter(newproducts,
			getActivity());
	RecyclerNewAdapter newAdapter = new RecyclerNewAdapter(newproducts,
			getActivity());
	HotSellAdapter hotadapter = new HotSellAdapter(getActivity(),
			newproducts);
	hotsellgridview.setAdapter(hotadapter);
	recycler_new.setAdapter(newAdapter);
	recyclerview_saleandspecials.setAdapter(sasadapter);
	hotadapter.notifyDataSetChanged();
	sasadapter.notifyDataSetChanged();
	newAdapter.notifyDataSetChanged();
}

//初始化广告
private void initAdvertising(View v) {
//	View v = inflater.inflate(R.layout.carousel, null);
	mPager = (ViewPager) v.findViewById(R.id.main_fragment_viewpager);
	adapter = new HomeViewpagerAdapter(viewList);
	mPager.setAdapter(adapter);
	mPager.setOnPageChangeListener(new MyPageChangeListener());

	icon_dot1 = (ImageView) v.findViewById(R.id.adv_img1);
	icon_dot2 = (ImageView) v.findViewById(R.id.adv_img2);
	icon_dot3 = (ImageView) v.findViewById(R.id.adv_img3);
	icon_dot1.setSelected(true);
}

// 初始化轮播图UI
private void setView(LayoutInflater inflater) {
	life_adv0 = inflater.inflate(R.layout.life_adv, null);
	life_adv1 = inflater.inflate(R.layout.life_adv, null);
	life_adv2 = inflater.inflate(R.layout.life_adv, null);
	life_adv3 = inflater.inflate(R.layout.life_adv, null);
	life_adv4 = inflater.inflate(R.layout.life_adv, null);

	adimage0 = (ImageView) life_adv0.findViewById(R.id.adimage1);
	adimage1 = (ImageView) life_adv1.findViewById(R.id.adimage1);
	adimage2 = (ImageView) life_adv2.findViewById(R.id.adimage1);
	adimage3 = (ImageView) life_adv3.findViewById(R.id.adimage1);
	adimage4 = (ImageView) life_adv4.findViewById(R.id.adimage1);
	viewList.clear();
	viewList.add(life_adv4);
	viewList.add(life_adv1);
	viewList.add(life_adv2);
	viewList.add(life_adv3);
	viewList.add(life_adv0);
	adapter.notifyDataSetChanged();
}

//广告图片点击事件
private void imageClick() {
	adimage0.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
		}
	});
	adimage1.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
		}
	});
	adimage2.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
		}
	});
	adimage3.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
		}
	});
	adimage4.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
		}
	});
}

// 下载并显示图片
public void DownImage(List<Advertising> advertisings) {
	adimage0.setBackgroundResource(R.drawable.a);
	adimage1.setBackgroundResource(R.drawable.c);
	adimage2.setBackgroundResource(R.drawable.b);
	adimage3.setBackgroundResource(R.drawable.a);
	adimage4.setBackgroundResource(R.drawable.c);
}

// 轮播
private class ShowTask implements Runnable {

	@Override
	public void run() {
		synchronized (mPager) {
			currentItem = (mPager.getCurrentItem() + 1);
			handler.obtainMessage().sendToTarget();
		}
	}
}

// 开始轮播
private void showStart() {
	scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	scheduledExecutorService.scheduleAtFixedRate(new ShowTask(), 5, 5,
			TimeUnit.SECONDS);
}

//轮播图切换监听
private class MyPageChangeListener implements OnPageChangeListener {

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		if (position < 1) {
			position = 3;
			mPager.setCurrentItem(position, false);
		} else if (position > 3) {
			mPager.setCurrentItem(1, false);
		}
		switch (position) {
		case 0:
			icon_dot1.setSelected(false);
			icon_dot2.setSelected(false);
			icon_dot3.setSelected(true);
			break;
		case 1:
			icon_dot1.setSelected(true);
			icon_dot2.setSelected(false);
			icon_dot3.setSelected(false);
			break;
		case 2:
			icon_dot1.setSelected(false);
			icon_dot2.setSelected(true);
			icon_dot3.setSelected(false);
			break;
		case 3:
			icon_dot1.setSelected(false);
			icon_dot2.setSelected(false);
			icon_dot3.setSelected(true);
			break;
		case 4:
			icon_dot1.setSelected(true);
			icon_dot2.setSelected(false);
			icon_dot3.setSelected(false);
			break;
		}
	}
}
}
