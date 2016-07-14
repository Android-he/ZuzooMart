package com.zuzoo.zuzoomart.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.zuzoo.zuzoomart.R;
import com.zuzoo.zuzoomart.adapter.RecyclerAdapter.OnItemClickListener;
import com.zuzoo.zuzoomart.model.Advertising;
import com.zuzoo.zuzoomart.model.CategoryObject;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeListAdapter extends BaseAdapter {

	private ViewPager mPager;
	private View life_adv1, life_adv2, life_adv3, life_adv4, life_adv0;
	private ImageView adimage1, adimage2, adimage3, adimage4, adimage0;
	private ScheduledExecutorService scheduledExecutorService;
	private List<View> viewList;
	private int currentItem = 1;
	// private　ImageView icon_dot1;
	private ImageView icon_dot1;
	private ImageView icon_dot2;
	private ImageView icon_dot3;

	private LayoutInflater inflater;
	private List<CategoryObject> cateObjects;
	private Context context;

	private List<Advertising> advertisings;
	private HomeViewpagerAdapter viewpageradapter;

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			mPager.setCurrentItem(currentItem);
		}
	};

	public HomeListAdapter(List<CategoryObject> cateObjects, Context context) {
		this.cateObjects = cateObjects;
		this.inflater = LayoutInflater.from(context);
		this.context = context;
		advertisings = new ArrayList<Advertising>();
		viewList = new ArrayList<View>();
	}

	@Override
	public int getCount() {
		return cateObjects.size();
	}

	@Override
	public Object getItem(int position) {
		return cateObjects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;

		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.fragment_home_listitem,
					null);
			holder.recyclerView = (RecyclerView) convertView
					.findViewById(R.id.recyclerview);
			LinearLayoutManager lm = new LinearLayoutManager(context);
			lm.setOrientation(LinearLayoutManager.HORIZONTAL);
			holder.recyclerView.setLayoutManager(lm);
			holder.name = (TextView) convertView
					.findViewById(R.id.tv_categoryname);
			convertView.setTag(holder);
		} else {

			holder = (ViewHolder) convertView.getTag();
		}
		if (position == 0) {
			advertisings = new ArrayList<Advertising>();
			viewList = new ArrayList<View>();
			initView(inflater);
			setView(inflater);
			showStart();
		} else {
			RecyclerAdapter adapter = new RecyclerAdapter(cateObjects.get(
					position - 1).getProducts(), context);
			holder.name.setText(cateObjects.get(position - 1).getCatename());

//			LinearLayoutManager lm = new LinearLayoutManager(context);
//			lm.setOrientation(LinearLayoutManager.HORIZONTAL);
//			holder.recyclerView.setLayoutManager(lm);
			holder.recyclerView.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			adapter.setOnitemClickListener(new OnItemClickListener() {

				@Override
				public void onItemLongClick(View view, int position) {

				}

				@Override
				public void onItemClick(View view, int position) {

				}
			});
		}
		return convertView;
	}

	class ViewHolder {
		private RecyclerView recyclerView;
		private TextView name;
		private ViewPager viewPager;
		private ImageView img1;
		private ImageView img2;
		private ImageView img3;

	}

	@SuppressLint("InflateParams")
	private void initView(LayoutInflater inflater) {
		View v = inflater.inflate(R.layout.carousel, null);
		mPager = (ViewPager) v.findViewById(R.id.main_fragment_viewpager);
		viewpageradapter = new HomeViewpagerAdapter(viewList);
		mPager.setAdapter(viewpageradapter);

		mPager.setOnPageChangeListener(new MyPageChangeListener());

		icon_dot1 = (ImageView) v.findViewById(R.id.adv_img1);
		icon_dot2 = (ImageView) v.findViewById(R.id.adv_img2);
		icon_dot3 = (ImageView) v.findViewById(R.id.adv_img3);
		icon_dot1.setSelected(true);
	}

	// 初始化UI
	@SuppressLint("InflateParams")
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
		viewpageradapter.notifyDataSetChanged();

	}

	private void imageClick() {
		adimage0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (advertisings.size() > 2 && advertisings.get(2) != null) {
					// Intent intent = new Intent(context,
					// AdvertisingActivity.class);
					// Bundle bundle = new Bundle();
					// bundle.putSerializable("adv", advertisings.get(2));
					// intent.putExtras(bundle);
					// startActivity(intent);
				}
			}
		});
		adimage1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (advertisings.size() > 2 && advertisings.get(0) != null) {
					// Intent intent = new Intent(getActivity(),
					// AdvertisingActivity.class);
					// Bundle bundle = new Bundle();
					// bundle.putSerializable("adv", advertisings.get(0));
					// intent.putExtras(bundle);
					// startActivity(intent);
				}
			}
		});
		adimage2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (advertisings.size() > 2 && advertisings.get(1) != null) {
					// Intent intent = new Intent(getActivity(),
					// AdvertisingActivity.class);
					// Bundle bundle = new Bundle();
					// bundle.putSerializable("adv", advertisings.get(1));
					// intent.putExtras(bundle);
					// startActivity(intent);
				}
			}
		});
		adimage3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (advertisings.size() > 2 && advertisings.get(2) != null) {
					// Intent intent = new Intent(getActivity(),
					// AdvertisingActivity.class);
					// Bundle bundle = new Bundle();
					// bundle.putSerializable("adv", advertisings.get(2));
					// intent.putExtras(bundle);
					// startActivity(intent);
				}
			}
		});
		adimage4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// if (advertisings.size() > 2 && advertisings.get(0) != null) {
				// Intent intent = new Intent(getActivity(),
				// AdvertisingActivity.class);
				// Bundle bundle = new Bundle();
				// bundle.putSerializable("adv", advertisings.get(0));
				// intent.putExtras(bundle);
				// startActivity(intent);
				// }
			}
		});
	}

	// 下载并显示图片
	public void DownImage(List<Advertising> advertisings) {
		// getImage(ServerUrl.base(getActivity()) + ServerUrl.GETNEWSPIC
		// + advertisings.get(2).getFileName(), adimage0);
		// getImage(ServerUrl.base(getActivity()) + ServerUrl.GETNEWSPIC
		// + advertisings.get(0).getFileName(), adimage1);
		// getImage(ServerUrl.base(getActivity()) + ServerUrl.GETNEWSPIC
		// + advertisings.get(1).getFileName(), adimage2);
		// getImage(ServerUrl.base(getActivity()) + ServerUrl.GETNEWSPIC
		// + advertisings.get(2).getFileName(), adimage3);
		// getImage(ServerUrl.base(getActivity()) + ServerUrl.GETNEWSPIC
		// + advertisings.get(0).getFileName(), adimage4);
		// adimage0.setBackgroundResource(R.drawable.a);
		// adimage1.setBackgroundResource(R.drawable.c);
		// adimage2.setBackgroundResource(R.drawable.b);
		// adimage3.setBackgroundResource(R.drawable.a);
		// adimage4.setBackgroundResource(R.drawable.c);
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
