import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


public class Login {
	public void login (String studentFile, String adminFile)throws Exception{
		File admFile = new File(adminFile);
		
		if(!admFile.exists()) {
			System.out.println("Professor file not found, fool");
			return;
		}
		
		String[] admData = new String[6];
		Scanner scAdm = new Scanner(admFile);
		scAdm.useDelimiter(";|\n");
		
		// Read the attributes row
		scAdm.nextLine();
		
		while(scAdm.hasNext()) {
			admData[0] = scAdm.next(); //username
			admData[1] = scAdm.next(); //password
			
			Admin newAdmin = new Admin(
					admData[0], 
					admData[1], 
			);
			
			this.users.add(newAdmin);
		}
		
		scAdm.close();
		
		File studFile = new File(studentFile);
		
		if(!studFile.exists()) {
			System.out.println("Student file not found, fool");
			return;
		}
		
		String[] studData = new String[6];
		Scanner scStud = new Scanner(studFile);
		scStud.useDelimiter(";|\n");
		
		// Read the attributes row
		scStud.nextLine();
		
		while(scStud.hasNext()) {
			studData[0] = scStud.next(); //idStudent
			studData[1] = scStud.next(); //name
			studData[2] = scStud.next(); //username
			studData[3] = scStud.next(); //password
			studData[4] = scStud.next(); //email
			studData[5] = scStud.next(); //degree
			
			Student newStudent = new Student(
					Integer.parseInt(studData[0].trim()),
					studData[1], 
					studData[4],
					Integer.parseInt(studData[5].trim())
			);
			
			this.users.add(newStudent);
		}
		
		scStud.close();
		Collections.sort(this.users);
		}
	}
	public static void main(String[] args) {
		login()
	}
}

	