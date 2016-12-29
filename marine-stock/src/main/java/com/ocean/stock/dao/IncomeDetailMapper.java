package com.ocean.stock.dao;

import com.ocean.stock.entity.IncomeDetail;

public interface IncomeDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IncomeDetail record);

    int insertSelective(IncomeDetail record);

    IncomeDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IncomeDetail record);

    int updateByPrimaryKey(IncomeDetail record);
}