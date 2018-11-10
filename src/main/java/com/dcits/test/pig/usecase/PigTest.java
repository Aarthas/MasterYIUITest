package com.dcits.test.pig.usecase;

import com.dcits.test.pig.page.PigLoginPage;
import com.dcits.yi.ui.usecase.UseCase;

public class PigTest {
	public PigLoginPage loginPage;
	
	@UseCase(name="测试")
	public void test() throws Exception {		
		loginPage.testOCR();
	}
}
