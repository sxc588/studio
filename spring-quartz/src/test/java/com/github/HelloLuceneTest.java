package com.github;

import org.junit.Test;

public class HelloLuceneTest {

	@Test
	public void test() {
		HelloLucene helloLucene = new HelloLucene();
		helloLucene.index();
		helloLucene.search("AAA");

//	    //存储的文档数量，也就是document对象的数量，删除索引后，这个数值会减少
//	      System.out.println("存储的文档数量: " + reader.numDocs());
//	      （2）获取文档的总量
//
//	      //存储过的文档的最大数量，删除索引后，数量不会减少
//	      //此时删除的文件并不会完全删除，它存在回收站里面
//	      System.out.println("文档存储的总存储量: " + reader.maxDoc());
//	       （3）获取已删除文档的数量
//
//	      System.out.println("删除文档的数量: " + reader.numDeletedDocs());
	}

}
