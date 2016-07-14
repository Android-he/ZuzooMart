package com.zuzoo.zuzoomart.activity;

import com.zuzoo.zuzoomart.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RentDetailsActivity extends Activity implements OnCheckedChangeListener, OnClickListener {

	private ImageView picture, deposit_why, rent_why;
	private ImageButton minus, add;
	private RadioGroup size, rg_color, rg_month, way_pay;
	private RadioButton rb_month, rent_before, rent_after, rent_monthly;
	private CheckBox version, insurence;
	private TextView lower_price, goods_num, buy_num, deposit, rent_money;
	private Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rent_details);
		initView();
	}

	private void initView() {
		picture = (ImageView) findViewById(R.id.iv_pic_detail);
		deposit_why = (ImageView) findViewById(R.id.iv_why);
		rent_why = (ImageView) findViewById(R.id.iv_why2);
		minus = (ImageButton) findViewById(R.id.ib_num_min);
		add = (ImageButton) findViewById(R.id.ib_num_add);
		size = (RadioGroup) findViewById(R.id.rg_rongliang);
		rg_color = (RadioGroup) findViewById(R.id.rg_color);
		rg_month = (RadioGroup) findViewById(R.id.rg_rent_months);
		way_pay = (RadioGroup) findViewById(R.id.rg_rent_money);
		rb_month = (RadioButton) findViewById(R.id.rb_rent_months);
		rent_before = (RadioButton) findViewById(R.id.rb_rent_before);
		rent_after = (RadioButton) findViewById(R.id.rb_rent_after);
		rent_monthly = (RadioButton) findViewById(R.id.rb_rent_monthly);
		version = (CheckBox) findViewById(R.id.cb_gzb);
		insurence = (CheckBox) findViewById(R.id.cb_ywx);
		lower_price = (TextView) findViewById(R.id.tv_low_price);
		goods_num = (TextView) findViewById(R.id.tv_left_num);
		buy_num = (TextView) findViewById(R.id.tv_rent_num);
		deposit = (TextView) findViewById(R.id.tv_deposit);
		rent_money = (TextView) findViewById(R.id.tv_rent_money);
		submit = (Button) findViewById(R.id.btn_bill_sunmit);
		size.setOnCheckedChangeListener(this);
		rg_color.setOnCheckedChangeListener(this);
		rg_month.setOnCheckedChangeListener(this);
		way_pay.setOnCheckedChangeListener(this);
		minus.setOnClickListener(this);
		add.setOnClickListener(this);
		submit.setOnClickListener(this);
		version.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

			}
		});
		insurence.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

			}
		});

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb_rent_months:

			break;
		case R.id.rb_rent_before:

			break;
		case R.id.rb_rent_after:

			break;
		case R.id.rb_rent_monthly:

			break;

		default:
			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_num_min:

			break;
		case R.id.ib_num_add:

			break;
		case R.id.btn_bill_sunmit:

			break;

		default:
			break;
		}
	}
}
