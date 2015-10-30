package com.evive.training.guava.dataStructure;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
/**
 * MultiSet hold multiple instances of same object.It is like set But may have duplicate values.
 * <p>
 * <i>Use Case:
 *  <p>
 *  i) Shopping cart, where we can have multiple items in a single cart.
 *  <p>
 * 
 * @author ganashree
 *
 */
public class MultiSetTest {
	
	private static Logger logger = LoggerFactory.getLogger(MultiSetTest.class);
	long startTime, endTime;

	/**
	 *  MultiSet has count method which returns the number of occurences of an element in Multiset.
	 * 
	 */
	@Test
	public void testToCountNoOfInstances() {
		Multiset<MultiSetTest>  hashMultiset = HashMultiset.create();

		MultiSetTest multiSetTest = new MultiSetTest();
		hashMultiset.add(multiSetTest);

		assertEquals(1, hashMultiset.count(multiSetTest));

		hashMultiset.add(multiSetTest);
		assertEquals(2, hashMultiset.count(multiSetTest));

	}

	/**
	 *  In HashMultiset insertion order cannot be predictable, LinkedhashMultiset maintains the order of
	 *	insertion. TreeMultiSet maintains the natural order of elements.
	 */
	@Test
	public void testMultiSetInsertion() {
		
		Multiset<String> hasMultiset = HashMultiset.create();
		Multiset<String> linkedHashSet = LinkedHashMultiset.create();
		Multiset<String> treeMultiSet = TreeMultiset.create();
		
		hasMultiset.add("Jenifer");
		hasMultiset.add("David");
		hasMultiset.add("Ted");
		hasMultiset.add("John");
		hasMultiset.add("Daisy");
		hasMultiset.add("Kevin");
		
		linkedHashSet.add("Jenifer");
		linkedHashSet.add("David");
		linkedHashSet.add("Ted");
		linkedHashSet.add("John");
		linkedHashSet.add("Daisy");
		linkedHashSet.add("Kevin");
		
		treeMultiSet.add("Jenifer");
		treeMultiSet.add("David");
		treeMultiSet.add("Ted");
		treeMultiSet.add("John");
		treeMultiSet.add("Daisy");
		treeMultiSet.add("Kevin");

		
		hasMultiset.add("Ted"); //Duplicates are allowed.
		
		assertEquals(2, hasMultiset.count("Ted"));
		assertEquals(1, treeMultiSet.count("Ted"));
	
		logger.info("hasMultiset {}",hasMultiset);
		logger.info("linkedHashSet {}",linkedHashSet);
		logger.info("treeMultiSet {}",treeMultiSet);
		
	}

	/**
	 * linkedHashMultiSet insertion is faster. TreeMultiSet is takes more time. HashMultiset insertion is slower
	 *  than LinkedHashMultiSet.
	 * 
	 */
	@Test
	public void testPerformance() {

		Multiset<String> hasMultiset = HashMultiset.create();
		Multiset<String> linkedHashSet = LinkedHashMultiset.create();
		Multiset<String> treeMultiSet = TreeMultiset.create();
		
		startTime = System.nanoTime();
		hasMultiset.add("Jenifer");
		hasMultiset.add("David");
		hasMultiset.add("Ted");
		hasMultiset.add("John");
		hasMultiset.add("Daisy");
		hasMultiset.add("Kevin");
		endTime = System.nanoTime();
		logger.info("Time taken for inserting values to HashMultiset in nanosec id {}",endTime-startTime);
		
		startTime = System.nanoTime();
		linkedHashSet.add("Jenifer");
		linkedHashSet.add("David");
		linkedHashSet.add("Ted");
		linkedHashSet.add("John");
		linkedHashSet.add("Daisy");
		linkedHashSet.add("Kevin");
		endTime = System.nanoTime();
		logger.info("Time taken for inserting values to linkedHashSet in nanosec id {}",endTime-startTime);
		
		startTime = System.nanoTime();
		treeMultiSet.add("Jenifer");
		treeMultiSet.add("David");
		treeMultiSet.add("Ted");
		treeMultiSet.add("John");
		treeMultiSet.add("Daisy");
		treeMultiSet.add("Kevin");
		endTime = System.nanoTime();
		logger.info("Time taken for inserting values to treeMultiSet in nanosec id {}",endTime-startTime);
		Set<String> setOfElements = hasMultiset.elementSet();
		
		assertEquals(6,hasMultiset.size());
	}
	
	
	@Test
	public void testLoopingThroughMultiSet(){
	
		Multiset<String> hasMultiset = HashMultiset.create();
		
		hasMultiset.add("Jenifer");
		hasMultiset.add("David");
		hasMultiset.add("Ted");
		hasMultiset.add("John");
		hasMultiset.add("Daisy");
		hasMultiset.add("Kevin");
		
		Set multiSet = hasMultiset.entrySet();
		
		logger.info("MultiSet using Entryset {} ",multiSet);
		
	}
}
