
package com.evive.training.guava.dataStructure;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Default initial capacity is 16 and LoadFactor is 0.75<p>
 * (Initial capacity x LoadFactor) < Total entries in HashMap. <p>
 * If the total entries in Hash map is more then its product
 * of load factor and initial capacity then the hash map calls
 * it rehash function to double its capacity.
 * <p>
 * For small hash maps there is no big difference, but for situations
 * with really large hash maps (e.g. 100 MB size) it can seriously increase
 * the needed memory and the rehashing causes a slowdown of the application.
 * 
 * 
 * if <p>
 * initial capacity > (maximum no of elements)/0.75 <p>
 * then,rehashing can be minimized.
 *
 * 
 * @author ganashree
 */
public class LoadFactorTest {

	private static Logger logger = LoggerFactory.getLogger(LoadFactorTest.class);
	
	/**
	 *  Here initial Capacity is 16 and LoadFactor is 0.75. So, (16 x 0.75)=12.
	 *  Threshold is 12.After 12 Entries rehash will takes place and capacity 
	 *  is doubled.i.e, 32.
	 *  
	 *  @see
	 *  <p> http://www.tutorialsavvy.com/2012/12/capacity-load-factor-hashmap.html
	 */
	@Test
	public void testForDefaultLoadFactor(){
		
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		
		for (int i = 0; i <= 15; i++) {
			hashMap.put(i, "a"+i);
		}
		
		
		/**
		 * After index 12 . rehashing happens and the initial capacity will become 32.
		 */
		assertEquals(16, hashMap.size());
	}
	
	/**
	 * Here, initial capacity is set to 23. <p>
	 *  16/0.75 = 21.33
	 *  <p>
	 *  So, Rehashing will not happen.
	 * 
	 */
	@Test
	public void testForInitialCapaity(){
		
		Map<Integer, String> hashMap = new HashMap<Integer, String>(22);
		
		for (int i = 0; i <= 15; i++) {
			hashMap.put(i, "a"+i);
		}
		
		assertEquals(15, hashMap.size());
	}
}
