package com.zuzoo.zuzoomart.model;

import java.io.Serializable;
import java.sql.Date;

public class Advertising implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String NewsTitle;
	private String CreateUser;
	private String CreateTime;
	private String FilePath;
	private String NewsContent;
	private String NewsDate;
	private String FileName;

	public Advertising(int iD, String newsTitle, String createUser,
			String createTime, String filePath, String newsContent,
			String newsDate, String fileName) {
		super();
		ID = iD;
		NewsTitle = newsTitle;
		CreateUser = createUser;
		CreateTime = createTime;
		FilePath = filePath;
		NewsContent = newsContent;
		NewsDate = newsDate;
		FileName = fileName;
	}

	public Advertising(int iD, String newsTitle, String createUser,
			String createTime, String filePath, String newsContent,
			String newsDate) {
		super();
		ID = iD;
		NewsTitle = newsTitle;
		CreateUser = createUser;
		CreateTime = createTime;
		FilePath = filePath;
		NewsContent = newsContent;
		NewsDate = newsDate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNewsTitle() {
		return NewsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		NewsTitle = newsTitle;
	}

	public String getCreateUser() {
		return CreateUser;
	}

	public void setCreateUser(String createUser) {
		CreateUser = createUser;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getCreatUser() {
		return CreateUser;
	}

	public void setCreatUser(String createUser) {
		CreateUser = createUser;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getFilePath() {
		return FilePath;
	}

	public void setFilePath(String filePath) {
		FilePath = filePath;
	}

	public String getNewsContent() {
		return NewsContent;
	}

	public void setNewsContent(String newsContent) {
		NewsContent = newsContent;
	}

	public String getNewsDate() {
		return NewsDate;
	}

	public void setNewsDate(String newsDate) {
		NewsDate = newsDate;
	}

}
