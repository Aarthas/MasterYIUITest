package com.dcits.busi.lejia.page;

import com.dcits.yi.tool.AssertUtil;
import com.dcits.yi.ui.element.BasePage;
import com.dcits.yi.ui.element.PageElement;

/**
 * 
* @version 1.0.0
* @Description 
* @author xuwangcheng
* @date 2019年1月11日下午3:30:43
 */
public class MainPage extends BasePage {
	
	/**
	 * 验证是否登录成功
	 */
	public PageElement loginNameText;
	
	/**
	 * 菜单相关
	 */
	public PageElement currentMenuNodelLvOne;
	public PageElement menuNodeLvOne;
	public PageElement menuNodeLvTwo;
	
	/**
	 * 模块的公共元素
	 */
	public PageElement search_keywords;
	public PageElement search_button;
	public PageElement search_reset_button;
	public PageElement table_no_data_tip;
	public PageElement table_op_bar;
	
	
	/**
	 * layer弹出层相关
	 */
	public PageElement layui_confirm_dialog_inner;
	public PageElement layui_confirm_dialog_outer;
	
	/**
	 * 报名受理
	 */
	public PageElement addNewButton;
	public PageElement exportButton;
	
	
	
	/**
	 * 验证是否登录成功
	 * @param nickName 登录用户的名称
	 */
	public void verifyLogin(String nickName) {
		String loginName = loginNameText.getText();
		AssertUtil.equals(loginName, nickName, "实际结果为{}， 与预期结果{}不一致，验证失败!", loginName, nickName);
	}	
	
	/**
	 * 切换菜单
	 * @param menuName1  一级菜单名
	 * @param menuName2  二级菜单名
	 */
	public void switchMenu(String menuName1, String menuName2) {
		String currentMenuName = currentMenuNodelLvOne.getText();
		Mark("当前一级菜单名称为[{}]", currentMenuName);
		if (!menuName1.equals(currentMenuName)) {
			menuNodeLvOne.setParams(menuName1);
			menuNodeLvOne.click();
		}
		menuNodeLvTwo.setParams(menuName2);
		menuNodeLvTwo.click();
		sleep(2);
		screenshot();
	}
	
	/**
	 * 通用的搜索-根据关键字
	 * @param keywords
	 * @return
	 */
	public boolean module_search(String keywords) {
		search_keywords.sendKeys(keywords);
		search_button.click();
		sleep(1);
		screenshot();
		//判断搜索有没有结果		
		return !table_no_data_tip.isExist();
	}
	
	public void module_reset_search() {
		search_reset_button.click();		
	}
	
	/**
	 * 通用的删除会弹出确认框
	 * @param index
	 */
	public void module_del(int index) {
		table_op_bar.setParams(index, "删除");
		table_op_bar.click();
		layui_confirm_dialog_outer.setParams("确定");
		screenshot();
		if (layui_confirm_dialog_outer.isExist()) {
			layui_confirm_dialog_outer.click();
		}		
	}
}
