package leetcode.collector;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SetDemo {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is setUpBeforeClass...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is tearDownAfterClass...");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("this is setUp...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this is tearDown...");

	}

	@Test
	public void SetUpp() {
		Set<String> list1 = new HashSet<String>();
		list1.add("A");
		list1.add("B");

		Set<String> list2 = new HashSet<String>();
		list2.add("B");
		list2.add("C");

		list1.removeAll(list2);
		System.out.println(list1);
	}

	/**
	 * 交集
	 *
	 * @author zhongtao on 2018/5/30
	 */
	public class Intersection {
		/**
		 * 测试简单交集
		 */
		@Test
		public void testSet() {
			Set<String> set1 = new HashSet<>();
			Set<String> set2 = new HashSet<>();

			set1.add("a");
			set1.add("b");
			set1.add("c");

			set2.add("c");
			set2.add("d");
			set2.add("e");

			// 交集
			set1.retainAll(set2);
			System.out.println("交集是 " + set1); // 交集是 [c]
		}
	}

	/**
	 * 并集
	 *
	 * @author zhongtao on 2018/5/31
	 */
	public class UnionSet {
		/**
		 * 并集测试
		 */
		@Test
		public void testUnionSet() {
			Set<String> set1 = new HashSet<>();
			Set<String> set2 = new HashSet<>();

			set1.add("a");
			set1.add("b");
			set1.add("c");

			set2.add("b");
			set2.add("c");
			set2.add("d");

			set1.addAll(set2);
			System.out.println("并集是" + set1); // 并集是[a, b, c, d]
		}
	}

	/**
	 * 差集
	 *
	 * @author zhongtao on 2018/5/31
	 */
	public class DifferenceSet {
		/**
		 * 差集测试
		 */
		@Test
		public void testDifferenceSet() {
			Set<String> set1 = new HashSet<>();
			Set<String> set2 = new HashSet<>();

			set1.add("a");
			set1.add("b");
			set1.add("c");
			set1.add("d");

			set2.add("c");
			set2.add("d");
			set2.add("e");
			set2.add("f");

			set1.removeAll(set2);
			System.out.println("差集是 " + set1); // 差集是 [a, b]
		}
	}
}
