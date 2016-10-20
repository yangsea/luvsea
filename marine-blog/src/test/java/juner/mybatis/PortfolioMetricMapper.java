//package com.rquest.riskmaster.mapper;
//
//import com.rquest.riskmaster.entity.PortfolioMetric;
//import java.util.Date;
//import org.apache.ibatis.annotations.Param;
//
//public interface PortfolioMetricMapper {
//    int deleteByPrimaryKey(@Param("idPortfolio") String idPortfolio, @Param("dtMarket") Date dtMarket, @Param("cdMetric") String cdMetric);
//
//    int insert(PortfolioMetric record);
//
//    int insertSelective(PortfolioMetric record);
//
//    PortfolioMetric selectByPrimaryKey(@Param("idPortfolio") String idPortfolio, @Param("dtMarket") Date dtMarket, @Param("cdMetric") String cdMetric);
//
//    int updateByPrimaryKeySelective(PortfolioMetric record);
//
//    int updateByPrimaryKey(PortfolioMetric record);
//}