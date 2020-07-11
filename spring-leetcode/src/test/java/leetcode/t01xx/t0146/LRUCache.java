package leetcode.t01xx.t0146;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

class LRUCache {

    LinkedHashMap<Integer, Integer> map = null;
    Queue<Integer> keyQueue = null;

   int capacity= 0;

    public LRUCache(int capacity) {
    	map = new LinkedHashMap<Integer, Integer>(capacity);
    	keyQueue = new LinkedList<Integer>();
    	this.capacity = capacity;
    }
    
    public int get(int key) {

    	Integer value = map.get(new Integer(key));
    	
    	if (value == null)
    	{
    		System.out.println(-1);
    		return -1;
    	}
    	
    	keyQueue.poll();
    	keyQueue.offer(new Integer(key));
    	System.out.println(value);
    	return value.intValue();
    }
    
    public void put(int key, int value) {

    	if (map.size() ==  capacity)
    	{
    		
    		Integer kk = keyQueue.poll();
    		map.remove(kk);
    	}
    	
    	if (map.containsKey(new Integer(key)))
    	{
    		map.put(new Integer(key),new Integer(value));
    		keyQueue.remove(new Integer(key));
    		keyQueue.offer(new Integer(key));
    		
    	}else {
    		map.put(new Integer(key),new Integer(value));
    		keyQueue.offer(new Integer(key));
		}
    }
}
