package com.zuzoo.zuzoomart.activity;

import com.zuzoo.zuzoomart.R;
import com.zuzoo.zuzoomart.fragments.CategoryFragment;
import com.zuzoo.zuzoomart.fragments.HomeFragment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class IndexActivity extends Activity implements OnCheckedChangeListener {

	private RadioGroup rg_main;
	private RadioButton home,category,favor,person;
	private CategoryFragment categoryFragment;
	private HomeFragment homeFragment;
	private FragmentManager fm;
	private RelativeLayout rl_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activiry_index);
		initFragment();
		initView();
	}

	private void initView() {
		rg_main = (RadioGroup) findViewById(R.id.rg_activity_main);
		home = (RadioButton) findViewById(R.id.rb_home);
		category = (RadioButton) findViewById(R.id.rb_category);
		favor = (RadioButton) findViewById(R.id.rb_favor);
		person = (RadioButton) findViewById(R.id.rb_person_center);
		rl_title = (RelativeLayout) findViewById(R.id.rl_title);
		rg_main.setOnCheckedChangeListener(this);
		home.setChecked(true);
	}

	private void initFragment() {
		fm = getFragmentManager();
		categoryFragment = new CategoryFragment();
		homeFragment = new HomeFragment();
		fm.beginTransaction().add(R.id.fl_activity_main, homeFragment).add(R.id.fl_activity_main, categoryFragment)
				.commit();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rb_home:
			rl_title.setVisibility(View.VISIBLE);
			fm.beginTransaction().show(homeFragment).hide(categoryFragment).commit();
			home.setTextColor(getResources().getColor(R.color.color_bg_title));
			category.setTextColor(getResources().getColor(R.color.gray_middle));
			favor.setTextColor(getResources().getColor(R.color.gray_middle));
			person.setTextColor(getResources().getColor(R.color.gray_middle));
			break;
		case R.id.rb_category:
			rl_title.setVisibility(View.GONE);
			fm.beginTransaction().show(categoryFragment).hide(homeFragment).commit();
			category.setTextColor(getResources().getColor(R.color.color_bg_title));
			home.setTextColor(getResources().getColor(R.color.gray_middle));
			favor.setTextColor(getResources().getColor(R.color.gray_middle));
			person.setTextColor(getResources().getColor(R.color.gray_middle));
			break;
		case R.id.rb_favor:
			rl_title.setVisibility(View.GONE);
//			fm.beginTransaction().show(homeFragment).hide(categoryFragment).commit();
//			favor.setTextColor(getResources().getColor(R.color.color_bg_title));
//			category.setTextColor(getResources().getColor(R.color.gray_middle));
//			home.setTextColor(getResources().getColor(R.color.gray_middle));
//			person.setTextColor(getResources().getColor(R.color.gray_middle));
//			break;
		case R.id.rb_person_center:
			rl_title.setVisibility(View.GONE);
//			fm.beginTransaction().show(homeFragment).hide(categoryFragment).commit();
//			person.setTextColor(getResources().getColor(R.color.color_bg_title));
//			category.setTextColor(getResources().getColor(R.color.gray_middle));
//			favor.setTextColor(getResources().getColor(R.color.gray_middle));
//			home.setTextColor(getResources().getColor(R.color.gray_middle));
			break;

		default:
			break;
		}
	}

	
}
