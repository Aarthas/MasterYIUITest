package com.dcits.busi.jk.usercase;

import com.dcits.busi.jk.page.LoginPage;
import com.dcits.busi.jk.page.RegisterPage;
import com.dcits.yi.ui.usecase.UseCase;

public class RegisterTest {


    public LoginPage loginPage;
    public RegisterPage registerPage;

    @UseCase(name = "登录测试 ", point = "手机号为空", order = 0, tag = "jk", browserType = {"chrome"})
    public void a1() throws Exception {
        loginPage.open();
        loginPage.register_btn.click();
        registerPage.mobile.sendKeys("13780082671");
        registerPage.password.sendKeys("1234567a");
        registerPage.password2.sendKeys("1234567a");
    }


}
