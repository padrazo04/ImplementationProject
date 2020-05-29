public void loadUsers(String administratorFile, String studentFile) throws Exception {
	File admindFile = new File(administratorFile);
		
		if(!admindFile.exists()) {
			System.out.println("Administrator file not found, fool");
			return;
		}
		
		String[] admindData = new String[2];
		Scanner scAdmin = new Scanner(admindFile);
		scAdmind.useDelimiter(";|\n");
		
		// Read the attributes row
		scAdmind.nextLine();
		
		while(scAdmind.hasNext()) {
			admindData[0] = scAdmind.next(); //username
			admindData[1] = scAdmind.next(); //password
			
			Administrator newAdministrator = new Administrator(
					admindData[0], 
					admindData[1], 
			);
			
			
			this.users.add(newAdministrator);
		}
		
		scAdmind.close();
		
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
					Integer.parseInt(studData[0].trim())
					studData[1],
					studData[2],
					studData[3],
					studData[4],
					studData[5],
					Integer.parseInt(studData[0].trim())				
			);
			
			
			this.users.add(newStudent);
		}
		
		scStud.close();
		Collections.sort(this.users);
	}