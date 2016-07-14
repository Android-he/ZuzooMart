package com.zuzoo.zuzoomart.activity;

import com.zuzoo.zuzoomart.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BillSubmitActivity extends Activity implements OnClickListener,OnCheckedChangeListener{
	
	private RadioGroup delivery;
	private RadioButton shunfeng,ziti;
	private RelativeLayout address;
	private TextView goods_price,insurence,mail_cost,cost_all,earnest;
	private EditText message;
	private Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy_submit);
		initView();
	}
	private void initView(){
		delivery = (RadioGroup) findViewById(R.id.rg_delivery);
		shunfeng = (RadioButton) findViewById(R.id.rb_shunfeng);
		ziti = (RadioButton) findViewById(R.id.rb_ziti);
		address = (RelativeLayout) findViewById(R.id.rl_address_details);
		goods_price = (TextView) findViewById(R.id.tv_price);
		insurence = (TextView) findViewById(R.id.tv_cost_ywx);
		mail_cost = (TextView) findViewById(R.id.tv_cost_mail);
		cost_all = (TextView) findViewById(R.id.tv_cost_all);
		earnest = (TextView) findViewById(R.id.tv_earnest);
		message = (EditText) findViewById(R.id.et_leave_message);
		submit = (Button) findViewById(R.id.btn_rent_now);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb_shunfeng:
			
			break;
		case R.id.rb_ziti:
			
			break;

		default:
			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_address_details:
			
			break;
		case R.id.btn_rent_now:
			
			break;

		default:
			break;
		}
	}
}
