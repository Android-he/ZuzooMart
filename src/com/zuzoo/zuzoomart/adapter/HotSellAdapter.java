package com.zuzoo.zuzoomart.adapter;

import java.util.List;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zuzoo.zuzoomart.R;
import com.zuzoo.zuzoomart.model.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HotSellAdapter extends BaseAdapter {
	
	private Context context;
	private LayoutInflater inflater;
	private List<Product> hotsellproducts;

	public HotSellAdapter(Context context,List<Product> hotsellproducts){
		this.context=context;
		this.inflater=LayoutInflater.from(context);
		this.hotsellproducts=hotsellproducts;
	}
	
	@Override
	public int getCount() {
		return hotsellproducts.size();
	}

	@Override
	public Object getItem(int position) {
		return hotsellproducts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.hotsell_item, null);
			holder.img_hotsell=(ImageView) convertView.findViewById(R.id.img_hotsell);
			holder.tv_hotselled=(TextView) convertView.findViewById(R.id.tv_hotselled);
			holder.tv_hotsellname=(TextView) convertView.findViewById(R.id.tv_hotsellname);
			holder.tv_hotsellprice=(TextView) convertView.findViewById(R.id.tv_hotsellprice);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		ImageLoader.getInstance().displayImage(hotsellproducts.get(position).getUrl(), holder.img_hotsell);
		holder.tv_hotselled.setText("已售"+hotsellproducts.get(position).getSelled()+"件");
		holder.tv_hotsellname.setText(hotsellproducts.get(position).getName());
		holder.tv_hotsellprice.setText("¥ "+hotsellproducts.get(position).getPrice());
		return convertView;
	}
	
	class ViewHolder{
		private ImageView img_hotsell;
		private TextView tv_hotsellname;
		private TextView tv_hotsellprice;
		private TextView tv_hotselled;
	}

}
