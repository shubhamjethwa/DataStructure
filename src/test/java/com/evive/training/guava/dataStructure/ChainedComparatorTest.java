package com.evive.training.guava.dataStructure;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ComparatorChain is a Comparator that wraps one or more Comparators in sequence. 
 * The ComparatorChain calls each Comparator in sequence until either 
 * any single Comparator returns a non-zero result or the ComparatorChain is exhausted
 * <p>
 * <i>Use Case:<i>
 * <p>
 * If there is need for sorting using multiple parameters. For example:
 * In EmploeeModel we can sort using number in ascending order, name descending and date
 * in natural order.
 * </p>
 * @author ganashree
 *
 */
public class ChainedComparatorTest{

	private static Logger logger = LoggerFactory.getLogger(ComparableTest.class);
	private List<EmployeeModel> listOfValues = new ArrayList<EmployeeModel>();

	@Before
	public void getTestModelValues(){
		listOfValues = Insertion.getListOfValues();
	}

	/**
	 * In DateComparator first it compares number , if it return non-zero value.It sorts using name
	 * if it return 0 then it goes to next comparator that it name.
	 *  
	 */ 
	@Test
	public void testForChainedComparator(){
		
		for(EmployeeModel testModel : listOfValues){
			logger.info("Before sorting {} {} {}",testModel.getNumber(),testModel.getName(),testModel.getJoiningDate());
		}
		
		Collections.sort(listOfValues, new EmployeeModel());

		for(EmployeeModel testModel : listOfValues){
			logger.info("After sorting {} {} {}",testModel.getNumber(),testModel.getName(),testModel.getJoiningDate());
		}
	}

	/**
	 * First it compares numbers it return 0,then it compares name it returns 0 , at last it compares date 
	 * which is same, so it returns 0.
	 * 
	 */
	@Test
	public void testForComparator(){
	
		EmployeeModel d1 = new EmployeeModel("4566", "John","11/03/2014");
		EmployeeModel d2 = new EmployeeModel("4566", "John","11/03/2014");
		
		EmployeeModel employeeModel = new EmployeeModel();
		assertEquals(0, employeeModel.compare(d1, d2));
	}
	
	
	/**
	 * First it compares number, d1 number is lesser than d2 number so it returns -1.
	 * comparator chain stops when non-zero value is returned.
	 * 
	 */
	@Test
	public void testForFirstComparator(){
		
		EmployeeModel d1 = new EmployeeModel("4566","John","11/03/2014");
		EmployeeModel d2 = new EmployeeModel("7892","John","11/03/2014");
		
		EmployeeModel employeeModel = new EmployeeModel();
		assertEquals(-1,employeeModel.compare(d1, d2));
	}

	/**
	 * First it compares number which is same then compares d1 name is greater than d2 name so it returns 1.
	 * comparator chain stops when non-zero value is returned.
	 * 
	 */
	@Test
	public void testForSecondComparator(){
		
		EmployeeModel d1 = new EmployeeModel("4566", "Ted","11/03/2014");
		EmployeeModel d2 = new EmployeeModel("4566","John","02/24/2010");
		
		EmployeeModel employeeModel = new EmployeeModel();
		assertEquals(1,employeeModel.compare(d1, d2));
	}
}
