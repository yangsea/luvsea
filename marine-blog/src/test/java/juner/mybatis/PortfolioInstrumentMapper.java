//package com.rquest.riskmaster.mapper;
//
//import java.sql.Date;
//import java.util.List;
//
//import com.rquest.riskmaster.entity.PortfolioInstrument;
//
//import org.apache.ibatis.annotations.Param;
//
//public interface PortfolioInstrumentMapper {
//    //del by instrumentId(match 1) 
//    //origial method => deleteByPrimaryKey
//    int delPortfolioInstrument(@Param("idInstrument") String idInstrument, @Param("idPortfolio") String idPortfolio,
//            @Param("marketDate") Date marketDate);
//
//    //insert all filed
//    int insert(@Param("record") PortfolioInstrument record);
//    //match 3
//    //origial method => insertSelective
//    int insertDeltas(@Param("record") PortfolioInstrument record); 
//    // match 2
//    //origial method => selectByPrimaryKey
//    PortfolioInstrument getInstrument(@Param("idInstrument") String idInstrument, @Param("idPortfolio") String idPortfolio,
//            @Param("marketDate") Date marketDate);
//
//    int updateByPrimaryKeySelective(@Param("record") PortfolioInstrument record);
//
//    int updateByPrimaryKey(@Param("record") PortfolioInstrument record);
//    
//    //fetch instruments by portfolioId and marketDate // match 4 新加的
//    public List<PortfolioInstrument> getInstruments(@Param("portfolioID") String portfolioID,
//            @Param("marketDate") Date marketDate);
//    
//    //fetch all// match 5 新加的
//    public List<PortfolioInstrument> getAllInstruments(); 
//    
//    //  ********* 原jdbc***********没有看到update method
//    //这个方法通过唯一键ID获取的为什么用List表示？
//    public List<PortfolioInstrument> getInstruments(String portfolioID);//4
//    
//    public List<PortfolioInstrument> getAllInstruments();//5
//    
//    public int delPortfolioInstrument(String portfolioID, String instrumentID,Date marketDate);//1
//    
//    public void insertDeltas(List<PortfolioInstrument> portfolioInstrumentList);//3  //这里参数是list形式，可能需要在service里面进行遍历调用处理
//    
//    public PortfolioInstrument getInstrument(String portfolioId,String instrumentId,Date marketDate);//2
//}