package mdas.StudentMgr;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements IStudentMGT {
	
	private List<Student> students;
	
	public StudentManager() {
		this.students = new ArrayList<Student>();
	}
	
//	public int checkPenalties(int idStudent);
	
//	public int createPenalty(int idStudent, int idIncidence);
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public int loadStudents(String studentFile) throws Exception {
		File studFile = new File(studentFile);

		if(!studFile.exists()) {
			System.out.println("Student file not found");
			return -1;
		}
		
		StudentDetails studData = new StudentDetails();
		Scanner scStud = new Scanner(studFile);
		scStud.useDelimiter(";|\n");
		
		// Read the attributes row
		scStud.nextLine();
		
		while(scStud.hasNext()) {
			studData.name = scStud.next(); //name
			studData.username = scStud.next(); //username
			studData.password = scStud.next(); //password
			studData.email = scStud.next(); //email
			studData.degree = scStud.next(); //degree
			
			Student newStudent = new Student( 
					this.getStudents().size(),
					studData.name,
					studData.username,
					studData.email,
					studData.password,
					studData.degree
			);
			
			this.getStudents().add(newStudent);
		}
		
		scStud.close();
		return 0;
	}
	
	public int login(String usernameStudent, String passwordStudent) {
		for(Student student : this.getStudents()) {
			if(student.getUsername().trim().equals(usernameStudent.trim()))
				if(student.getPassword().trim().equals(passwordStudent.trim()))
					return student.getId();
		}
		
		return -1;
	}
	
	public void showStudents() {
		for(Student student : this.getStudents()) {
			System.out.println(student);
		}
	}
}
