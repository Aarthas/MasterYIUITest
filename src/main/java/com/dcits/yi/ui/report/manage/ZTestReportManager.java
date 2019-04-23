package com.dcits.yi.ui.report.manage;

import com.dcits.yi.tool.TestKit;
import com.dcits.yi.ui.GlobalTestConfig;
import com.dcits.yi.ui.report.CaseReport;
import com.dcits.yi.ui.report.StepReport;
import com.dcits.yi.ui.report.SuiteReport;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

/**
 * ztest测试报告实现，样式参考<a href="https://github.com/zhangfei19841004/ztest">zhangfei-ztest</a>
 * @author xuwangcheng
 * @version 2018.10.22
 *
 */
public class ZTestReportManager implements IReportManager {
	
	/**
	 * 此处的name和age无任何作用，只是为了演示用
	 */
	private String name;
	private int age;

	public ZTestReportManager() {
		super();
	}

	/**
	 * 该构造函数实际无用，只是为了演示
	 * @param name
	 * @param age
	 */
	public ZTestReportManager(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String manage(SuiteReport reportData) {
		
		JSONObject report = new JSONObject();
		report.put("testPass", reportData.getSuccessCount());
		report.put("testName", reportData.getTitle());
		report.put("testAll", reportData.getTotalCount());
		report.put("testFail", reportData.getFailCount());
		report.put("beginTime", reportData.getTestTime());
		report.put("totalTime", reportData.getUseTime() + "ms");
		report.put("testSkip", reportData.getSkipCount());
		
		JSONArray results = new JSONArray();
		report.put("testResult", results);
		
		for (CaseReport caseReport:reportData.getCaseReports()) {
			JSONObject result = new JSONObject();
			String classMethod = caseReport.getCaseMethodPath();
			result.put("className", classMethod.substring(0, classMethod.lastIndexOf(".")));
			result.put("methodName", classMethod.substring(classMethod.lastIndexOf(".") + 1));
			result.put("browserType", caseReport.getBrowserType());
			result.put("description", caseReport.getCaseName());
			result.put("spendTime", caseReport.getUseTime() + "ms");
			result.put("status", "success".equals(caseReport.getStatus()) ? "成功" : "失败");
			
			JSONArray log = new JSONArray();
			for (StepReport step:caseReport.getStepReports()) {
				log.add("<strong>" + step.getStepName() + "</strong>");
				if (StrUtil.isNotEmpty(step.getLocation())) {
					log.add("元素:&nbsp;" + step.getLocation());
				}
				if (StrUtil.isNotEmpty(step.getParams())) {
					log.add("参数:&nbsp;" + step.getParams());
				}
				if (StrUtil.isNotEmpty(step.getResult())) {
					log.add("结果:&nbsp;" + step.getResult());
				}
				if (StrUtil.isNotEmpty(step.getMark())) {
					log.add("<span style=\"color:red;\">" + step.getMark() + "</span><br>"); 
				}
			}
			result.put("log", log);
			results.add(result);
		}
		
		String json = report.toString();
		String reportHtml = FileUtil.readString(TestKit.getProjectRootPath() + "/template/ztestTemplate", "utf-8");
		
		reportHtml = reportHtml.replace("${resultData}", json);
		String reportPath = createReportPath(reportData.getReportName());
		FileUtil.writeString(reportHtml, reportPath, "utf-8");
		
		return reportPath;
	}

	@Override
	public String createReportPath(String reportName) {		
		return GlobalTestConfig.ENV_INFO.getReportFolder() + "/" + reportName + "_ztest" + ".html";
	}

}
