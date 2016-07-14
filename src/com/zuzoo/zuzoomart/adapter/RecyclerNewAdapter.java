package com.zuzoo.zuzoomart.adapter;

import java.util.List;

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

public class RecyclerNewAdapter extends
		RecyclerView.Adapter<RecyclerNewAdapter.ReViewHolder> {

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

	public RecyclerNewAdapter(List<Product> products, Context context) {
		this.context = context;
		this.products = products;
	}

	@Override
	public int getItemCount() {
		return products.size();
	}

	@Override
	public void onBindViewHolder(ReViewHolder holder, int position) {

		holder.tv_newproductname.setText(products.get(position).getName());
		holder.tv_newproductprice.setText("¥"+products.get(position).getPrice());
	
	}

	@Override
	public RecyclerNewAdapter.ReViewHolder onCreateViewHolder(ViewGroup arg0,
			int position) {
		View view = LayoutInflater.from(arg0.getContext()).inflate(
				R.layout.newproduct_item, null);
		ReViewHolder viewholder = new ReViewHolder(view);
		return viewholder;
	}

	public static class ReViewHolder extends RecyclerView.ViewHolder {
		public TextView tv_newproductprice;
		public TextView tv_newproductname; 
		public ImageView img_newproductImageView;
		public LinearLayout ll;
		public ReViewHolder(View itemView) {
			super(itemView);
			// rl = (RelativeLayout) itemView.findViewById(R.id.sas_rl);
			ll = (LinearLayout) itemView.findViewById(R.id.ll_newproduct);
			tv_newproductname=(TextView) itemView.findViewById(R.id.tv_newproductname);
			tv_newproductprice=(TextView) itemView.findViewById(R.id.tv_newproductprice);
			img_newproductImageView = (ImageView) itemView
					.findViewById(R.id.img_newproduct);
			int screenwidth = ScreenUtils.getScreenWidth(context);
			img_newproductImageView.setLayoutParams(new LinearLayout.LayoutParams(
					(screenwidth - 40) / 3, (screenwidth - 40) / 3));

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					(screenwidth - 20) / 3, LayoutParams.WRAP_CONTENT);
			ll.setLayoutParams(params);

		}

	}

}
