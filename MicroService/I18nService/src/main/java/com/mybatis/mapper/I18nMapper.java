package com.mybatis.mapper;

import com.mybatis.model.I18n;
import com.mybatis.model.I18nExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface I18nMapper {
    int countByExample(I18nExample example);

    int deleteByExample(I18nExample example);

    int insert(I18n record);

    int insertSelective(I18n record);

    List<I18n> selectByExample(I18nExample example);

    int updateByExampleSelective(@Param("record") I18n record, @Param("example") I18nExample example);

    int updateByExample(@Param("record") I18n record, @Param("example") I18nExample example);
}