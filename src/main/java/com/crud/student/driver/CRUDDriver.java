package com.crud.student.driver;


import java.util.Scanner;

import com.crud.student.operation.Operation;

public class CRUDDriver {
	
	private final static Scanner scanner = new Scanner(System.in);
	private final static Operation operation = new Operation();
	
	public static final int READ = 1;
	public static final int UPDATE = 2;
	public static final int ADD = 3;
	public static final int REMOVE = 4;
	
	
	public static void main(String[] args) {
		System.out.println("Select the operation you want to perform : ");
		System.out.println("1. Read");
		System.out.println("2. Update");
		System.out.println("4. Add");
		System.out.println("3. Delete");
		
		int selection = scanner.nextInt();
		switch(selection) {
		case READ:
			operation.readData();
			break;
		case UPDATE:
			operation.updateStudent();
			break;
		case ADD:
			operation.addStudent();
			break;
		case REMOVE:
			operation.removeStudent();
			break;
		}
	}
}
