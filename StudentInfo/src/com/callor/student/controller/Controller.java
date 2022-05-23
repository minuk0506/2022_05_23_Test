package com.callor.student.controller;

import com.callor.student.service.StudentServiceImpl;

public class Controller {

	public static void main(String[] args) {
		
		StudentServiceImpl stservice = new StudentServiceImpl();
		stservice.inputStudent();
		stservice.printStudent();
	}
	
}
