//package com.rquest.riskmaster.dao;
//
//import java.sql.Date;
//import java.util.List;
//
//import com.rquest.riskmaster.dto.PortfolioMetric;
//
//public interface PortfolioMetricDAO {
//	
//	// Insert VaR result
//	public void insertVaR(String portfolioID, Date marketDate, String metricCode, int gap, double vaR, String sourceCode);
//	
//	//delete VaR result
//	public void delVaR(String portfolioID,Date marketDate,String metricCode);
//	
//	//getPortfolioMetricList
//	public List<PortfolioMetric> getPortfolioMetricList(Date marketDate);
//	
//	//getPortfolioMetricList with cd_source != aggregation
//	public List<PortfolioMetric> getNoAggregationPortfolioMetricList(Date marketDate);
//	
//	//getPortfolioMetric
//	public PortfolioMetric getPortfolioMetric(String portfolioID,Date marketDate,String metricCode);
//	
//	//batchInsert PortfolieMetric
//	public void batchInsert(List<PortfolioMetric> metrics);
//
//	public void delPortfolioMetrics(
//			List<PortfolioMetric> marketDayportfolioMetrics);
//	
//}
