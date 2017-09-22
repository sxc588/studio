package springservlet01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sound.midi.SysexMessage;

import org.dom4j.tree.AbstractCDATA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.support.cbb.utils.JSONUtil;
import com.github.support.dao.meta.mapper.EntMetaAttriBeanMapper;
import com.github.support.dao.meta.mapper.EntMetaBeanMapper;
import com.github.support.dao.meta.model.EntMetaBean;
import com.github.support.dao.meta.service.MetaServcie;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring-dbcp2.xml")
public class MetaServcieTest
{
	@Autowired
	private MetaServcie service;

	public static String TERM_ROOT = "ROOT";
	public static String VID = "vid";
	public static String TID = "T";

	@Test(timeout = 2000)
	public void deleteByVid()
	{
		service.deleteByVid(VID);
	}

	@Test
	public void saveTerm()
	{
		EntMetaBean metaBean = new EntMetaBean();
		metaBean.setVid(VID);
		metaBean.setParentCode(TERM_ROOT);
		metaBean.setZhName("zhName");
		metaBean.setEnName("enName");
		metaBean.setLastUpdateBy("s00318828");
		for (int i = 100; i < 200; i++)
		{
			metaBean.setCode(TID + i);
			service.saveTerm(metaBean);
		}
	}

	@Test
	public void saveTerm2() throws JsonProcessingException
	{

		List<EntMetaBean> metaList = new ArrayList<EntMetaBean>();
		for (int i = 1000; i < 3999; i++)
		{
			EntMetaBean metaBean = new EntMetaBean();
			metaBean.setVid(VID);
			metaBean.setParentCode(TERM_ROOT);
			metaBean.setZhName("zhName");
			metaBean.setEnName("enName");
			metaBean.setCreateTime(new Date());
			metaBean.setLastUpdateTime(new Date());
			metaBean.setLastUpdateBy("s00318828");
			metaBean.setCode(TID + i);
			metaList.add(metaBean);
		}
		// System.err.println( JSONUtil.toJson(metaList));;
		service.importMeta(VID, metaList);
	}

	@Test(timeout = 3000)
	public void saveTerm3() throws JsonProcessingException
	{

		List<EntMetaBean> metaList = service.getSubMeta(TERM_ROOT);

		System.err.println(metaList.size());
	}

}
