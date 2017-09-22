package com.github.support.dao.meta.mapper;

import com.github.support.dao.meta.model.MetaTermAttrBean;

public interface MetaTermAttrBeanMapper {
    int insert(MetaTermAttrBean record);

    int insertSelective(MetaTermAttrBean record);
}