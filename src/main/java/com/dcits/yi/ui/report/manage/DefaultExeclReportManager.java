package com.dcits.yi.ui.report.manage;

import java.util.ArrayList;
import java.util.List;

import com.dcits.yi.ui.GlobalTestConfig;
import com.dcits.yi.ui.report.CaseReport;
import com.dcits.yi.ui.report.SuiteReport;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

/**
 * 默认excel报告处理器
 * @author xuwangcheng
 * @version 20181012
 *
 */
public class DefaultExeclReportManager implements IReportManager {

	@Override
	public String manage(SuiteReport reportData) {
		List<List<String>> rows = new ArrayList<>();
		for (CaseReport r:reportData.getCaseReports()) {
			rows.add(CollUtil.newArrayList(r.getCaseName(), r.getBrowserType(),r.getFinishTime(), r.getStatus(), r.getUseTime(), String.valueOf(r.getRunCount()), r.getMark()));
		}	
		
		String reportPath = createReportPath(reportData.getReportName());
		ExcelWriter writer = ExcelUtil.getWriter(reportPath);	
		writer.writeHeadRow(CollUtil.newArrayList("用例名称", "浏览器","执行时间", "状态", "耗时(ms)", "运行次数", "备注"));
		writer.write(rows);
		writer.close();
		
		return reportPath;
	}

	@Override
	public String createReportPath(String reportName) {
		// TODO Auto-generated method stub
		return GlobalTestConfig.ENV_INFO.getReportFolder() + "/" + reportName + ".xlsx";
	}
}
