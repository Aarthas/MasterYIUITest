package com.dcits.busi.jk.usercase;

import com.dcits.busi.jk.page.ChangePwdPage;
import com.dcits.busi.jk.page.LoginPage;
import com.dcits.busi.jk.page.ResetPwdPage;
import com.dcits.yi.ui.usecase.UseCase;

public class ChangePwd {


    public LoginPage loginPage;
    public ResetPwdPage resetPwdPage;
    public ChangePwdPage changePwdPage;

    @UseCase(name = "登录测试 ", point = "手机号为空", order = 0, tag = "jk", browserType = {"chrome"})
    public void a1() throws Exception {
        loginPage.open();
        loginPage.username.sendKeys("13780082671", true);
        loginPage.password.sendKeys("1234567aaa", true);
        loginPage.loginBtn.click();
        loginPage.sleep(2);
        changePwdPage.修改.click();
        loginPage.sleep(2);
        changePwdPage.oldpassword.sendKeys("1234567aaa", true);
        changePwdPage.password.sendKeys("1234567aa", true);
        changePwdPage.confirmpassword.sendKeys("1234567aa", true);
        changePwdPage.ok.click();
//        loginPage.
    }


}
