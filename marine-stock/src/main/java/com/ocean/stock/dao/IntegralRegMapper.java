package com.luvsea.stock.dao;

import com.luvsea.stock.entity.IntegralReg;

public interface IntegralRegMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IntegralReg record);

    int insertSelective(IntegralReg record);

    IntegralReg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IntegralReg record);

    int updateByPrimaryKey(IntegralReg record);
}