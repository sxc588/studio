package com.mybatis.mapper;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.InitBinder;
import org.xml.sax.InputSource;
import com.github.support.i18n.service.I18nBusiness;
import com.mybatis.model.I18n;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"})
public class AbstractMapperTest
{
	
	private static final InputStream AbstactDbunitTestCase = null;
	private File tempFile;

	@BeforeClass
	void InitBinder()
	{
		
	}
	
	protected IDataSet createDataSet(String name) throws DataSetException
	{
		InputStream is = AbstactDbunitTestCase
				.class
				.getClassLoader()
				.getResourceAsStream(name+".xml");
		
		
		assertNotNull("dbuint 的基本数据文件不存在",is);
		return new FlatXmlDataSet( new FlatXmlProducer(new InputSource(is)));
	}
	
	
	protected void backUpAllTable() throws IOException, DataSetException
	{
		IDataSet ds = createDataSet("");
		
		tempFile = File.createTempFile("back", "xml");
		FlatXmlDataSet.write(ds,new FileWriter(tempFile));

	}
	
	
	protected void backUpAllTable(String name) throws IOException, DataSetException
	{
		IDataSet ds = createDataSet("");
		
		tempFile = File.createTempFile("back", "xml");
		FlatXmlDataSet.write(ds,new FileWriter(tempFile));

	}
	
	
	@AfterClass
	void destory()
	{

	}
}
