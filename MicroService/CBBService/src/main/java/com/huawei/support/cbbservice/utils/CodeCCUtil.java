/**  
 * 实现对Java配置文件Properties的读取、写入与更新操作  
 */
package com.huawei.support.cbbservice.utils;

import org.apache.log4j.Logger;

public class CodeCCUtil
{
	// 测试代码
	public static void LOG(Logger log, Exception e)
	{
		StackTraceElement[] msg = e.getStackTrace();
		log.error(msg.toString());
	}
}
