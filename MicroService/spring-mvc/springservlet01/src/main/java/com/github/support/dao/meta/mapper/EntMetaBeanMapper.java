package com.github.support.dao.meta.mapper;

import java.util.List;

import com.github.support.dao.meta.model.EntMetaBean;

public interface EntMetaBeanMapper {

	EntMetaBean select(String code);
	int insert(EntMetaBean meta);
	int update(EntMetaBean meta);
	int delete(String code);
	
	List<EntMetaBean> getTopMetaByVid(String code);
	List<EntMetaBean> getSubMeta(String code);
	
	int insertMetaList(List<EntMetaBean> metaList);
	int updateMetaList(List<EntMetaBean> metaList);
	int deleteMetaList(List<EntMetaBean> metaList);
	
	List<EntMetaBean> selectByVid(String vid);
	int deleteByVid(String vid);
	int importMeta(List<EntMetaBean> metaList);
}