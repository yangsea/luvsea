package com.luvsea.stock.dao;

import com.luvsea.stock.entity.NoteTYpe;

public interface NoteTYpeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteTYpe record);

    int insertSelective(NoteTYpe record);

    NoteTYpe selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteTYpe record);

    int updateByPrimaryKey(NoteTYpe record);
}