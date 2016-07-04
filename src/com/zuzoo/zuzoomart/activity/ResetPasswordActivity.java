package com.zuzoo.zuzoomart.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zuzoo.zuzoomart.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ResetPasswordActivity extends Activity implements OnClickListener {
	private EditText phone_reset, get_code, new_pwd, pwd_twice;
	private Button btn_get_code, submit;
	private ImageButton back;
	private String phone, code, pwd1, pwd2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resetpassword);
		initView();
	}

	private void initView() {
		phone_reset = (EditText) findViewById(R.id.et_phone_reset);
		get_code = (EditText) findViewById(R.id.register_code);
		new_pwd = (EditText) findViewById(R.id.et_new_pwd);
		pwd_twice = (EditText) findViewById(R.id.et_twice_pwd);
		btn_get_code = (Button) findViewById(R.id.get_code);
		submit = (Button) findViewById(R.id.btn_register_submit);
		back = (ImageButton) findViewById(R.id.btn_toolbar_back);
		btn_get_code.setOnClickListener(this);
		submit.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_toolbar_back:
			finish();
			break;
		case R.id.get_code:
			getCode();
			break;
		case R.id.btn_register_submit:
			submit();
			break;

		default:
			break;
		}
	}

	private void getCode() {
		if (phone_reset.getText().toString().equals("")) {
			Toast.makeText(getApplicationContext(), "请输入手机号", Toast.LENGTH_SHORT).show();
		}else if(!isMobile(phone_reset.getText().toString())){
			Toast.makeText(getApplicationContext(), "请输入正确手机号", Toast.LENGTH_SHORT).show();
		}else{
			phone = phone_reset.getText().toString();
		}
	}

	private void submit() {
		if (new_pwd.getText().toString().equals("") || pwd_twice.getText().toString().equals("")) {
			Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
		}else{
			pwd1 = new_pwd.getText().toString();
			pwd2 = pwd_twice.getText().toString();
		}
	}
	public static boolean isMobile(String str) {
		Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(14[75])|(178)|(17[678])|(1349)|(170[059])|(18[0-9]))\\d{8}$");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
}
