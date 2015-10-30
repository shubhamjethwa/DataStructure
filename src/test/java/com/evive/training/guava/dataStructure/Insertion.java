package com.evive.training.guava.dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Insertion extends EmployeeModel{


	public Insertion(String number, String name, String date) {
		super(number, name, date);
	}

	public static List<String> insertInToArrayList() {
		List<String> arrayList = new ArrayList<String>(); 
		for(int i=0; i < 1E5 ; i++){
			arrayList.add("a"+i);
		}
		return arrayList;
	}
	
	public static List<String> insertInToLinkedList() {
		List<String> linkedList = new LinkedList<String>(); 
		for(int i=0; i < 1E5 ; i++){
			linkedList.add("a"+i);
		}
		return linkedList;
	}

	public static List<EmployeeModel> getListOfValues() {
		
		EmployeeModel d1 = new EmployeeModel("4566", "John","11/03/2014");
		EmployeeModel d2 = new EmployeeModel("7201","Ted","05/22/2007");
		EmployeeModel d3 = new EmployeeModel("1020", "Kavin", "08/21/2010");
		EmployeeModel d4 = new EmployeeModel("8542", "Jenifer", "05/18/2010");
		List<EmployeeModel> modelList = new ArrayList<EmployeeModel>();

		modelList.add(d1);
		modelList.add(d2);
		modelList.add(d3);
		modelList.add(d4);
		
		return modelList;
	}
	
	
}
