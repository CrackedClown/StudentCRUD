package com.crud.student.operation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crud.student.entity.Student;

public class Operation {
	private final static Scanner scanner = new Scanner(System.in);
	
	Student getStudentData() {
		Student student = new Student();
		student.setStudentID(scanner.nextLong());
		student.setStudentName(scanner.next());
		student.setStudentAddress(scanner.next());
		return student;
	}

	@SuppressWarnings("unchecked")
	public void readData() {
		Session session = null;
		List<Student> studentList = null;
		try {
			session = GetUtilities.getSession();
			String queryString = "from Student";
			Query query = session.createQuery(queryString);
			studentList = query.list();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		for(Student student: studentList) {
			System.out.println(student);
		}
	}

	public Student updateStudent() {
		Session session = null;
		Student student = getStudentData();
		Transaction transaction = null;
		try {
			session = GetUtilities.getSession();
			student = session.get(Student.class, student.getStudentID());
			transaction = session.beginTransaction();
			session.saveOrUpdate(student);
			transaction.commit();
			System.out.println("Successfully updated the existing student data : " + student.getStudentName() + " " + student.getStudentAddress());
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return student;
	}

	public void addStudent() {
		Student student = getStudentData();
		Session session = null;
		Transaction transaction = null;
		try {
			session = GetUtilities.getSession();
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			System.out.println("Successfully added a new student data : " + student.getStudentName());
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void removeStudent() {
		Student student = getStudentData();
		Session session = null;
		Transaction transaction = null;
		try {
			session = GetUtilities.getSession();
			transaction = session.beginTransaction();
			session.delete(student);
			transaction.commit();
			System.out.println("Successfully deleted an old student data : " + student.getStudentName());
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
