package com.mybatis.mapper;

import static org.junit.Assert.*;
import java.util.Date;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.github.support.i18n.service.I18nBusiness;
import com.mybatis.model.I18n;

public class I18nMapperTest extends AbstractMapperTest
{
	@Autowired
	I18nMapper mapper;
	
	I18n i18n;

	@Before
	public void setUp()
	{
		i18n = new I18n();
		
		i18n.setLangkey("DDDDD");
		i18n.setContent("content");
		i18n.setLastupdatetime(new Date());
		i18n.setDomain("1");
	}
	
	@Test
	public void testInsert()
	{
		mapper.insertSelective(i18n);
	}
}
