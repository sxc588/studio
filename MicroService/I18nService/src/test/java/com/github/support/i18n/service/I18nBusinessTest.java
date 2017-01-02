package com.github.support.i18n.service;

import static org.junit.Assert.*;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;
import com.mybatis.mapper.I18nMapper;
import com.mybatis.model.I18n;

public class I18nBusinessTest
{
	
	IMocksControl control;

	I18nBusiness bus;
	
	I18nMapper mapperMock;
	
	@Before
	public void setUp()
	{
		bus = new I18nBusiness();
		
		// mock
		control  = EasyMock.createControl();
		mapperMock = control.createMock(I18nMapper.class);
		
		bus.setMapper(mapperMock);
	}

	@Test
	public void testGetStringValue()
	{
		String key="key";
		String actural = bus.getStringValue(key);
	}

	@Test
	public void testInsert()
	{
		I18n record = new I18n();
		int expected = 1;
		EasyMock.expect(mapperMock.insert(record)).andReturn(expected );
		
		control.replay();
		
		int actural = bus.insert(record);
		
		assertEquals(actural,expected);
		control.verify();

	}

}
