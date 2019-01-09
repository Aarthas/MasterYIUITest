package com.dcits.test.lejia.data;

import com.dcits.yi.ui.data.BaseDataModel;

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
		stuName = "徐汪成";
		credentType = "身份证";
		credentNo = "342921199006052410";
		sex = "男";
		birthday = "1990-06-05";
		contactMsisdn = "17682160982";
		credentAddr = "安徽省合肥市";
		address = "安徽省合肥市";
		remarks = "UI自动化测试";
	}

}
