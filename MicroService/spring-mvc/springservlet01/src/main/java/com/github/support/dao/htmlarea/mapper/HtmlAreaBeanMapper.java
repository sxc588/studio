package com.github.support.dao.htmlarea.mapper;

import com.github.support.dao.htmlarea.model.HtmlAreaBean;
import com.github.support.dao.htmlarea.model.HtmlAreaBeanKey;

public interface HtmlAreaBeanMapper {
    int deleteByPrimaryKey(HtmlAreaBeanKey key);

    int insert(HtmlAreaBean record);

    int insertSelective(HtmlAreaBean record);

    HtmlAreaBean selectByPrimaryKey(HtmlAreaBeanKey key);

    int updateByPrimaryKeySelective(HtmlAreaBean record);

    int updateByPrimaryKey(HtmlAreaBean record);
}