package com.github.support.mapper;

import com.github.support.model.MigratonErrLog;

public interface MigratonErrLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MigratonErrLog record);

    int insertSelective(MigratonErrLog record);

    MigratonErrLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MigratonErrLog record);

    int updateByPrimaryKeyWithBLOBs(MigratonErrLog record);

    int updateByPrimaryKey(MigratonErrLog record);
}