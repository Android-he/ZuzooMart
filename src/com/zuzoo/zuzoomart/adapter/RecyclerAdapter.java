package com.zuzoo.zuzoomart.adapter;

import java.util.List;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zuzoo.zuzoomart.R;
import com.zuzoo.zuzoomart.model.Product;
import com.zuzoo.zuzoomart.utils.ScreenUtils;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecyclerAdapter extends
		RecyclerView.Adapter<RecyclerAdapter.ReViewHolder> {

	private List<Product> products;
	private static Context context;

	public interface OnItemClickListener {
		void onItemClick(View view, int position);

		void onItemLongClick(View view, int position);
	}

	private OnItemClickListener mOnitemClickListener;

	public void setOnitemClickListener(OnItemClickListener mOnitemClickListener) {
		this.mOnitemClickListener = mOnitemClickListener;
	}

	public RecyclerAdapter(List<Product> products, Context context) {
		this.context = context;
		this.products = products;
	}

	@Override
	public int getItemCount() {
		return products.size();
	}

	@Override
	public void onBindViewHolder(ReViewHolder holder, int position) {

		holder.productcountdown.setText(products.get(position).getTime());
		holder.productdescribe.setText(products.get(position).getDescribe());
		ImageLoader.getInstance().displayImage(products.get(position).getUrl(),
				holder.productimg);
		holder.productname.setText(products.get(position).getName());
		holder.productprice.setText(products.get(position).getPrice());
		holder.productsurplus.setText(products.get(position).getSurplus());
	}

	@Override
	public RecyclerAdapter.ReViewHolder onCreateViewHolder(ViewGroup arg0,
			int position) {
		View view = LayoutInflater.from(arg0.getContext()).inflate(
				R.layout.saleandspecialsa, null);
		ReViewHolder viewholder = new ReViewHolder(view);
		return viewholder;
	}

	public static class ReViewHolder extends RecyclerView.ViewHolder {
		public ImageView productimg;
		public TextView productname;
		public TextView productdescribe;
		public TextView productprice;
		public TextView productcountdown;
		public TextView productsurplus;
//		public RelativeLayout rl;
		public LinearLayout rl;

		public ReViewHolder(View itemView) {
			super(itemView);
//			rl = (RelativeLayout) itemView.findViewById(R.id.sas_rl);
			rl = (LinearLayout) itemView.findViewById(R.id.sas_rl);
			productcountdown = (TextView) itemView
					.findViewById(R.id.sas_countdown);
			productdescribe = (TextView) itemView
					.findViewById(R.id.sas_tv_describe);
			productimg = (ImageView) itemView.findViewById(R.id.sas_productimg);
			productprice = (TextView) itemView.findViewById(R.id.sas_tv_price);
			productsurplus = (TextView) itemView.findViewById(R.id.sas_surplus);
			productname = (TextView) itemView.findViewById(R.id.sas_tv_name);

			int screenwidth = ScreenUtils.getScreenWidth(context);
			productimg.setLayoutParams(new LinearLayout.LayoutParams((screenwidth-20)/2, (screenwidth-20)/2));
//			RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams((screenwidth-20)/2, LayoutParams.WRAP_CONTENT);
			LinearLayout.LayoutParams params=new LinearLayout.LayoutParams((screenwidth-20)/2, LayoutParams.WRAP_CONTENT);
			rl.setLayoutParams(params);

		}

	}

}
