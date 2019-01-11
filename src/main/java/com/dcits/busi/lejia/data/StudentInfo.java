package com.dcits.busi.lejia.data;

import com.dcits.yi.ui.data.BaseDataModel;

/**
 * 
* @version 1.0.0
* @Description 
* @author xuwangcheng
* @date 2019年1月11日下午3:30:27
 */
public class StudentInfo extends BaseDataModel {
	
	public String stuName;
	public String credentType;
	public String credentNo;
	public String sex;
	public String birthday;
	public String contactMsisdn;
	public String credentAddr;
	public String address;
	public String remarks;
	

	@Override
	public void initData() {
		if (!firstInitFlag) {
			destroyData();
		}
		
		stuName = "徐汪成";
		credentType = "身份证";
		credentNo = "34292111111111111";
		sex = "男";
		birthday = "1990-06-05";
		contactMsisdn = "17682160982";
		credentAddr = "安徽省合肥市";
		address = "安徽省合肥市";
		remarks = "UI自动化测试";
	}


	@Override
	public void destroyData() {
		System.out.println("StudentInfo 数据销毁...");
	}

}
