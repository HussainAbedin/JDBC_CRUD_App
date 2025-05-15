package in.hello.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.hello.daoService.StudentServiceFactory;
import in.hello.dto.Student;
import in.hello.service.StudentService;

public class TestApp {

	public static void main(String[] args) throws IOException {

		StudentService studentService = StudentServiceFactory.getStdService();
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter Student id to update: ");
	    int id = sc.nextInt();
	    sc.nextLine();  // Consume newline left-over
	    
	    // Read the current student record from the database
	    Student student = studentService.readStudent(id);
	    if (student == null) {
	        System.out.println("Student Record Not found for the id: " + id);
	        sc.close();
	        return;
	    }
	    
	    // Show current values and prompt for new values
	    System.out.print("Enter new name (current: " + student.getName() + "): ");
	    String name = sc.nextLine();
	    if (name.isEmpty()) {
	        name = student.getName(); // Use existing name
	    }

	    System.out.print("Enter new age (current: " + student.getAge() + "): ");
	    String ageInput = sc.nextLine();
	    int age;
	    if (ageInput.isEmpty()) {
	        age = student.getAge(); // Use existing age
	    } else {
	        age = Integer.parseInt(ageInput);
	    }

	    System.out.print("Enter new address (current: " + student.getAddress() + "): ");
	    String addr = sc.nextLine();
	    if (addr.isEmpty()) {
	        addr = student.getAddress(); // Use existing address
	    }

	    // Call the service to update the student record in the database
	    String isUpdated = studentService.updateStudent(id, name, age, addr);
	    
	    if (isUpdated.equalsIgnoreCase("success")) {
	        System.out.println("Student record updated successfully.");
	    } else {
	        System.out.println("Failed to update student record.");
	    }

	    sc.close();
		
	}

	private static void delete() {
		StudentService studentService = StudentServiceFactory.getStdService();
		System.out.println("Enter the Student Id ::");
		Scanner sc=new Scanner(System.in);
		int id = sc.nextInt();
		String status = studentService.deleteStudent(id);
		if (status.equalsIgnoreCase("success")) {
			System.out.println("Record Deleted Successfully for the id "+id);
			
		} else if(status.equalsIgnoreCase("recordNotFound")) {
            System.out.println("Student Record Not Found");
		}
		else {
			System.out.println(status);
		}
		sc.close();
	}

	private static void read() {
		StudentService studentService = StudentServiceFactory.getStdService();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student id : ");
		int id = sc.nextInt();
		Student student = studentService.readStudent(id);
		if (student != null) {
			System.out.println("SID\tSAME\tSAGE\tSADDR");
			System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getAge()+"\t"+student.getAddress());
		}
		else {
			System.out.println("Student Record Not found for the id :"+id);
		}
		

		
		sc.close();
	}

	private static void insert() {
		StudentService studentService = StudentServiceFactory.getStdService();

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the student name :: ");
		String sname = scanner.next();

		System.out.print("Enter the student age :: ");
		int sage = scanner.nextInt();

		System.out.print("Enter the student addres :: ");
		String saddress = scanner.next();

		String msg = studentService.createStudent(sname, sage, saddress);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed....");
		}

		scanner.close();
	}

}
