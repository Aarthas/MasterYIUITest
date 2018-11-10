package com.dcits.test.pig.page;

import com.dcits.yi.ui.element.BasePage;
import com.dcits.yi.ui.element.PageElement;

public class PigLoginPage extends BasePage {
	public PageElement 验证码;
	
	public void testOCR() throws Exception {
		this.open();
		System.out.println(验证码.OCRCode(1530, 515, null));
	}
}
