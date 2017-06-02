//package com.rquest.riskmaster.mapper;
//
//import com.rquest.riskmaster.entity.PortfolioInstrumentSnapshot;
//import java.util.Date;
//import org.apache.ibatis.annotations.Param;
//
//public interface PortfolioInstrumentSnapshotMapper {
//    int deleteByPrimaryKey(@Param("dtMarket") Date dtMarket, @Param("idPortfolio") String idPortfolio, @Param("idInstrument") String idInstrument);
//
//    int insert(PortfolioInstrumentSnapshot record);
//
//    int insertSelective(PortfolioInstrumentSnapshot record);
//
//    PortfolioInstrumentSnapshot selectByPrimaryKey(@Param("dtMarket") Date dtMarket, @Param("idPortfolio") String idPortfolio, @Param("idInstrument") String idInstrument);
//
//    int updateByPrimaryKeySelective(PortfolioInstrumentSnapshot record);
//
//    int updateByPrimaryKey(PortfolioInstrumentSnapshot record);
//}