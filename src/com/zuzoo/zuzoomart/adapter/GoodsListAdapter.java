package com.zuzoo.zuzoomart.adapter;

import java.util.List;

import com.myworkframe.bitmap.WfImageDownloader;
import com.zuzoo.zuzoomart.R;
import com.zuzoo.zuzoomart.model.Goods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodsListAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private int phoneWidth;
	private WfImageDownloader downloader;
	private List<Goods> data;

	public GoodsListAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		downloader = new WfImageDownloader(context);
	}

	public List<Goods> getData() {
		return data;
	}

	public void setData(List<Goods> data) {
		this.data = data;
	}

	public int getPhoneWidth() {
		return phoneWidth;
	}

	public void setPhoneWidth(int phoneWidth) {
		this.phoneWidth = phoneWidth;
	}

	@Override
	public int getCount() {
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
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
			convertView = inflater.inflate(R.layout.goods_list_item, null);
			holder.pic_good = (ImageView) convertView.findViewById(R.id.iv_goods_pic);
			holder.name = (TextView) convertView.findViewById(R.id.tv_good_name);
			holder.price = (TextView) convertView.findViewById(R.id.tv_good_price);
			holder.rent_time = (TextView) convertView.findViewById(R.id.tv_good_rent_time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		downloader.display(holder.pic_good, data.get(position).getImage().getUrl());
		holder.name.setText(data.get(position).getName());
		holder.price.setText(data.get(position).getPrice());
		holder.rent_time.setText(data.get(position).getLeaseTerm());
		return convertView;
	}

	private class ViewHolder {
		ImageView pic_good;
		TextView name;
		TextView price;
		TextView rent_time;
	}
}
