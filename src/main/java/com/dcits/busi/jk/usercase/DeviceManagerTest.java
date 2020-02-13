package com.dcits.busi.jk.usercase;

import com.dcits.busi.jk.page.LoginPage;
import com.dcits.yi.ui.usecase.UseCase;

public class DeviceManagerTest {


    public LoginPage loginPage;

    public com.dcits.busi.jk.page.GlobalHead GlobalHead;


    @UseCase(name = "登录测试", point = "密码正确", order = 5, tag = "jk", browserType = {"chrome"})
    public void a6() throws Exception {
        loginPage.open();
        loginPage.username.sendKeys("13780082671", true);
        loginPage.password.sendKeys("1234567a", true);
        loginPage.loginBtn.click();
//        Thread.sleep(2000l);
        GlobalHead.设备管理.click();


    }
}
