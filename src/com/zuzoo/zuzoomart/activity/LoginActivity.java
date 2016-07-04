package com.zuzoo.zuzoomart.activity;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.zuzoo.zuzoomart.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener {
	private EditText phone_num, pwd;
	private TextView forget_pwd, register;
	private Button login;
	private ImageButton back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
		
//		 // 测试 SDK 是否正常工作的代码
//        AVObject testObject = new AVObject("TestObject");
//        testObject.put("words","Hello World!");
//        testObject.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(AVException e) {
//                if(e == null){
//                    Log.d("saved","success!");
//                }
//            }
//        });

	}

	private void initView() {
		phone_num = (EditText) findViewById(R.id.et_login_name);
		pwd = (EditText) findViewById(R.id.et_pwd);
		forget_pwd = (TextView) findViewById(R.id.forget_pwd);
		register = (TextView) findViewById(R.id.register);
		login = (Button) findViewById(R.id.btn_login);
		back = (ImageButton) findViewById(R.id.btn_toolbar_back);
		forget_pwd.setOnClickListener(this);
		register.setOnClickListener(this);
		login.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_toolbar_back:
			finish();
			break;
		case R.id.forget_pwd:
			Intent intent = new Intent(LoginActivity.this,ResetPasswordActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_login:
			login();
			break;
		case R.id.register:
			
			break;
		default:
			break;
		}
	}
	private void login(){
		Intent intent = new Intent(LoginActivity.this,IndexActivity.class);
		startActivity(intent);
	}
	private void checkApkVersion(){
		
	}
}
