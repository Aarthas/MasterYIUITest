package com.dcits.busi.jk.usercase;

import com.dcits.busi.jk.page.LoginPage;
import com.dcits.busi.mail.page.MailLoginPage;
import com.dcits.yi.ui.usecase.UseCase;

public class LoginTest {


    public LoginPage loginPage;

    @UseCase(name = "登录测试 ", point = "手机号为空", order = 0, tag = "jk", browserType = {"chrome"})
    public void a1() throws Exception {
        loginPage.open();
        loginPage.username.sendKeys("", true);
        loginPage.password.sendKeys("1234567a", true);
        loginPage.loginBtn.click();
        Thread.sleep(2000l);
    }

    @UseCase(name = "登录测试", point = "密码为空", order = 1, tag = "jk", browserType = {"chrome"})
    public void a2() throws Exception {
        loginPage.open();
        loginPage.username.sendKeys("13780082671", true);
        loginPage.password.sendKeys("", true);
        loginPage.loginBtn.click();
        Thread.sleep(2000l);
    }

    @UseCase(name = "登录测试", point = "密码少于8位", order = 2, tag = "jk", browserType = {"chrome"})
    public void a3() throws Exception {
        loginPage.open();
        loginPage.username.sendKeys("13780082671", true);
        loginPage.password.sendKeys("123456a", true);
        loginPage.loginBtn.click();
        Thread.sleep(2000l);
    }

    @UseCase(name = "登录测试", point = "密码大于18位", order = 3, tag = "jk", browserType = {"chrome"})
    public void a4() throws Exception {
        loginPage.open();
        loginPage.username.sendKeys("13780082671", true);
        loginPage.password.sendKeys("123456789101122111a", true);
        loginPage.loginBtn.click();
        Thread.sleep(2000l);
    }

    @UseCase(name = "登录测试", point = "密码错误", order = 4, tag = "jk", browserType = {"chrome"})
    public void a5() throws Exception {
        loginPage.open();
        loginPage.username.sendKeys("137800826711", true);
        loginPage.password.sendKeys("112345678a", true);
        loginPage.loginBtn.click();
        Thread.sleep(2000l);
    }

    @UseCase(name = "登录测试", point = "密码正确", order = 5, tag = "jk", browserType = {"chrome"})
    public void a6() throws Exception {
        loginPage.open();
        loginPage.username.sendKeys("13780082671", true);
        loginPage.password.sendKeys("1234567a", true);
        loginPage.loginBtn.click();
        Thread.sleep(2000l);
    }
}
