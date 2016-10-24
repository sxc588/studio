package org.crazyit.demo;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Locales
{
	private Map<String, Locale> locales;

	public Locales()
	{
		locales = new HashMap<String, Locale>();
		locales.put(Locale.CHINA.getDisplayCountry(), Locale.CHINA);
		locales.put(Locale.US.getDisplayCountry(), Locale.US);
	}

	public Map<String, Locale> getLocales()
	{
		return locales;
	}

}
