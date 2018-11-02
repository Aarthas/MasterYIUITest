package com.dcits.yi.ui.report.manage;

import java.io.File;
import java.util.Map;

import com.dcits.yi.tool.TestKit;
import com.dcits.yi.ui.GlobalTestConfig;
import com.dcits.yi.ui.report.SuiteReport;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.extra.template.Engine;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateConfig.ResourceMode;
import cn.hutool.extra.template.TemplateUtil;

/**
 * 
 * 报告处理器：邮件通知<br>
 * 邮件正文参考项目根目录下template/mailReportTemplate.ftl模板
 * @author xuwangcheng
 * @version 2018.10.24
 *
 */
public class MailNotifyReportManager implements IReportManager {

	@Override
	public void create(SuiteReport reportData) {
		//检查有没有生成测试报告文件，默认采用的ztest报告,如果没有则会先生成
		String ztestHtml = GlobalTestConfig.ENV_INFO.getReportFolder() + "/" + reportData.getReportName() + "_ztest" + ".html";
		if (!FileUtil.exist(ztestHtml)) {
			new ZTestReportManager().create(reportData);
		}
		
		Engine engine = TemplateUtil.createEngine(new TemplateConfig(TestKit.getProjectRootPath() + "/template", ResourceMode.FILE));
		Template template = engine.getTemplate("mailReportTemplate.ftl");
		Map<String, Object> data = MapUtil.newHashMap();
		
		data.put("endTime", reportData.getEndTime());
		data.put("title", reportData.getTitle());
		data.put("browserName", reportData.getBrowserName());
		data.put("totalCount", reportData.getTotalCount());
		data.put("successCount", reportData.getSuccessCount());
		data.put("failCount", reportData.getFailCount());
		data.put("skipCount", reportData.getSkipCount());
		data.put("testTime", reportData.getTestTime());
		data.put("useTime", reportData.getUseTime());
		
		String content = template.render(data);
		MailUtil.send(GlobalTestConfig.ENV_INFO.getMailAccount(), GlobalTestConfig.ENV_INFO.getTos(), GlobalTestConfig.ENV_INFO.getCcs(), GlobalTestConfig.ENV_INFO.getBccs()
				, "易大师UI自动化测试报告", content, true, new File(ztestHtml));
	}
}
