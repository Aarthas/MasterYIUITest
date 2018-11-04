package com.dcits.yi.ui.report.manage;

import com.dcits.yi.ui.report.SuiteReport;

/**
 * 测试报告处理器接口
 * @author xuwangcheng
 * @version 20181012
 *
 */
public interface IReportManager {
	/**
	 * 处理测试报告数据
	 * @param reportData 测试报告对象
	 * @return  返回生成的文件路径，如果不生成文件则返回null
	 */
	String manage(SuiteReport reportData) throws Exception;
	/**
	 * 创建测试报告的完整文件路径
	 * @param reportName
	 * @return
	 */
	String createReportPath(String reportName);
}
