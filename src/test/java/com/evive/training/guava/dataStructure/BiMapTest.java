package com.evive.training.guava.dataStructure;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;


/**
 * A bimap (or "bidirectional map") is a map that preserves the uniqueness of its values
 * as well as that of its keys. This constraint enables bimaps to support an "inverse view", 
 * which is another bimap containing the same entries as this bimap but with reversed keys and values.
 * <p>
 * Use Case:
 *  <p>
 *  i) Used when we need map of key value pair and also inverse of the same map.
 *  <p>
 * 	For example: language translation Map. Example: English to Spanish and Spanish to English.
 *  <p>
 * @see   http://tomjefferys.blogspot.in/2011/09/multimaps-google-guava.html
 * 
 * @author ganashree
 * 
 */
public class BiMapTest {

	private static Logger logger = LoggerFactory.getLogger(BiMapTest.class);

	/**
	 * inverse method, this returns the inverse BiMap i.e, the a map with the keys and values switched round.
	 */
	@Test
	public void testBiMapInsertion(){

		BiMap<String, String> biMap = HashBiMap.create();

		biMap.put("1", "A");
		biMap.put("2", "B");
		biMap.put("3", "C");
		biMap.put("4", "D");

		assertEquals("C", biMap.get("3"));

		BiMap<String, String> reverse = biMap.inverse();

		assertEquals("3", reverse.get("C"));
		logger.info("Map {}",biMap);
		logger.info("Reverse of Map {}",reverse);

		/**
		 *  BiMap enforces uniqueness of it's values. So use forcePut method that will overwrite the entry with the duplicate value.
		 */

		biMap.forcePut("5", "C");

		assertEquals("C", biMap.get("5"));

		assertTrue(reverse.containsValue("5"));
	}

	/**
	 * reverse map, isn't just a new map.
	 * It's actually a view of the of the original map. This means that any subsequent changes
	 * to the inverse method will affect the original map.
	 */
	@Test
	public void testReverseOfMap(){

		BiMap<String, String> biMap = HashBiMap.create();

		biMap.put("1", "A");
		biMap.put("2", "B");
		biMap.put("3", "C");
		biMap.put("4", "D");

		assertEquals("A", biMap.get("1"));
		BiMap<String, String> reverse = biMap.inverse();
		assertEquals("1", reverse.get("A"));

		reverse.put("D", "5");
		assertEquals("5", reverse.get("D"));
		assertEquals("D", biMap.get("5"));

		logger.info("Reverse of map {}",reverse);
		logger.info("Original map {}",biMap);
	}

	/**
	 * Use EntrySet to get the Map.
	 * 
	 */
	@Test
	public void testUsingEntrySetToGetValues(){

		BiMap<String, String> biMap = HashBiMap.create();

		biMap.put("1", "A");
		biMap.put("2", "B");
		biMap.put("3", "C");
		biMap.put("4", "D");
		biMap.put("5", "E");

		Set values = biMap.entrySet();


		logger.info("Bimap values using Entryset {}",values);

	}

	/**
	 * To get only values use .values()
	 */
	@Test
	public void testUsingBiSetToGetValues(){

		BiMap<String, String> biMap = HashBiMap.create();

		biMap.put("1", "A");
		biMap.put("2", "B");
		biMap.put("3", "C");
		biMap.put("4", "D");
		biMap.put("5", "E");

		Set values = biMap.values();
		logger.info("Bimap values using Entryset {}",values);

	}
}
