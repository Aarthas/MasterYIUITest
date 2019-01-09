package com.dcits.test.lejia.data;

import com.dcits.yi.ui.data.BaseDataModel;

public class LoginData  extends BaseDataModel {
	
	public String username;
	public String password;
	public String nickName;
	

	@Override
	public void initData() {
		username = "";
		password = "";
		nickName = "演示驾校管理员";
		
	}

}
