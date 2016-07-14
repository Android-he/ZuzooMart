package com.zuzoo.zuzoomart.fragments;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.zuzoo.zuzoomart.R;
import com.zuzoo.zuzoomart.adapter.GoodsListAdapter;
import com.zuzoo.zuzoomart.model.Goods;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class CategoryFragment extends Fragment implements OnCheckedChangeListener {

	public static View v;
	private RadioGroup category;
	private RadioButton iphone, ipad, imac;
	private ListView goodsList;
	private List<Goods> data = new ArrayList<Goods>();
	private GoodsListAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_category, null, false);
		initView(v);
		iphone.setChecked(true);
		getData("手机");
		return v;
	}

	@SuppressLint("NewApi")
	private void initView(View view) {
		category = (RadioGroup) view.findViewById(R.id.rg_category);
		iphone = (RadioButton) view.findViewById(R.id.rb_phone);
		ipad = (RadioButton) view.findViewById(R.id.rb_ipad);
		imac = (RadioButton) view.findViewById(R.id.rb_pc);
		goodsList = (ListView) view.findViewById(R.id.lv_goods_category);
		category.setOnCheckedChangeListener(this);
		adapter = new GoodsListAdapter(getActivity().getApplicationContext());
		goodsList.setAdapter(adapter);
	}

	private void getData(String category) {
		AVQuery<AVObject> query = new AVQuery<AVObject>("AVGoods");
		query.whereEqualTo("kind", category);
		query.findInBackground(new FindCallback<AVObject>() {

			@Override
			public void done(List<AVObject> list, AVException e) {
				
			}
		});
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb_phone:
			data.clear();
			getData("手机");
			break;
		case R.id.rb_ipad:
			data.clear();
			getData("平板");
			break;
		case R.id.rb_pc:
			data.clear();
			getData("电脑");
			break;

		default:
			break;
		}
	}
}
