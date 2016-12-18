package com.ocean.stock.dao;

import com.ocean.stock.entity.PricedReg;

public interface PricedRegMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PricedReg record);

    int insertSelective(PricedReg record);

    PricedReg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PricedReg record);

    int updateByPrimaryKey(PricedReg record);
}