package com.callor.student.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.model.StudentVO;

public class StudentServiceImpl implements StudentService{
	
	@Override
	public void inputStudent() {
		List<StudentVO> stList= new ArrayList<>();
		StudentVO stVO = new StudentVO();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("학번적기");
		stVO.setStNum(scan.nextLine());
		System.out.println("이름적기");
		stVO.setStName(scan.nextLine());
		System.out.println("학과적기");
		stVO.setStDept(scan.nextLine());
		System.out.println("학년적기");
		stVO.setStGrade(scan.nextLine());
		System.out.println("전화번호적기");
		stVO.setStTel(scan.nextLine());
		stList.add(stVO);
		
		FileWriter write = null;
		PrintWriter out = null;
		try {
			write = new FileWriter("src/com/callor/student/model/student.txt");
			out = new PrintWriter(write);
			for(StudentVO vo : stList) {
				out.printf("%s:",vo.getStNum());
				out.printf("%s:",vo.getStName());
				out.printf("%s:",vo.getStDept());
				out.printf("%s:",vo.getStGrade());
				out.printf("%s:",vo.getStTel());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
		try {
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void printStudent() {
		List<StudentVO> stList = new ArrayList<>();
		StudentVO vo = new StudentVO();
		FileInputStream inputFile = null;
		Scanner scan = null;
		
		int stNum = 0;
		int stName = 1;
		int stDept = 2;
		int stGrade = 3;
		int stTel = 4;
		
		try {
			inputFile = new FileInputStream("src/com/callor/student/model/student.txt");
			scan = new Scanner(inputFile);
			
			while(scan.hasNext()) {
				int index = 0;
				
				String line = scan.nextLine();
				String[] text = line.split(":");
				
				if(text.length < stTel + 1) continue;
				vo = StudentVO.builder()
						.stNum(text[stNum])
						.stName(text[stName])
						.stDept(text[stDept])
						.stGrade(text[stGrade])
						.stTel(text[stTel])
						.build();
				stList.add(vo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			inputFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=".repeat(50));
		System.out.println("학번\t이름\t학과\t학년\t전화번호");
		System.out.println("-".repeat(50));
		for(StudentVO print : stList) {
			System.out.println(print);			
		}
	}

}
