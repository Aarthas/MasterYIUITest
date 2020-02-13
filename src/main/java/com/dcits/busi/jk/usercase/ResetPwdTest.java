package com.dcits.busi.jk.usercase;

import com.dcits.busi.jk.page.LoginPage;
import com.dcits.busi.jk.page.RegisterPage;
import com.dcits.busi.jk.page.ResetPwdPage;
import com.dcits.yi.ui.usecase.UseCase;

public class ResetPwdTest {


    public LoginPage loginPage;
    public ResetPwdPage resetPwdPage;

    @UseCase(name = "登录测试 ", point = "手机号为空", order = 0, tag = "jk", browserType = {"chrome"})
    public void a1() throws Exception {
        loginPage.open();
        loginPage.resetpwd_btn.click();
        resetPwdPage.mobile.sendKeys("13780082671");
        resetPwdPage.password.sendKeys("1234567a");
        resetPwdPage.password2.sendKeys("1234567a");
    }


}
