package com.dcits.yi.ui.report;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dcits.yi.ui.EnvSettingInfo;

/**
 * 测试套件报告
 * @author xuwangcheng
 * @version 20181012
 *
 */
public class SuiteReport {
	
	/**
	 * 测试标题
	 */
	private String title;
	/**
	 * 浏览器名称
	 */
	private Set<String> browserName = new HashSet<String>();
	/**
	 * 开始时间
	 */
	private String testTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 用例总数
	 */
	private int totalCount = 0;
	/**
	 * 成功数
	 */
	private int successCount = 0;
	/**
	 * 失败数
	 */
	private int failCount = 0;
	
	/**
	 * 跳过数，在webDriver初始化失败时
	 */
	private int skipCount = 0;
	
	/**
	 * 环境信息
	 */
	private EnvSettingInfo env;
	
	/**
	 * 包含的用例测试报告
	 */
	private List<CaseReport> caseReports = new ArrayList<CaseReport>();
	
	/**
	 * 执行消耗时间,ms
	 */
	private long useTime;
	
	/**
	 * 默认的测试报告名称
	 */
	private String reportName;
	
	/**
	 * 是否测试完成
	 */
	private boolean finished = false;
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public boolean isFinished() {
		return finished;
	}
	
	public void setSkipCount(int skipCount) {
		this.skipCount = skipCount;
	}
	
	public int getSkipCount() {
		return skipCount;
	}
	
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	public String getReportName() {
		return reportName;
	}
	
	public void setUseTime(long useTime) {
		this.useTime = useTime;
	}
	
	public long getUseTime() {
		return useTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBrowserName(Set<String> browserName) {
		this.browserName = browserName;
	}
	
	public Set<String> getBrowserName() {
		return browserName;
	}
	
	public String getTestTime() {
		return testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public void addTotalCount(int count) {
		this.totalCount += count;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public EnvSettingInfo getEnv() {
		return env;
	}

	public void setEnv(EnvSettingInfo env) {
		this.env = env;
	}

	public List<CaseReport> getCaseReports() {
		return caseReports;
	}

	public void setCaseReports(List<CaseReport> caseReports) {
		this.caseReports = caseReports;
	}

	@Override
	public String toString() {
		return "SuiteReport [title=" + title + ", browserName=" + browserName + ", testTime=" + testTime + ", endTime="
				+ endTime + ", totalCount=" + totalCount + ", successCount=" + successCount + ", failCount=" + failCount
				+ ", env=" + env + ", caseReports=" + caseReports + "]";
	}
}
