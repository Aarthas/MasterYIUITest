package com.dcits.busi.baidu.usecase;

import com.dcits.busi.baidu.page.BaiduSearchPage;
import com.dcits.busi.baidu.page.SearchResultPage;
import com.dcits.yi.ui.usecase.UseCase;

/**
 * 
* @version 1.0.0
* @Description 
* @author xuwangcheng
* @date 2019年1月11日下午3:30:10
 */
public class Baidu {
	
	public BaiduSearchPage 搜索页面;
	public SearchResultPage 搜索结果页面;
	
	@UseCase(name="百度搜索", tag="baidu", browserType = {"chrome"})
	public void search() throws Exception {
		搜索页面.open();
		搜索页面.search("xuwangcheng.com");
		搜索结果页面.搜索结果.setParams(2);
		搜索结果页面.搜索结果.click();
		String title = 搜索结果页面.getTitle();
		System.out.println(title);
		搜索页面.switchWindow(1);
		搜索页面.switchWindow(0);
		搜索页面.refresh();
		System.out.println("asd");
	}

	@UseCase(name="百度搜索2", tag="baidu", browserType = {"chrome"})
	public void search2() throws Exception {
		搜索页面.open();
		搜索页面.search("沈逸斌");
		搜索结果页面.搜索结果.setParams(3);
		搜索结果页面.搜索结果.click();
		String title = 搜索结果页面.getTitle();
		System.out.println(title);
		搜索页面.switchWindow(1);
		搜索页面.switchWindow(0);
		搜索页面.refresh();
		System.out.println("asd");
	}
}
