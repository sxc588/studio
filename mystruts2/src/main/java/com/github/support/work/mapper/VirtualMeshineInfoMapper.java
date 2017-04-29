package com.github.support.work.mapper;

import java.util.List;
import com.github.support.work.model.VirtualMeshineInfo;

public interface VirtualMeshineInfoMapper {
    int deleteByPrimaryKey(String instance);

    int insert(VirtualMeshineInfo record);

    int insertSelective(VirtualMeshineInfo record);

    VirtualMeshineInfo selectByPrimaryKey(String instance);

    int updateByPrimaryKeySelective(VirtualMeshineInfo record);

    int updateByPrimaryKey(VirtualMeshineInfo record);
    
    
    List<VirtualMeshineInfo> selectBySelection(VirtualMeshineInfo instance);
    
}