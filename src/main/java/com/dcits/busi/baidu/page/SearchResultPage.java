package com.dcits.busi.baidu.page;

import com.dcits.yi.tool.AssertUtil;
import com.dcits.yi.ui.element.BasePage;
import com.dcits.yi.ui.element.PageElement;

/**
 * 
* @version 1.0.0
* @Description 
* @author xuwangcheng
* @date 2019年1月11日下午3:30:00
 */
public class SearchResultPage extends BasePage {
	public PageElement 搜索结果;
	
	public void clickFirst() {
		搜索结果.click();
		AssertUtil.equals(getTitle(), "百度搜索");
	}
}
