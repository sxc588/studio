package com.github;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

//一：简单的示例
//1.1：生成索引
//　　1.1.1：Field.Store和Field.Index
//　 1.1.2：为数字生成索引
//　 1.1.3：为索引加权
//　 1.1.4：为日期生成索引
//1.2：查询
//　1.2.1：介绍IndexReader
//1.3：删除
//　1.3.1：还原删除的文档
//　1.3.2：清空回收站时面的数据
//1.4：更新

public class HelloLucene {

	/**
	 * 检查一下索引文件
	 */
	public static void check() {
		IndexReader indexReader = null;
		try {
			Directory directory = FSDirectory.open(new File("F:/test/lucene/index"));
			indexReader = IndexReader.open(directory);
			// 通过reader可以有效的获取到文档的数量
			// 有效的索引文档
			System.out.println("有效的索引文档:" + indexReader.numDocs());
			// 总共的索引文档
			System.out.println("总共的索引文档:" + indexReader.maxDoc());
			// 删掉的索引文档，其实不恰当，应该是在回收站里的索引文档
			System.out.println("删掉的索引文档:" + indexReader.numDeletedDocs());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (indexReader != null) {
					indexReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除索引
	 */
	public static void delete2() {
		IndexWriter indexWriter = null;
		try {
			Directory directory = FSDirectory.open(new File("F:/test/lucene/index"));
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);
			indexWriter = new IndexWriter(directory, indexWriterConfig);
			/**
			 * 参数是一个选项，可以是一个Query，也可以是一个term，term是一个精确查找的值
			 * 
			 * 此时删除的文档并不会被完全删除，而是存储在一个回收站中的，可以恢复
			 */

			// 方式一：通过Term删除

			/**
			 * 注意Term构造器的意思，第一个参数为Field，第二个参数为Field的值
			 */
			// indexWriter.deleteDocuments(new Term("id", "1"));

			// 方式二：通过Query删除

			/**
			 * 这里就要造一个Query出来，删掉查处的索引
			 */
			QueryParser queryParser = new QueryParser(Version.LUCENE_35, "content", analyzer);
			// 创建Query表示搜索域为content包含Lucene的文档
			Query query = queryParser.parse("Lucene");

			// indexWriter.deleteDocuments(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (indexWriter != null) {
					indexWriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 强制删除
	 */
	public static void forceDelete() {
		IndexWriter indexWriter = null;
		try {
			Directory directory = FSDirectory.open(new File("F:/test/lucene/index"));
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);
			indexWriter = new IndexWriter(directory, indexWriterConfig);
			indexWriter.forceMergeDeletes();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (indexWriter != null) {
					indexWriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 合并索引
	 */
	public static void merge() {
		IndexWriter indexWriter = null;
		try {
			Directory directory = FSDirectory.open(new File("F:/test/lucene/index"));
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);
			indexWriter = new IndexWriter(directory, indexWriterConfig);
			// 会将索引合并为2段，这两段中的被删除的数据会被清空
			/**
			 * 特别注意：
			 * 
			 * 此处Lucene在3.5之后不建议使用，因为会消耗大量的开销，Lucene会根据情况自动处理的
			 */

			// 把索引合并为两段
			indexWriter.forceMerge(2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (indexWriter != null) {
					indexWriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 恢复删除的索引
	 */
	public static void unDelete() {
		// 使用IndexReader进行恢复
		IndexReader indexReader = null;
		try {
			Directory directory = FSDirectory.open(new File("F:/test/lucene/index"));
			// 恢复时，必须把IndexReader的只读(readOnly)设置为false
			// 索引没有改变可以使用true，但现在是恢复删除的索引，显然是改变过的，所以只能是false
			indexReader = IndexReader.open(directory, false);
			indexReader.undeleteAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (indexReader != null) {
					indexReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 更新索引
	 */
	public static void update() {
		IndexWriter indexWriter = null;
		try {
			Directory directory = FSDirectory.open(new File("F:/test/lucene/index"));
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);
			indexWriter = new IndexWriter(directory, indexWriterConfig);
			/**
			 * Lucene并没有提供更新，这里的更新操作其实是如下两个操作的合集 先删除之后再添加
			 */
			// Document document = new Document();
			// document.add(new Field("id", "11", Field.Store.YES,
			// Field.Index.NOT_ANALYZED_NO_NORMS));
			// document.add(new Field("author", authors[0], Field.Store.YES,
			// Field.Index.NOT_ANALYZED));
			// document.add(new Field("title", titles[0], Field.Store.YES,
			// Field.Index.ANALYZED));
			// document.add(new Field("content", contents[1], Field.Store.NO,
			// Field.Index.ANALYZED));
			// indexWriter.updateDocument(new Term("id", "1"), document);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (indexWriter != null) {
					indexWriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private Directory directory = null;// Directory.;//new Directory("d:/test/lucene/index");

	/**
	 * 3.6：连接多个条件的查询 有的时候，查询一个复杂的数据，一个搜索条件，可能不满足结果，那么就可以使用BooleanQuery
	 * BooleanQuery就是Query的扩展类，这个类可以增加任意多个查询条件，并且通过Occur枚举过定义，查询条件的必要性
	 */
	public void BooleanQuery() {
		try {
			Directory directory = FSDirectory.open(new File("d:/index"));
			IndexReader reader = IndexReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);

			// 这个query下面可以add任何多个查询条件
			BooleanQuery query = new BooleanQuery();
			// 名字一定是张三
			query.add(new TermQuery(new Term("name", "张三")), BooleanClause.Occur.MUST);
			// 名族一定不是汉族
			query.add(new TermQuery(new Term("nation", "汉")), BooleanClause.Occur.MUST_NOT);
			// 可以出现，也可以不出现
			query.add(new WildcardQuery(new Term("content", "a")), BooleanClause.Occur.SHOULD);

			searcher.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 清空回收站里面的数据
	 */
	public void clearRecovery() {
		try {
			IndexWriter writer = new IndexWriter(directory,
					new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35)));

			writer.forceMergeDeletes();
			// 代表着是否等待当前操作完成后，再清空回收站里面的数据
			writer.forceMergeDeletes(true);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除索引 注意：上面的构造方法和以往不同，后面多了一个boolean值，这个值，如果不写，默认是true，代表着只读，
	 * 那么如果在这种情况下进行还原，是会抛出异常的。这里将其设置为false，也就是把只读设置为了false，这样就可以还原了。
	 */
	public void delete() {
		try {
			IndexWriter writer = null;
			writer = new IndexWriter(directory,
					new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35)));

			// 删除全部的索引
			// writer.deleteAll();

			// 参数可以为一个查询的Query，也可以为一个Term，它是一个精确的值，代表着把id为1的给删除掉
			writer.deleteDocuments(new Term("id", "1"));

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 3.8：模糊查询 这里要先说明一下，模糊查询与通配符查询是有区别的。模糊查询是代表着允许有着一定的错别字
	 * 这里来进行说明一下，假如我有这样的一些name属性:jane mike kangkang
	 */
	public void FuzzyQuery() {
		try {
			Directory directory = FSDirectory.open(new File("d:/index"));
			IndexReader reader = IndexReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);

			// 这里是int整数的查询方法，其实，还有float,long,double等方式，也都是通过NumericRangeQuery这个类
			// NumericRangeQuery.newDoubleRange(..); 这是Double类型的
			// NumericRangeQuery.newFloatRange(...); 这是Float类型的
			// NumericRangeQuery.newLongRange(...); 这是Long类型的
			// 这里的意思是查询age域中，1岁到100岁的，其中，包含1岁和100岁的

			// //通过这个，肯定是可以找到mkie的结果的
			// FuzzyQuery query1 = new FuzzyQuery(new Term("name","mike"));
			// //这里我把i写成了a，但是也是可以查到mike的
			// FuzzyQuery query2 = new FuzzyQuery(new Term("name","make"));
			//
			// //通过第2个float参数调整相似度，值越低，代表相似度越低，容错率越高
			// FuzzyQuery query3 = new FuzzyQuery(new
			// Term("name","make"),0.5f,0);

			Query query = NumericRangeQuery.newIntRange("age", 1, 100, true, true);

			searcher.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 建立索引
	 */
	public void index() {
		IndexWriter indexWriter = null;
		try {
			// 1、创建Directory
			// 建立在内存中
			// Directory directory = new RAMDirectory();
			// 建立在硬盘式
			Directory directory = FSDirectory.open(new File("d:/test/lucene/index"));

			// 2、创建IndexWriter
			// 使用默认的标准分词器
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);

			indexWriter = new IndexWriter(directory, indexWriterConfig);

			File dFile = new File("d:/test/lucene/document");
			File[] files = dFile.listFiles();
			for (File file : files) {
				// 3、创建Document对象
				Document document = new Document();

				// 4、为Document添加Field
				document.add(new Field("content", new FileReader(file)));
				document.add(new Field("filename", file.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
				document.add(new Field("filepath", file.getAbsolutePath(), Field.Store.YES, Field.Index.NOT_ANALYZED));

				// 5、通过IndexWriter添加文档到索引中
				indexWriter.addDocument(document);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (indexWriter != null) {
					indexWriter.close();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 3.3：数字的范围搜索
	 * 
	 * 就是查询一定区间的字符。可能这句话说不明白，我们用代码来说明： 假如我有下面的一段字符 I love lucene very much
	 * 那么我现在的目的是，我忘了中间的单词是什么了，我只记得开头为I，结尾为much，那要怎么做呢？
	 */
	public void PhraseQuery() {
//		try
//		{
//			Directory directory = FSDirectory.open(new File("d:/index"));
//			IndexReader reader = IndexReader.open(directory);
//			IndexSearcher searcher = new IndexSearcher(reader);
//
//			PhraseQuery query = new PhraseQuery();
//			// 第一个结果，注意I会变成小写
//			query.add(new Term("content", "i"));
//			// 代表着中间相隔3个单词
//			query.setSlop(3);
//			// 第二个结果
//			query.add(new Term("content", "nuch"));
//
//			searcher.close();
//			reader.close();
//		} catch (IOException e)
//		{
//			e.printStackTrace();
//		}
	}

	/**
	 * 3.4：前缀搜索 前缀搜索，就是对于一个域中的前缀进行匹配，当然，它也会匹配分词后的前缀 上面的代码，会找出所有name中姓刘的数据。
	 * 注意：如果内容中进行了分词，那将会查找每一个分词中的以此字符开头的数据。
	 */
	public void PrefixQuery() {
		try {
			Directory directory = FSDirectory.open(new File("d:/index"));
			IndexReader reader = IndexReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);

			Query query = new org.apache.lucene.search.PrefixQuery(new Term("name", "刘"));

			searcher.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除索引并不是完全删除，它是有着一个回收站的功能 上面的delete删除了一个索引，这里进行恢复
	 */
	public void recovery() {
		try {
			// 这一步很重要，因为默认打开的reader是只读的，所以这里要通过构造方法，把它的readonly设置为false，否则会抛出异常
			IndexReader reader = IndexReader.open(directory, false);
			// 还原所有已删除的数据
			reader.undeleteAll();

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 搜索
	 */
	public void search(String keyWord) {
		IndexReader indexReader = null;
		try {
			// 1、创建Directory
			Directory directory = FSDirectory.open(new File("D:/test/lucene/index"));
			// 2、创建IndexReader
			indexReader = IndexReader.open(directory);
			// 3、根据IndexReader创建IndexSearch
			IndexSearcher indexSearcher = new IndexSearcher(indexReader);
			// 4、创建搜索的Query
			// 使用默认的标准分词器
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);

			// 在content中搜索Darren
			// 创建parser来确定要搜索文件的内容，第二个参数为搜索的域
			QueryParser queryParser = new QueryParser(Version.LUCENE_35, "content", analyzer);
			// 创建Query表示搜索域为content包含Darren的文档
			Query query = queryParser.parse(keyWord);

			// 5、根据searcher搜索并且返回TopDocs
			TopDocs topDocs = indexSearcher.search(query, 10);
			System.out.println("查找到的文档总共有：" + topDocs.totalHits);

			// 6、根据TopDocs获取ScoreDoc对象
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for (ScoreDoc scoreDoc : scoreDocs) {
				// 7、根据searcher和ScoreDoc对象获取具体的Document对象
				Document document = indexSearcher.doc(scoreDoc.doc);
				// 8、根据Document对象获取需要的值
				System.out.println(document.get("filename") + " " + document.get("filepath"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (indexReader != null) {
					indexReader.clone();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 说完精确搜索，下面介绍一下范围搜索。范围搜索，也就是指在一定区间范围内查询，下面给出代码的示例。
	 * 注意：TermRangeQuery无法查询数字的结果，也就是使用NumericField来存储的索引，但是可以查询"1","2"字符串类型的数字。
	 */
	public void searcher1() {
		try {
			Directory directory = FSDirectory.open(new File("d:/index"));
			IndexReader reader = IndexReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			// 这是珍上范围搜索，意思是搜索id域中，最低为1，最高为10，后面的两个boolean的参数分别代表着，是否包好最低值与最高值
			// 但是数字类型是查不出来的，也就是NumericField来存储field的类型，使用TermRangeQuery是查不出来的，需要使用NumericRangeQuery
			Query query = new TermRangeQuery("id", "1", "10", true, true);

			// 查询名字以a 开头，到以f开头的
			// Query query = new TermRangeQuery("name","a","f",true,true);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 3.3：数字的范围搜索
	 * 上面说了字符串的范围搜索，而且还特意强掉了，数字不能用TermRangeQuery，那么如果数字的范围搜索，要怎么做呢？可以使用NumericRangeQuery，
	 */
	public void searcher2() {
		try {
			Directory directory = FSDirectory.open(new File("d:/index"));
			IndexReader reader = IndexReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);

			// 这里是int整数的查询方法，其实，还有float,long,double等方式，也都是通过NumericRangeQuery这个类
			// NumericRangeQuery.newDoubleRange(..); 这是Double类型的
			// NumericRangeQuery.newFloatRange(...); 这是Float类型的
			// NumericRangeQuery.newLongRange(...); 这是Long类型的
			// 这里的意思是查询age域中，1岁到100岁的，其中，包含1岁和100岁的

			Query query = NumericRangeQuery.newIntRange("age", 1, 100, true, true);

			searcher.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 精确查询 何为精确查询，精确查询就相当于数据库的=号，也就是查询的字符，与索引中字符必须完全一致，才能匹配到
	 */
	public void searchers(String name) {
		try {
			Directory directory = FSDirectory.open(new File("d:/index"));
			IndexReader reader = IndexReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			// 这个是精确查询
			Query query = new TermQuery(new Term("name", name));
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 3.5：通配符搜索 通配符大家应该听说过的，那就是*代表任何字符，?代表一个字符
	 */
	public void WildcardQuery() {
		try {
			Directory directory = FSDirectory.open(new File("d:/index"));
			IndexReader reader = IndexReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);

			Query query = new WildcardQuery(new Term("content", "*a?"));

			searcher.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
