package com.zuzoo.zuzoomart.activity;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.RequestMobileCodeCallback;
import com.avos.avoscloud.SaveCallback;
import com.zuzoo.zuzoomart.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterNextActivity extends Activity implements OnClickListener {
	private EditText code, pwd;
	private Button get_code, finish;
	private CheckBox pwd_visible;
	private String phone_num;
	private ImageButton back;
	private TextView title;
	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_next);
		initView();
		phone_num = getIntent().getExtras().get("phone").toString();
		 sp = getSharedPreferences("user",MODE_PRIVATE);
		
	}

	private void initView() {
		code = (EditText) findViewById(R.id.et_register_code);
		pwd = (EditText) findViewById(R.id.et_register_passwd);
		get_code = (Button) findViewById(R.id.btn_get_code);
		finish = (Button) findViewById(R.id.btn_register_finish);
		pwd_visible = (CheckBox) findViewById(R.id.cb_see_pwd);
		back = (ImageButton) findViewById(R.id.btn_toolbar_back);
		title = (TextView) findViewById(R.id.tv_toolbar_title);
		title.setText("注册");
		back.setOnClickListener(this);
		get_code.setOnClickListener(this);
		finish.setOnClickListener(this);
		pwd_visible.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (pwd_visible.isChecked()) {
					pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				} else {
					pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_toolbar_back:
			finish();
			break;
		case R.id.btn_get_code:
			 AVOSCloud.requestSMSCodeInBackgroud(phone_num, new RequestMobileCodeCallback() {
				
				@Override
				public void done(AVException arg0) {
					Toast.makeText(getApplicationContext(), "短信已发送，请注意查收", Toast.LENGTH_SHORT).show();
				}
			});
			break;
		case R.id.btn_register_finish:
			 final AVObject todo = new AVObject("_User");
		        todo.put("username", phone_num);// 设置名称
		        todo.put("mobilePhoneNumber", phone_num);// 设置名称
		        todo.put("password", pwd.getText().toString());// 设置名称
		        todo.saveInBackground(new SaveCallback() {
					
					@Override
					public void done(AVException e) {
						 if (e == null) {
			                    // 存储成功
							 Editor editor = sp.edit(); 
							 editor.putString("userId", todo.getObjectId());
							 Toast.makeText(getApplicationContext(), "注册成功~", Toast.LENGTH_SHORT).show();
			                } else {
			                    // 失败的话，请检查网络环境以及 SDK 配置是否正确
			                }
					}
				});
			break;

		default:
			break;
		}
	}
}
