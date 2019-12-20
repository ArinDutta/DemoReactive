package com.example.demo.rest.vm;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 4352600874523647067L;
	private String empName;
	private String empId;
	private String dept;
	
}
