package com.github.support.dao.meta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.support.dao.meta.mapper.EntMetaBeanMapper;
import com.github.support.dao.meta.model.EntMetaBean;

@Service
public class MetaServcie
{
	@Autowired
	private EntMetaBeanMapper metaBeanMapper;


	public EntMetaBean getTermByCode(String code)
	{
		return metaBeanMapper.select(code);
	}
	
	@Transactional
	public int saveTerm(EntMetaBean meta)
	{
		EntMetaBean dbBean = metaBeanMapper.select(meta.getCode());
		if (null == dbBean)
		{
			return metaBeanMapper.insert(meta);
		}
		return metaBeanMapper.update(meta);
	}
	
	public int delete(String code)
	{
		return metaBeanMapper.delete(code);
	}
	
	public int deleteByVid(String vid)
	{
		return metaBeanMapper.deleteByVid(vid);
	}
	
	 @Transactional
	public int importMeta(String vid, List<EntMetaBean> metaList)
	{
		for (EntMetaBean metaBean : metaList)
		{
			metaBean.setVid(vid);
		}
		metaBeanMapper.deleteByVid(vid);
		return metaBeanMapper.importMeta(metaList);
	}
	
	@Transactional
	public  List<EntMetaBean> getTopMetaByVid(String vid)
	{
		return metaBeanMapper.getTopMetaByVid(vid);
	}

	public List<EntMetaBean> getSubMeta(String code)
	{
		return metaBeanMapper.getSubMeta(code);
	}
	

	//// public EntMetaBean getMeta(String code)
	//// {
	//// return metaBeanMapper.getMeta();
	//// }
	//

	// public List<EntMetaBean> getSubMeta(String code)
	// {
	// List<EntMetaBean> metas = metaBeanMapper.getSubMeta();
	// for (EntMetaBean meat:metas)
	// {
	//// List<metaAttri> attrs = metaAttriBeanMapper.getAttr();
	////
	//// List<metaAttri> map = toMap(attrs);
	////
	//// meat.setAttribute(code);
	// }
	//
	// return metaBeanMapper.getSubMeta();
	// }
	//
	// public EntMetaBean getMeta(String code)
	// {
	// return metaBeanMapper.getMeta();
	// }
	//
	// public EntMetaBean saveMeta(EntMetaBean meta)
	// {
	// int i = metaBeanMapper.saveMeta(meta);
	//
	// saveMetaList(meta.getChildRen());
	// }
	//
	// public int saveMetaList(List<EntMetaBean> metaList)
	// {
	// return metaBeanMapper.saveMetaList(metaList);
	// }
	//
	// public int saveMetaList(List<EntMetaBean> metaList)
	// {
	// return metaBeanMapper.saveMetaList(metaList);
	// }

}
