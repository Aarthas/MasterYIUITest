package com.dcits.busi.jk.usercase;

import com.dcits.busi.jk.page.*;
import com.dcits.yi.ui.usecase.UseCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginOutTest {


    public LoginPage loginPage;
    public GlobalHead globalHead;

    public UserMenu userMenu;
    public AccountCenterPage accountCenterPage;
    public AccountEditPage accountEditPage;
    public LogoutDialog logoutDialog;

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

        userMenu.退出登录.click();
        globalHead.sleep(3);
        boolean exist = logoutDialog.ok.isExist();
//        logoutDialog.initPageObject();
        By xpath = By.cssSelector("body > div:nth-child(7) > div > div.ant-modal-wrap > div > div.ant-modal-content > div > div > div.ant-modal-confirm-btns > button.ant-btn.ant-btn-primary");
        WebElement element = logoutDialog.getDriver().findElement(xpath);
        System.out.println(element);

    }
}
