package com.github.support.cbb.utils;

import org.slf4j.Logger;

public class CodexCC
{
	public static void report(Logger log, String errDesc, Throwable e)
	{
		log.error(errDesc,e);
	}
}
