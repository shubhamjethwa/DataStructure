package com.evive.training.guava.dataStructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;

/**
 *  MultiMap associate multiple values with a single key.
 *  can used instead of Map<String , List<String>>
 *  <p>
 *  <i>Use Case:
 *  <p>
 *  i)  In a dictionary,a word as key and its meaning as value. A word can have multiple meaning. 
 * 	<blockquote><pre>
 * 
 * @author ganashree
 *
 */
public class MultiMapTest {

	private static Logger logger = LoggerFactory.getLogger(MultiMapTest.class);

	/**
	 * If different values are inserted for same key. Multimap will have both the values.
	 */
	@Test
	public void testInsertMultiMap(){

		Multimap<String, String> myMultimap = ArrayListMultimap.create();

		myMultimap.put("Fruits", "Bannana");
		myMultimap.put("Fruits", "Apple");
		myMultimap.put("Fruits", "Pear");
		myMultimap.put("Vegetables", "Carrot");

		int size = myMultimap.size();
		logger.info("Multimap {} {}",myMultimap,size);
		assertEquals(4, myMultimap.size());

	}


	@Test
	public void testRemoveFromMultiMap(){

		Multimap<String, String> myMultimap = ArrayListMultimap.create();

		myMultimap.put("Fruits", "Bannana");
		myMultimap.put("Fruits", "Apple");
		myMultimap.put("Fruits", "Pear");
		myMultimap.put("Vegetables", "Carrot");

		int size = myMultimap.size();
		logger.info("Multimap {} {}",myMultimap,size);
		assertEquals(4, myMultimap.size());

		// Removes single key-value pair from the multimap.
		myMultimap.remove("Fruits","Pear");
		assertEquals(3, myMultimap.size());
		logger.info("Multimap {} {}",myMultimap,size);
		
		//Removes all values assosiated with key "Fruits"
		myMultimap.removeAll("Fruits");
		assertEquals(0,myMultimap.get("Fruits").size());
	}

	/**
	 *  Return type of methods depends on the implementation used.
	 * 
	 */
	@Test
	public void testGetValuesFromMultiMap(){

		Multimap<String, String> myMultimap = ArrayListMultimap.create();
		ListMultimap<String, String> listMultiMap = ArrayListMultimap.create();
		SetMultimap< String, String> hashMultiMap = HashMultimap.create();

		myMultimap.put("Fruits", "Bannana");
		myMultimap.put("Fruits", "Apple");
		myMultimap.put("Fruits", "Pear");
		myMultimap.put("Vegetables", "Carrot");

		listMultiMap.put("Fruits", "Bannana");
		listMultiMap.put("Fruits", "Apple");
		listMultiMap.put("Fruits", "Pear");
		listMultiMap.put("Vegetables", "Carrot");
		
		hashMultiMap.put("Fruits", "Bannana");
		hashMultiMap.put("Fruits", "Apple");
		hashMultiMap.put("Fruits", "Pear");
		hashMultiMap.put("Vegetables", "Carrot");
		
		// Mulitimap get method returns Collection 
		Collection<String> multiMapValues = myMultimap.get("Fruits");
		logger.info("multiMapValues {}",multiMapValues);
		
		//ListMultiMap get method returns List of values. 
		List<String> listMultiMapValues = listMultiMap.get("Fruits");
		logger.info("listMultiMap {}",listMultiMapValues);
		
		// SetMultiMap get method returns Set of values.
		Set<String> setMultiMapValues = hashMultiMap.get("Fruits");
		logger.info("SetMultiMapValues {}",setMultiMapValues);
		
		assertThat(listMultiMapValues,hasItems("Bannana", "Apple", "Pear"));
		assertThat(multiMapValues,hasItems("Bannana", "Apple", "Pear"));
		assertThat(setMultiMapValues,hasItems("Bannana", "Apple", "Pear"));
	}
	
}