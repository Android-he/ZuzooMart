package com.zuzoo.zuzoomart.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zuzoo.zuzoomart.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private EditText country, phone_num;
	private Button next;
	private ImageButton back;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initView();
	}

	private void initView() {
		country = (EditText) findViewById(R.id.et_address);
		phone_num = (EditText) findViewById(R.id.et_phone_get_code);
		next = (Button) findViewById(R.id.btn_register_next);
		back = (ImageButton) findViewById(R.id.btn_toolbar_back);
		title = (TextView) findViewById(R.id.tv_toolbar_title);
		title.setText("注册");
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (country.getText().toString().equals("") || country.getText() == null) {
					Toast.makeText(getApplicationContext(), "请输入所在国家及省市", Toast.LENGTH_SHORT).show();
				} else if (phone_num.getText().toString().equals("") || phone_num.getText() == null) {
					Toast.makeText(getApplicationContext(), "请输入所用手机号", Toast.LENGTH_SHORT).show();
				} else {
					if (!isPhoneNum(phone_num.getText().toString())) {
						Toast.makeText(getApplicationContext(), "请输入正确手机号", Toast.LENGTH_SHORT).show();
					}else{
					// T跳转操作
					Intent intent = new Intent(RegisterActivity.this, RegisterNextActivity.class);
					intent.putExtra("phone", phone_num.getText().toString());
					startActivity(intent);
				}
				}
			}
		});

	}

	private boolean isPhoneNum(String str) {
		Pattern pattern = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(14[75])|(178)|(17[678])|(1349)|(170[059])|(18[0-9]))\\d{8}$");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
}
