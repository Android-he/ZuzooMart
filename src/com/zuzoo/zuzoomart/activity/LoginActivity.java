package com.zuzoo.zuzoomart.activity;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SaveCallback;
import com.zuzoo.zuzoomart.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {
	private EditText phone_num, pwd;
	private TextView forget_pwd, register;
	private Button login;
	private ImageButton back;
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
	}

	private void initView() {
		phone_num = (EditText) findViewById(R.id.et_login_name);
		pwd = (EditText) findViewById(R.id.et_pwd);
		forget_pwd = (TextView) findViewById(R.id.forget_pwd);
		register = (TextView) findViewById(R.id.register);
		login = (Button) findViewById(R.id.btn_login);
		back = (ImageButton) findViewById(R.id.btn_toolbar_back);
		back.setVisibility(View.GONE);
		title = (TextView) findViewById(R.id.tv_toolbar_title);
		title.setText("登录");
		forget_pwd.setOnClickListener(this);
		register.setOnClickListener(this);
		login.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// case R.id.btn_toolbar_back:
		// finish();
		// break;
		case R.id.forget_pwd:
			Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_login:
			login();
			break;
		case R.id.register:
			Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
			startActivity(i);
			break;
		default:
			break;
		}
	}

	private void login() {
		if (phone_num.getText().toString().equals("") || phone_num.getText() == null
				|| pwd.getText().toString().equals("") || pwd.getText() == null) {
			Toast.makeText(getApplicationContext(), "请输入手机号或密码后再登录", Toast.LENGTH_SHORT).show();
		} else {
			AVUser.loginByMobilePhoneNumberInBackground(phone_num.getText().toString(), pwd.getText().toString(),
					new LogInCallback<AVUser>() {
						@Override
						public void done(AVUser avUser, AVException e) {
							Intent intent = new Intent(LoginActivity.this, IndexActivity.class);
							startActivity(intent);
						}
					});
		}
	}

	public static int getVerCode(Context context) {//版本号
		int verCode = -1;
		try {
			verCode = context.getPackageManager().getPackageInfo("com.zuzoo.zuzoomart", 0).versionCode;
		} catch (NameNotFoundException e) {
			Log.e("msg", e.getMessage());
		}
		return verCode;
	}

	public static String getVerName(Context context) {//版本名称
		String verName = "";
		try {
			verName = context.getPackageManager().getPackageInfo("com.zuzoo.zuzoomart", 0).versionName;
		} catch (NameNotFoundException e) {
			Log.e("msg", e.getMessage());
		}
		return verName;
	}
}
