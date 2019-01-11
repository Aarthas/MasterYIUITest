package com.dcits.busi.baidu.page;

import com.dcits.yi.ui.element.BasePage;
import com.dcits.yi.ui.element.PageElement;

/**
 * 
* @version 1.0.0
* @Description 页面基类
* @author xuwangcheng
* @date 2019年1月11日下午3:29:25
 */
public class BaiduSearchPage extends BasePage {
	
	public PageElement 搜索框;
	public PageElement 搜索按钮;
	
	public void search(String keyword) {		
		搜索框.sendKeys(keyword);
		搜索按钮.click();
		//AssertUtil.checkBetween(5, 5, 2);
	}
}
