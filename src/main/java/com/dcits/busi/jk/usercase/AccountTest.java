package com.dcits.busi.jk.usercase;

import com.dcits.busi.jk.page.*;
import com.dcits.yi.ui.usecase.UseCase;

public class AccountTest {



    public LoginPage loginPage;
    public GlobalHead globalHead;

    public UserMenu userMenu;
    public AccountCenterPage accountCenterPage;
    public AccountEditPage accountEditPage;
    @UseCase(name = "登录测试", point = "密码正确", order = 5, tag = "jk", browserType = {"chrome"})
    public void a6() throws Exception {
        loginPage.open();
        loginPage.username.sendKeys("13780082671", true);
        loginPage.password.sendKeys("1234567a", true);
        loginPage.loginBtn.click();
//        Thread.sleep(4000l);
        globalHead.设备控制.click();
        globalHead.设备管理.click();
        globalHead.sleep(2);
        globalHead.usermenu.mouseHover();

//        globalHead.usermenu.click();

        globalHead.sleep(1);
        System.out.println("asd"+userMenu.设置.isExist());
        String text = userMenu.设置.getText();
        System.out.println("text="+text);
        userMenu.个人中心.click();
        globalHead.sleep(1);
        accountCenterPage.编辑.mouseClick();
        globalHead.sleep(1);
        accountEditPage.name.sendKeys(accountEditPage.name.getText()+"1",true);
        accountEditPage.description.sendKeys("修改后");
        accountEditPage.提交.mouseClick();
    }
}
