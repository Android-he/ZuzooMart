package com.zuzoo.zuzoomart.model;

public class Image {
private String _type;
private String id;
private String name;
private String url;
public Image() {
	super();
}
public Image(String _type, String id, String name, String url) {
	super();
	this._type = _type;
	this.id = id;
	this.name = name;
	this.url = url;
}
public String get_type() {
	return _type;
}
public void set_type(String _type) {
	this._type = _type;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

}
