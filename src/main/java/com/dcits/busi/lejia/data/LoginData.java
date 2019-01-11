package com.dcits.busi.lejia.data;

import com.dcits.yi.ui.data.BaseDataModel;

/**
 * 
* @version 1.0.0
* @Description 
* @author xuwangcheng
* @date 2019年1月11日下午3:30:19
 */
public class LoginData extends BaseDataModel {
	
	public String username;
	public String password;
	public String nickName;
	

	@Override
	public void initData() {
		username = "";
		password = "";
		nickName = "演示驾校管理员";
		
	}


	@Override
	public void destroyData() {
		System.out.println("LoginData 数据销毁...");		
	}

}
