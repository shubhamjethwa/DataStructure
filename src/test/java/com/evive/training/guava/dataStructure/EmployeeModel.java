package com.evive.training.guava.dataStructure;

import java.util.Comparator;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.evive.utils.EviveUtil;
import com.google.common.collect.ComparisonChain;


public class EmployeeModel implements Comparator<EmployeeModel>{

	private static Logger logger = LoggerFactory.getLogger(EmployeeModel.class);
	private String number;
	private String name;
	private String joiningDate;
    private  DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");

    public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJoiningDate() {
		return joiningDate;
	}
	
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	
	public EmployeeModel(String number, String name, String joiningDate) {
		this.number = number;
		this.name = name;
		this.joiningDate = joiningDate;
	}


	public EmployeeModel(){
		
	}
	
	public int compare(EmployeeModel o1, EmployeeModel o2) {
		
		String date1 = o1.getJoiningDate();
		String date2 = o2.getJoiningDate();
		
        DateTime dateTime1 = formatter.parseDateTime(date1);
        DateTime dateTime2 = formatter.parseDateTime(date2);
		logger.info("Datetime 1 {}",dateTime1);
		logger.info("Datetime 2 {}",dateTime2);
		
		return ComparisonChain.start().compare(o1.getNumber(), o2.getNumber()).compare(o1.getName(), o1.getName())
				.compare(dateTime1,dateTime2).result();
	}
	
	
}
