package com.github.support.utils;

import org.junit.Test;

public class HttpClient10Test {

	@Test
	public void testSendGet() {

		String url = "https://support.huawei.com/enterpriseproduct/docTypeNewOffering!getDocsAll.action?";
		String param = "pageIndex=0&pageSize=0&subModelOfferingId=PBI2-&thirdItem=&offeringId=PBI2-6691579&pbiId=&requestType=ajax.json&lang=zh";

		String result = HttpClient10.sendGet(url, param);
		System.err.println(result);
	}

	@Test
	public void testSendPost() {

		String url = "https://support.huawei.com/enterpriseproduct/docTypeNewOffering!getDocsAll.action?";
		String param = "pageIndex=0&pageSize=0&subModelOfferingId=PBI2-&thirdItem=&offeringId=PBI2-6691579&pbiId=&requestType=ajax.json&lang=zh";

		String result = HttpClient10.sendPost(url, param);
		System.err.println(result);
	}

}
