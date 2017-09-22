package com.github.support.dao.meta.mapper;

import com.github.support.dao.meta.model.MetaVocubularyListnerBean;
import com.github.support.dao.meta.model.MetaVocubularyListnerBeanKey;

public interface MetaVocubularyListnerBeanMapper {
    int deleteByPrimaryKey(MetaVocubularyListnerBeanKey key);

    int insert(MetaVocubularyListnerBean record);

    int insertSelective(MetaVocubularyListnerBean record);

    MetaVocubularyListnerBean selectByPrimaryKey(MetaVocubularyListnerBeanKey key);

    int updateByPrimaryKeySelective(MetaVocubularyListnerBean record);

    int updateByPrimaryKey(MetaVocubularyListnerBean record);
}