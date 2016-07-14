package com.zuzoo.zuzoomart.fragments;

import java.util.zip.Inflater;

import com.zuzoo.zuzoomart.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class HomeFragment extends Fragment{
	@SuppressLint({ "HandlerLeak", "InflateParams" })
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_home,null, false);
//		setView(inflater);
//		initView(v);
		return v;
}
}
