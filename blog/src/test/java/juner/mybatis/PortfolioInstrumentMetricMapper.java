//package com.rquest.riskmaster.mapper;
//
//import com.rquest.riskmaster.entity.PortfolioInstrumentMetric;
//import java.util.Date;
//import org.apache.ibatis.annotations.Param;
//
//public interface PortfolioInstrumentMetricMapper {
//    int deleteByPrimaryKey(@Param("idPortfolio") String idPortfolio, @Param("idInstrument") String idInstrument, @Param("dtMarket") Date dtMarket, @Param("cdMetric") String cdMetric);
//
//    int insert(PortfolioInstrumentMetric record);
//
//    int insertSelective(PortfolioInstrumentMetric record);
//
//    PortfolioInstrumentMetric selectByPrimaryKey(@Param("idPortfolio") String idPortfolio, @Param("idInstrument") String idInstrument, @Param("dtMarket") Date dtMarket, @Param("cdMetric") String cdMetric);
//
//    int updateByPrimaryKeySelective(PortfolioInstrumentMetric record);
//
//    int updateByPrimaryKey(PortfolioInstrumentMetric record);
//}