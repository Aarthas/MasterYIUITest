package common;

import com.dcits.busi.jk.usercase.*;
import com.dcits.yi.WebTest;
import com.dcits.yi.ui.report.manage.ZTestReportManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

//    @Test()
//    public void LoginTest() throws Exception {
//        //实例化WebTest对象，可传入suite文件或者多个测试用例类
//        WebTest test = new WebTest(LoginTest.class);
//
//        test.start();
//        test.closeWebDriver();
//    }

    @Test()
    public void LoginOutTest() throws Exception {
        //实例化WebTest对象，可传入suite文件或者多个测试用例类
        WebTest test = new WebTest(LoginOutTest.class);

        test.start();
        Thread.sleep(2000);
        test.closeWebDriver();
    }


    @Test()
    public void RegisterTest() throws Exception {
        WebTest test = new WebTest(RegisterTest.class);

        //传入一个或多个测试报告处理器对象

//      test.setReportManagers(new ZTestReportManager());

        //常规启动测试
        test.start();
        test.closeWebDriver();
    }

    @Test()
    public void ResetPwdTest() throws Exception {
        WebTest test = new WebTest(ResetPwdTest.class);

        //传入一个或多个测试报告处理器对象

//      test.setReportManagers(new ZTestReportManager());

        //常规启动测试
        test.start();
        test.closeWebDriver();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }

    //只对group1有效，即test1和test11
    @BeforeGroups(groups = "group1")
    public void beforeGroups() {
        System.out.println("beforeGroups");
    }

    //只对group1有效，即test1和test11
    @AfterGroups(groups = "group1")
    public void afterGroups() {
        System.out.println("afterGroups");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }
}
