package com.zuzoo.zuzoomart.activity;

import com.zuzoo.zuzoomart.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodDetailActivity extends Activity implements OnClickListener {
	private ImageView pic_good, add_favor;
	private TextView name, price, rent_num, is_favor;
	private Button rent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_good_detail);
		initView();
	}

	private void initView() {
		pic_good = (ImageView) findViewById(R.id.iv_good);
		add_favor = (ImageView) findViewById(R.id.iv_add_favor);
		name = (TextView) findViewById(R.id.tv_goods);
		price = (TextView) findViewById(R.id.tv_low_price);
		rent_num = (TextView) findViewById(R.id.tv_rent_num);
		is_favor = (TextView) findViewById(R.id.tv_is_favor);
		rent = (Button) findViewById(R.id.btn_will_rent);
		add_favor.setOnClickListener(this);
		rent.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_add_favor:

			break;
		case R.id.btn_will_rent:

			break;

		default:
			break;
		}
	}
}
