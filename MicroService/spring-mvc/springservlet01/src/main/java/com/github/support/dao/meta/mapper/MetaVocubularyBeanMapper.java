package com.github.support.dao.meta.mapper;

import com.github.support.dao.meta.model.MetaVocubularyBean;

public interface MetaVocubularyBeanMapper {
    int deleteByPrimaryKey(String vid);

    int insert(MetaVocubularyBean record);

    int insertSelective(MetaVocubularyBean record);

    MetaVocubularyBean selectByPrimaryKey(String vid);

    int updateByPrimaryKeySelective(MetaVocubularyBean record);

    int updateByPrimaryKey(MetaVocubularyBean record);
}