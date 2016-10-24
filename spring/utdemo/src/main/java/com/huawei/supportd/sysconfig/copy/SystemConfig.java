package com.huawei.supportd.sysconfig.copy;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import java.io.Serializable;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Java API for XML Binding
 * 
 * 作用是 java对象 <---> xml文件   之间的转换
 * 
 * http://blog.csdn.net/onisland/article/details/5784432
 * 
 * JAXB Annotation
 * @XmlRootElement   // xml 文件的根元素
 * 
 * @XmlElement
 * 
 * @XmlAccessorType  // 表明类内，什么样的成员 是 可以被xml 转化 传输的  可以是 FIELD PROPERTY ...
 * 
 * @XmlTransient
 * 
 * @XmlJavaTypeAdaptor
 * @author Administrator
 */
@XmlRootElement // 必须要标明这个元素
@XmlAccessorType(XmlAccessType.FIELD)
public class SystemConfig implements Serializable
{	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public String getKay()
	{
		return kay;
	}

	public void setKay(String kay)
	{
		this.kay = kay;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

private String name="d ";

	private String kay=" f";

	private String value=" g";
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

//
//	    public static void main(String[] args) throws JAXBException {
//	        JAXBContext context = JAXBContext.newInstance(Boy.class);
//	        
//	        Marshaller marshaller = context.createMarshaller();
//	        Unmarshaller unmarshaller = context.createUnmarshaller();
//	        
//	        Boy boy = new Boy();
//	        marshaller.marshal(boy, System.out);
//	        System.out.println();
//	        
//	        String xml = "<boy><name>David</name></boy>";
//	        Boy boy2 = (Boy) unmarshaller.unmarshal(new StringReader(xml));
//	        System.out.println(boy2.name);
//	    }
//	}
//
//	下面是运行结果：
//
//	<?xml version="1.0" encoding="UTF-8" standalone="yes"?><boy><name>CY</name></boy>
//	David
//	先是marshall成 xml文件，
//
//	再是把 xml 文件 unmarshal 成 java object。
//
//	 
//
//	--------------------------------------------------
//
//	 
//
//	改动一：
//
//	@XmlAccessorType(XmlAccessType.FIELD)  --> @XmlAccessorType(XmlAccessType.PROPERTY)
//
//	意思是 只有 属性 才能被转换成 xml 中的标签。
//
//	所以再运行的结果是：
//
//	<?xml version="1.0" encoding="UTF-8" standalone="yes"?><boy/>
//	CY
//
//	就是说 java object 转换成 xml 的时候，name 不是属性（因为没有 get set方法），所以name不转换成标签。
//
//	 
//
//	-----------------------------------------------------
//
//	 
//
//	改动二：
//
//	在 改动一 的基础上，给name属性添加 get set 方法。 再运行，结果为：
//
//	<?xml version="1.0" encoding="UTF-8" standalone="yes"?><boy><name>CY</name></boy>
//	David
//	由此 可见 @XmlAccessorType 这个annotation 的作用。
//
//	 
//
//	-----------------------------------------------------
//
//	 
//
//	改动三：
//
//	在改动二 的基础上，给Boy 再添加一个field， int age=10, 即：
//
//	 
//
//	package jaxb;
//
//	import javax.xml.bind.annotation.XmlAccessorType;
//	import javax.xml.bind.annotation.XmlRootElement;
//	import javax.xml.bind.annotation.XmlAccessType;
//
//	@XmlRootElement 
//	@XmlAccessorType(XmlAccessType.PROPERTY)
//	public class Boy {    
//	    String name = "CY";
//	    int age = 10; 
//	    public String getName() {
//	        return name;
//	    }
//	    public void setName(String name) {
//	        this.name = name;
//	    }
//	}
//
//	 
//
//	显然，这个age 是不会被 转化 到xml 文件中的。解决办法是：
//
//	 
//
//	import javax.xml.bind.annotation.XmlAccessorType;
//	import javax.xml.bind.annotation.XmlElement;
//	import javax.xml.bind.annotation.XmlRootElement;
//	import javax.xml.bind.annotation.XmlAccessType;
//
//	@XmlRootElement // bixude 
//	@XmlAccessorType(XmlAccessType.PROPERTY)
//	public class Boy {
//	    
//	    String name = "CY";
//	    @XmlElement
//	    int age = 10; 
//	    public String getName() {
//	        return name;
//	    }
//
//	    public void setName(String name) {
//	        this.name = name;
//	    }
//
//	}
//
//	加上 @XmlElement annotation. 运行结果为：
//
//	<?xml version="1.0" encoding="UTF-8" standalone="yes"?><boy><age>10</age> <name>CY</name></boy>
//	David
//
//	 
//
//	--------------------------------------
//
//	 
//
//	对于根元素，可以设置属性：
//
//	@XmlRootElement(name="b" nameSpace="http://test")
//
//	这样，在生成的xml文件中，<boy> 标签 就会变为 <b> 标签。并且加上一个命名空间。
//
//	 
//
//	----------------------------------------
//
//	 
//
//	下面解释 @XmlJavaTypeAdaptor 的作用。
//
//	 
//
//	@XmlRootElement
//	@XmlAccessorType(XmlAccessType.PROPERTY)
//	public class Boy {
//	    
//	    private String name = "CY";
//
//	 
//
//	    private Address address; // 是一个接口
//	    
//	    public String getName() {
//	        return name;
//	    }
//
//	    public void setName(String name) {
//	        this.name = name;
//	    }
//
//	}
//
//	 
//
//	在 java object 转换成 xml 的时候，接口Address 无法被转换。
//
//	所以 这里要加上 @XmlJavaTypeAdapter(AddressAdapter.class)
//
//	所以 要多写一个AddressAdaptor 类。
//
//	这个类会返回Address接口的一个具体实现类的对象。
//
//	 
//
//	这 就是 @XmlJavaTypeAdapter 的作用。
//
//	form:http://speed847.javaeye.com/blog/454231
	
	
}
