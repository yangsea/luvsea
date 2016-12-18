package com.ocean.stock.dao;

import com.ocean.stock.entity.NoteTYpe;

public interface NoteTYpeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteTYpe record);

    int insertSelective(NoteTYpe record);

    NoteTYpe selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteTYpe record);

    int updateByPrimaryKey(NoteTYpe record);
}