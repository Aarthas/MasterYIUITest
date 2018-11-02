package com.dcits.test.baidu.usecase;

import com.dcits.test.baidu.page.BaiduSearchPage;
import com.dcits.test.baidu.page.SearchResultPage;
import com.dcits.yi.ui.usecase.UseCase;

public class Baidu {
	
	public BaiduSearchPage 搜索页面;
	public SearchResultPage 搜索结果页面;
	
	@UseCase(name="百度搜索", tag="baidu", browserType = {"ie", "firefox", "chrome"})
	public void search() throws Exception {
		搜索页面.open();
		搜索页面.search("xuwangcheng.com");
		搜索结果页面.搜索结果.setParams(1);
		搜索结果页面.clickFirst();	
		搜索页面.switchWindow(1);
		搜索页面.switchWindow(0);
		搜索页面.refresh();
	}
}
