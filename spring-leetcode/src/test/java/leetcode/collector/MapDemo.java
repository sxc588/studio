package leetcode.collector;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class MapDemo {

	@Test
	public void hashMap() {
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("Zara", "8");
		m1.put("Mahnaz", "31");
		m1.put("Ayan", "12");
		m1.put("Daisy", "14");
		System.out.println();
		System.out.println(" Map Elements");
		System.out.print("\t" + m1);
	}

	@Test
	public void treeMap() {
		Map<String, String> m1 = new TreeMap<String, String>();
		m1.put("Zara", "8");
		m1.put("Mahnaz", "31");
		m1.put("Ayan", "12");
		m1.put("Daisy", "14");
		System.out.println();
		System.out.println(" Map Elements");
		System.out.print("\t" + m1);
	}
}