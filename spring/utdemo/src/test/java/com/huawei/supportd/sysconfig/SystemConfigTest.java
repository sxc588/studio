package com.huawei.supportd.sysconfig;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import com.huawei.supportd.sysconfig.copy.SystemConfig;



public class SystemConfigTest
{

	@Test
	public void test() throws JAXBException
	{
      JAXBContext context = JAXBContext.newInstance(SystemConfig.class);
        
        Marshaller marshaller = context.createMarshaller();
     //   Unmarshaller unmarshaller = context.createUnmarshaller();
        
        SystemConfig systemConfig = new SystemConfig();
        
        systemConfig.setName("A");
        systemConfig.setKay("kay");
        systemConfig.setValue("kay");
        marshaller.marshal(systemConfig, System.out);
        System.out.println();
        
//        String xml = "<SystemConfig><name>David</name></SystemConfig>";
//        SystemConfig boy2 = (SystemConfig) unmarshaller.unmarshal(new StringReader(xml));
//        System.out.println(boy2.getName());
	}

}
