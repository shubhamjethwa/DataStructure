package com.evive.training.guava.dataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Map is a collection of key,value pair. A map cannot contain duplicate keys
 * each key can map to at most one value.
 * <p>
 * Use case:
 * <p>
 * i) HashMap : If no ordering of elements required use HasMap.
 * <p>
 * ii) LinkedHashMap : LinkedhashMap if Ordering should be same as the order of insertion
 * <p>
 * iii) TreeHashMap : Use TreeHashMap if sorted ordering of elements is needed
 * <p>
 * iv) ConcurrentHashMap : No guaranteed order in ConcurrentHash Map. It is threadsafe.
 * Use ConcurrentHashMap only when the class where it's being used is thread safe.
 * </blockquote></pre>
 * 
 * 
 * @author ganashree
 *
 */
public class MapTest {

	private static Logger logger = LoggerFactory.getLogger(MapTest.class);
	long startTime, endTime;
	
	/**
	 * 
	 * Insertion Order is different for all Maps.
	 * no guaranteed order in Hashmap , LinkedListMap maintains order same as insertion order 
	 * In treeMap Values sorted according to   natural ordering, no guaranteed order in ConcurrentHashMap.
	 * 
	 */
	@Test
	public void testMapInsertion(){
		
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		Map<Integer, String> hashTable = new Hashtable<Integer, String>();
		Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();
		
		startTime = System.nanoTime();
		hashMap.put(22,"a");
		hashMap.put(1,"b");
		hashMap.put(5,"c");
		hashMap.put(13,"d");
		hashMap.put(10,"e");
		hashMap.put(7,"g");
		endTime = System.nanoTime();
		logger.info("Total time in nano sec to insert into HashMap {}", endTime-startTime);
		
		startTime = System.nanoTime();
		linkedHashMap.put(22,"a");
		linkedHashMap.put(1,"b");
		linkedHashMap.put(5,"c");
		linkedHashMap.put(13,"d");
		linkedHashMap.put(10,"e");
		linkedHashMap.put(7,"g");
		endTime = System.nanoTime();
		logger.info("Total time in nano sec to insert into LinkedHashMap {}", endTime-startTime);
		
		startTime = System.nanoTime();
		treeMap.put(22,"a");
		treeMap.put(1,"b");
		treeMap.put(5,"c");
		treeMap.put(13,"d");
		treeMap.put(10,"e");
		treeMap.put(7,"g");
		endTime = System.nanoTime();
		logger.info("Total time in nano sec to insert into TreeMap {}", endTime-startTime);
		
		startTime = System.nanoTime();
		hashTable.put(22,"a");
		hashTable.put(1,"b");
		hashTable.put(5,"c");
		hashTable.put(13,"d");
		hashTable.put(10,"e");
		hashTable.put(7,"g");
		endTime = System.nanoTime();
		logger.info("Total time in nano sec to insert into HashTable {}", endTime-startTime);
		
		startTime = System.nanoTime();
		concurrentHashMap.put(22,"a");
		concurrentHashMap.put(1,"b");
		concurrentHashMap.put(5,"c");
		concurrentHashMap.put(13,"d");
		concurrentHashMap.put(10,"e");
		concurrentHashMap.put(7,"g");
		endTime = System.nanoTime();
		logger.info("Total time in nano sec to insert into ConcurrentHashMap {}", endTime-startTime);
		
		assertEquals(6, hashMap.size());
		hashMap.put(2, "f");
		assertEquals(7, hashMap.size());
		linkedHashMap.put(10, "h");
		assertEquals("h", linkedHashMap.get(10));
		
		logger.info("hashMap {}",hashMap);
		logger.info("linkedHashMap {}",linkedHashMap);
		logger.info("treeMap {}",treeMap);
		logger.info("hashTable {}",hashTable);
		logger.info("concurrentHashMap {}",concurrentHashMap);
		
	}
	
	@Test
	public void testMapWithSameContent(){
		Map<Integer, String> hashMap1 = new ConcurrentHashMap<Integer, String>();
		Map<Integer, String> hashMap2 = new ConcurrentHashMap<Integer, String>();
		
		assertTrue(hashMap1.isEmpty());
		assertTrue(hashMap2.isEmpty());
		
		hashMap1.put(11, "a");
		hashMap1.put(2, "b");
		hashMap1.put(23, "c");
		
		hashMap2.put(11, "a");
		hashMap2.put(2, "b");
		hashMap2.put(23, "c");
		
		logger.info("hashMap1 {}",hashMap1);
		logger.info("hashMap2 {}",hashMap2);
		assertEquals(hashMap1, hashMap2);
		assertTrue(hashMap2.equals(hashMap1));
		hashMap1.clear();
		assertFalse(hashMap2.equals(hashMap1));
	}
	
	/**
	 * Instead of using for loop to iterate through maps use Entryset.
	 * 
	 * @see
	 * http://howtodoinjava.com/2013/04/01/performance-comparison-of-different-ways-to-iterate-over-hashmap/
	 */
	@Test
	public void testIteratingThroughMap(){
		
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(22,"a");
		hashMap.put(1,"b");
		hashMap.put(5,"c");
		hashMap.put(13,"d");
		hashMap.put(10,"e");
		hashMap.put(7,"g");
		
		Set values = hashMap.entrySet();
		logger.info("Map values {}",values);
	}
	
}
