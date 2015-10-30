package com.evive.training.guava.dataStructure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;

import static org.junit.Assert.*;

/**
 *  A collection that contains no duplicate elements.
 * <p>
 * <i>Use Case:
 *  <p>
 *  i) HashSet : 
 *  <p>
 *  ii) LinkedHashSet : 
 *  <p>
 *  iii) TreeSet : if ordered iteration required use Treeset.
 *  <p>
 * 
 * @author ganashree
 *
 */
public class SetTest {

	private static Logger logger = LoggerFactory.getLogger(SetTest.class);
	private Stopwatch stopwatch;
	
	/**
	 *  HashSet does not maintain any order while LinkedHashSet maintains insertion order of elements
	 *  much like List interface and TreeSet maintains sorting order or elements.
	 */
	@Test
	public void testInsetion(){
		
		Set<String> hashSet = new HashSet<String>();
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		Set<String> treeSet = new TreeSet<String>();
		
		hashSet.add("Jenifer");
		hashSet.add("David");
		hashSet.add("Ted");
		hashSet.add("John");
		hashSet.add("Daisy");
		hashSet.add("Kevin");
		
		linkedHashSet.add("Jenifer");
		linkedHashSet.add("David");
		linkedHashSet.add("Ted");
		linkedHashSet.add("John");
		linkedHashSet.add("Daisy");
		linkedHashSet.add("Kevin");
		
		treeSet.add("Jenifer");
		treeSet.add("David");
		treeSet.add("Ted");
		treeSet.add("John");
		treeSet.add("Daisy");
		treeSet.add("Kevin");
		
		logger.info("Hashset {}" ,hashSet);
		logger.info("LinkedHashSet {}" ,linkedHashSet);
		logger.info("TreeSet {}" ,treeSet);
		
		assertEquals(6, hashSet.size());
		hashSet.add("Holly");
		assertEquals(7, hashSet.size());
	}
	
	/**
	 *  HashSet is fastest, LinkedHashSet is second on performance or almost similar to HashSet 
	 *  but TreeSet is bit slower because of sorting operation it needs to perform on each insertion.
	 *  <p>
	 *  if sorted unique elements are required instead of unique elements, use TreeSet.
	 *  
	 */
	@Test
	public void testSetInsertionPerformance() {
		
		Set<String> hashSet = new HashSet<String>();
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		Set<String> treeSet = new TreeSet<String>();
		
		stopwatch = stopwatch.createStarted();
		
		hashSet.add("Jenifer");
		hashSet.add("David");
		hashSet.add("Ted");
		hashSet.add("John");
		hashSet.add("Daisy");
		hashSet.add("Kevin");
		
		stopwatch.stop();
		logger.info("Time taken for inserting values to HashSet in nanosec id {}",stopwatch);
		
		stopwatch.reset();
		
		stopwatch.start();
		
		linkedHashSet.add("Jenifer");
		linkedHashSet.add("David");
		linkedHashSet.add("Ted");
		linkedHashSet.add("John");
		linkedHashSet.add("Daisy");
		linkedHashSet.add("Kevin");
		
		stopwatch.stop();
		logger.info("Time taken for inserting values to LinkedHashSet in nanosec id {}",stopwatch);
		
		stopwatch.reset();
		
		stopwatch.start();
		treeSet.add("Jenifer");
		treeSet.add("David");
		treeSet.add("Ted");
		treeSet.add("John");
		treeSet.add("Daisy");
		treeSet.add("Kevin");
		
		stopwatch.stop();
		logger.info("Time taken for inserting values to treeset in nanosec id {}",stopwatch);
	}
	
	/**
	 * Use Iterator interface to loop over set of values.
	 * 
	 */
	@Test
	public void testIterationOverLoop(){
		
		Set<String> hashSet = new TreeSet<String>();
		
		hashSet.add("Jenifer");
		hashSet.add("David");
		hashSet.add("Ted");
		hashSet.add("John");
		hashSet.add("Daisy");
		hashSet.add("Kevin");
		
		Iterator iterator = hashSet.iterator();
		
		while(iterator.hasNext()){
			logger.info("HashSet values {}",iterator.next());
		}
	}
	
	
}
