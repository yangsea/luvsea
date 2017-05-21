package com.luvsea.stock.dao;

import com.luvsea.stock.entity.SpreadDetail;

public interface SpreadDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpreadDetail record);

    int insertSelective(SpreadDetail record);

    SpreadDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpreadDetail record);

    int updateByPrimaryKey(SpreadDetail record);
}