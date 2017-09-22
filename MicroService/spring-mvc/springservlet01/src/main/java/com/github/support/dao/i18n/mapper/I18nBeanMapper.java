package com.github.support.dao.i18n.mapper;

import com.github.support.dao.i18n.model.I18nBean;
import com.github.support.dao.i18n.model.I18nBeanKey;

public interface I18nBeanMapper {
    int deleteByPrimaryKey(I18nBeanKey key);

    int insert(I18nBean record);

    int insertSelective(I18nBean record);

    I18nBean selectByPrimaryKey(I18nBeanKey key);

    int updateByPrimaryKeySelective(I18nBean record);

    int updateByPrimaryKey(I18nBean record);
}