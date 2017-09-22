package com.github.support.dao.meta.mapper;

import com.github.support.dao.meta.model.EntMetaAttriBean;
import com.github.support.dao.meta.model.EntMetaAttriBeanKey;

public interface EntMetaAttriBeanMapper {
    int deleteByPrimaryKey(EntMetaAttriBeanKey key);

    int insert(EntMetaAttriBean record);

    int insertSelective(EntMetaAttriBean record);

    EntMetaAttriBean selectByPrimaryKey(EntMetaAttriBeanKey key);

    int updateByPrimaryKeySelective(EntMetaAttriBean record);

    int updateByPrimaryKey(EntMetaAttriBean record);
}