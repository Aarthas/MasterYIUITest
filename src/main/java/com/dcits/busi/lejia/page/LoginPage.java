package com.dcits.busi.lejia.page;

import com.dcits.yi.ui.element.BasePage;
import com.dcits.yi.ui.element.PageElement;

/**
 * 
* @version 1.0.0
* @Description 
* @author xuwangcheng
* @date 2019年1月11日下午3:30:35
 */
public class LoginPage extends BasePage {
	
	public PageElement 用户名输入框;
	public PageElement 密码输入框;
	public PageElement 登录按钮;
	
	public void login(String username, String password) {
		用户名输入框.sendKeys(username, true);
		密码输入框.sendKeys(password, true);
		登录按钮.click();
		sleep(2);
		screenshot();
	}
}
