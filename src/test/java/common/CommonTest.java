package common;

import com.dcits.yi.WebTest;
import com.dcits.yi.ui.report.manage.ZTestReportManager;

public class CommonTest {
	
	public static void main(String[] args) throws Exception {
		//WebTest test = new WebTest("testsuite");
		WebTest test = new WebTest("testsuite");
		
		test.setReportManagers(new ZTestReportManager());		
		test.start();
		//使用seleniumConfig.properties中配置的定时规则
		//test.startCron();
		//传入指定的定时规则
		//test.startCron("*/3 * * * *");	
		//System.out.println(JSONUtil.parse(GlobalTestConfig.report).toStringPretty());;
	}
}
