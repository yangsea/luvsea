//package com.rquest.riskmaster.dao;
//
//import java.sql.Date;
//import java.util.List;
//
//import com.rquest.riskmaster.dto.PortfolioInstrumentMetric;
//
//
//public interface PortfolioInstrumentMetricDAO {
//	
//
//	public void delPortfolioInstrumentmetric(String portfolioId, String instrumentId, Date marketDate,String metricCode);
//	
//	public void insertPortfolioInstrumentmetric(List<PortfolioInstrumentMetric> metrics);
//
//	public PortfolioInstrumentMetric getPortfolioInstrumentMetric(String portfolioId, String instrumentId, Date marketDate, String metricCode);
//	
//	public void saveInstrumentMetric(PortfolioInstrumentMetric metric);
//	
//	public List<PortfolioInstrumentMetric> getPortfolioInstrumentMetricList(Date marketDate);
//	
//	// get portfolio instrument metric with cd_source != aggregation
//	public List<PortfolioInstrumentMetric> getNoAggregationPortfolioInstrumentMetricList(Date marketDate);
//	
//	public void delPortfolioInstrumentmetrics(
//			List<PortfolioInstrumentMetric> marketDayportfolioInstrumentMetrics);
//}
