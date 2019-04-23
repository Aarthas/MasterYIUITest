package com.dcits.yi.ui.report.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.dcits.yi.ui.GlobalTestConfig;
import com.dcits.yi.ui.report.SuiteReport;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * 持久化报告数据到sqlite数据库中
 * @author xuwangcheng
 * @version 2018.11.4
 *
 */
public class ReportPersistenceReportManager implements IReportManager {
	private static final Log logger = LogFactory.get();
	
	private String tableName = "report";
	private PreparedStatement ps;
	private Connection conn;
	private ResultSet rs;
	
	public ReportPersistenceReportManager() {
		super();
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			logger.error(e, "没有发现sqlite数据库驱动!");			
		}
	}

	@Override
	public String manage(SuiteReport reportData) throws Exception {	
		try {
			getConnection();
			createTable();
			String sql = "insert into " + tableName + " values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, reportData.getTitle());
			ps.setString(2, CollUtil.join(reportData.getBrowserName(), ","));
			ps.setString(3, reportData.getTestTime());
			ps.setString(4, reportData.getEndTime());
			ps.setInt(5, reportData.getTotalCount());
			ps.setInt(6, reportData.getSuccessCount());
			ps.setInt(7, reportData.getFailCount());
			ps.setInt(8, reportData.getSkipCount());
			ps.setString(9, reportData.isFinished() ? "已完成" : "未完成");
			ps.setString(10, String.valueOf(reportData.getUseTime()));
			ps.setString(11, reportData.getReportName());
			ps.setString(12, JSONUtil.parse(reportData).toString());
			
			ps.execute();
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
		
		return null;
	}
	
	/**
	 * 获取指定数据
	 * @param id
	 * @return
	 */
	public SuiteReport get(int id) {
		SuiteReport report = null;
		try {
			getConnection();
			ps = conn.prepareStatement("select details from " + tableName + " where id=?" );
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String details = rs.getString(1);
				//report = JSONUtil.toBean(JSONUtil.parseObj(details), SuiteReport.class, true);
				report = JSON.parseObject(details, SuiteReport.class);
			}						
		} catch (Exception e) {
			logger.error(e, "查询数据报告表{}出错!", tableName);	
		} finally {
			close();
		}
		
		
		return report;
	}
	
	/**
	 * 获取数据列表
	 * @return
	 */
	public List<Map<String, Object>> list() {	
		List<Map<String, Object>> reports = null;		
		try {
			getConnection();
			ps = conn.prepareStatement("select id,title,browserName,testTime,endTime,totalCount,successCount,failCount,skipCount,useTime from " + tableName + ";");
			rs = ps.executeQuery();
			//得到结果集(rs)的结构信息，比如字段数、字段名等
			ResultSetMetaData md = rs.getMetaData();    
			//返回此 ResultSet 对象中的列数 
	        int columnCount = md.getColumnCount(); 
	           
			reports = new ArrayList<Map<String, Object>>();
			Map<String, Object> rowData = null;
			while (rs.next()) {
				rowData = new HashMap<String, Object>(columnCount);
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				reports.add(rowData);
			}
		} catch (Exception e) {
			logger.error(e, "查询数据报告表{}出错!", tableName);			
		} finally {
			close();
		}		
		return reports;		
	}
	
	private void close () {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void getConnection() throws ClassNotFoundException, SQLException {		
		conn = DriverManager.getConnection("jdbc:sqlite:" + GlobalTestConfig.ENV_INFO.getSqlitePath(), null, null);
	}
	
	private void createTable() throws SQLException {		
		String createSql = "create table if not exists " + tableName + "(id integer primary key autoincrement,title text, browserName text, testTime text, endTime text, "
				+ "totalCount integer, successCount integer, failCount integer, skipCount integer, finished text, useTime text, reportName text, details text)";
		ps = conn.prepareStatement(createSql);
		ps.execute();
	}

	@Override
	public String createReportPath(String reportName) {
		return null;
	}

}
