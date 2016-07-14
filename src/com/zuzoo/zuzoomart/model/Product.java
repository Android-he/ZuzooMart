package com.zuzoo.zuzoomart.model;

public class Product {
	
	private String name;
	private String time;
	private String describe;
	private String price;
	private String url;
	private String surplus;//剩余
	private String selled;//已售
	
	public Product(String name, String time, String describe, String price,
			String url, String surplus) {
		super();
		this.name = name;
		this.time = time;
		this.describe = describe;
		this.price = price;
		this.url = url;
		this.surplus = surplus;
	}
	
	public Product(String name, String time, String describe, String price,
			String url, String surplus, String selled) {
		super();
		this.name = name;
		this.time = time;
		this.describe = describe;
		this.price = price;
		this.url = url;
		this.surplus = surplus;
		this.selled = selled;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSurplus() {
		return surplus;
	}
	public void setSurplus(String surplus) {
		this.surplus = surplus;
	}

	public String getSelled() {
		return selled;
	}

	public void setSelled(String selled) {
		this.selled = selled;
	}
	
	
}
