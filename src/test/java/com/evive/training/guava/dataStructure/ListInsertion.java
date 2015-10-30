package com.evive.training.guava.dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListInsertion {


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
	
}
