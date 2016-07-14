package com.zuzoo.zuzoomart.application;

import android.app.Application;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//				.showImageForEmptyUri(R.drawable.ic_launcher)
//				.showImageOnFail(R.drawable.ic_launcher)
				.imageScaleType(ImageScaleType.EXACTLY).cacheInMemory(true)
				.cacheOnDisk(true).build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext())
				.defaultDisplayImageOptions(defaultOptions)
				.memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
				.diskCacheFileCount(100).writeDebugLogs()//
				.build();//
		ImageLoader.getInstance().init(config);
	}

}
