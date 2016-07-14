package com.zuzoo.zuzoomart.activity;

import com.zuzoo.zuzoomart.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class IndexActivity extends Activity implements OnClickListener{
	
	private LinearLayout home,category,favor,person_center;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activiry_index);
	initView();
}
private void initView(){
	home = (LinearLayout) findViewById(R.id.ll_home_page);
	category = (LinearLayout) findViewById(R.id.ll_category);
	favor = (LinearLayout) findViewById(R.id.ll_favor);
	person_center = (LinearLayout) findViewById(R.id.ll_person_center);
}
@Override
public void onClick(View v) {
	switch (v.getId()) {
	case R.id.ll_home_page:
		
		break;
	case R.id.ll_category:
		
		break;
	case R.id.ll_favor:
		
		break;
	case R.id.ll_person_center:
		
		break;

	default:
		break;
	}
}
}
 