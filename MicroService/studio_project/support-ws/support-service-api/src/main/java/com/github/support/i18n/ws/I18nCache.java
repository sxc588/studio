package com.github.support.i18n.ws;

import java.sql.SQLException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class I18nCache
{
	public String getContent(String Key, String lang, String domainType)
	{
		return Key+ lang + domainType;
	}
}