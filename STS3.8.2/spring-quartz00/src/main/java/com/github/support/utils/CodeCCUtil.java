package com.github.support.utils;

import org.slf4j.Logger;

public class CodeCCUtil {

	public static void LogException(Logger log, String descrption, Throwable e) {
		String msg = e.getMessage();
		log.error("{}:{}", descrption, msg);
	}

}
