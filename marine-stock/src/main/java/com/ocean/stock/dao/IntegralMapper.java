package com.luvsea.stock.dao;

import com.luvsea.stock.entity.Integral;

public interface IntegralMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Integral record);

    int insertSelective(Integral record);

    Integral selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Integral record);

    int updateByPrimaryKey(Integral record);
}