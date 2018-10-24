package com.dcits.yi;

import com.dcits.yi.ui.EnvSettingInfo;
import com.dcits.yi.ui.GlobalTestConfig;

/**
 * 执行入口：以jar包方式运行测试
 * @author xuwangcheng
 * @version 20181012
 *
 */
public class StartTest {
	public static void main(String[] args) throws Exception {
		EnvSettingInfo.DEV_MODE = false;
		
		if (args.length >= 1) {
			WebTest test = new WebTest(args[0]);		
			test.start();
		} else {
			WebTest test = new WebTest(GlobalTestConfig.ENV_INFO.getCronSuite());
			test.startCron();
		}
	}
}
