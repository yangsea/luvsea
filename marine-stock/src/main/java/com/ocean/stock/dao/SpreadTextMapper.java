package com.luvsea.stock.dao;

import com.luvsea.stock.entity.SpreadText;

public interface SpreadTextMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpreadText record);

    int insertSelective(SpreadText record);

    SpreadText selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpreadText record);

    int updateByPrimaryKey(SpreadText record);
}