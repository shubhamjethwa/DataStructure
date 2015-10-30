package com.evive.training.guava.dataStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;

import static org.junit.Assert.*;

/**
 *  ArrayList maintains indexes and element data while LinkedList maintains element data and two pointers for neighbor 
 *  nodes hence the memory consumption is high in LinkedList.
 *  <p>
 *  <i>Use Case:
 *  <p>
 *  i) ArrayList :  less add and remove operations and more search operations requirement see ArrayList.
 *  <p>
 *  ii) LinkedList : More insertion and deletion is needed use ArrayList.But it takes more time for retrieval.
 *  <p>
 *  
 */
public class ListsTest {

	private static Logger logger = LoggerFactory.getLogger(ListsTest.class);
	Stopwatch stopwatch;
	List<String> arrayList;
	List<String> linkedList;
	
	
	/** 
	 *  Linked list Insertion is Faster than Arraylist  insertion.
	 *  
	 */
	@Test
	public void testForListsInsertion() {

	stopwatch = Stopwatch.createStarted();
		arrayList = Insertion.insertInToArrayList();
		stopwatch.stop();
		logger.info( "ArrayList Insertion time in ms {}",stopwatch);

		stopwatch.start();
		linkedList = Insertion.insertInToLinkedList();
		stopwatch.stop();

		logger.info( "LinkedList Insertion time in ms {}",stopwatch);

		assertEquals(3,arrayList.indexOf("a3"));
		assertEquals(4,linkedList.indexOf("a4"));

	}

	/**
	 * Inserting at the starting of Linked list is faster than arrayList because in linkedList new value
	 * is inserted at the beginning and In arrayList first it search for index and then move all elements 
	 * and insert into that index. It takes more time compared to linked list.
	 */
	@Test
	public void testInsertAtStartingIndex(){
		
		List<String> arrayList = new ArrayList<String>(); 
		List<String> linkedList = new LinkedList<String>();

		stopwatch = Stopwatch.createStarted();
		for(int i=0; i < 15 ; i++){
			arrayList.add(0,"a"+i);
		}
		stopwatch.stop();
		logger.info( "ArrayList Insertion time in ms {}",stopwatch);
		
		stopwatch.reset();
		
		stopwatch.start();
		for(int i=0; i < 15 ; i++){
			linkedList.add(0,"a"+i);
		}
		stopwatch.stop();
		logger.info( "LinkedList Insertion time in ms {}",stopwatch);
		
		assertEquals("Inserting to the starting of arraylist","G",arrayList.get(0));
		assertEquals("a1",linkedList.get(0));
	}
	
	@Test
	public void testDeleteFromList(){
		arrayList = Insertion.insertInToArrayList();
		
		stopwatch = Stopwatch.createStarted();
			for(int i=0 ; i < 15 ; i++){
				arrayList.remove(0);
			}
		stopwatch.stop();
		logger.info( "ArrayList Deletion time in ms {}",stopwatch);
		
		linkedList = Insertion.insertInToLinkedList();
		
		stopwatch.reset();
		
		stopwatch.start();
		for(int i=0 ; i < 15 ; i++){
			linkedList.remove(0);
		}
		stopwatch.stop();
		logger.info( "LinkedList Deletion time in ms {}",stopwatch);
		
		assertTrue(linkedList.isEmpty());
		assertTrue(arrayList.isEmpty());
	}
	
	/**
	 *  ArrayList search operation is pretty fast compared to the LinkedList search operation.
	 *  Because Arrays list have index so searching is fast. 
	 *  
	 */
	@Test
	public void testForSearch() {
		
	
		arrayList = new ArrayList<String>();
		linkedList = new LinkedList<String>();
		
		arrayList = Insertion.insertInToArrayList();
		linkedList = Insertion.insertInToLinkedList();
		
		stopwatch = Stopwatch.createStarted();
		arrayList.get(12);
		stopwatch.stop();
		assertEquals("a12",arrayList.get(12));
		logger.info( "ArrayList search time in ms {}",stopwatch);
		
		stopwatch.reset();

		stopwatch.start();
		linkedList.get(12);
		stopwatch.stop();
		assertEquals("a12",linkedList.get(12));
		logger.info( "LinkedList search time in ms {}",stopwatch);
	}
	
	
	 /**
	  * Use Iterator or ListIterator interface to loop over List elements.
	  * ListInterface has more function. 
	  * 
	  */
	@Test
	public void testForIteratingOverList(){

		arrayList = new ArrayList<String>();
		arrayList = Insertion.insertInToArrayList();
		
		Iterator iterator = arrayList.iterator();
		
		while (iterator.hasNext()) {
			logger.info("List Items {}",iterator.next());
		}
		
		assertEquals("a2", arrayList.get(2));
	}	
}
