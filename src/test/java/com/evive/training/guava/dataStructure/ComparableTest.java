package com.evive.training.guava.dataStructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Impose total ordering on the objects of each class that implements comparable<T> interface.
 * compareto method is used to compare objects.
 * It provide only single sorting sequence i.e. you can sort the elements on based on single datamember only
 * <p>
 * <i>Use Case:
 * <p>
 * i) Use comparable when there is need for comparing instances of same class.
 * <p>
 * @author ganashree
 *
 *
 */
public class ComparableTest{

	@Test
	public void testForEqual(){
		
			HDTV tv1 = new HDTV(55, "Samsung");
			HDTV tv2 = new HDTV(55, "Samsung");
				
			int result = tv1.compareTo(tv2);
			assertTrue(result == 0);
		}
	
	
	@Test
	public void testForGreaterThan(){
		
		HDTV tv1 = new HDTV(75, "Samsung");
		HDTV tv2 = new HDTV(60, "Sony");
			
		int result = tv1.compareTo(tv2);
		assertTrue(result >= 1);
		
	}

	@Test
	public void testForLesserThan(){
		HDTV tv1 = new HDTV(35, "Samsung");
		HDTV tv2 = new HDTV(60, "Sony");
			
		int result = tv1.compareTo(tv2);
		assertTrue(result <= -1);
	}
	
}
