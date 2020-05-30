package mdas.AdminMgr;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminManager implements IAdminMGT{
	
	private List<Admin> admins;

	public AdminManager() {
		this.admins = new ArrayList<Admin>();
	}
	
	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
	
	public int loadAdmins(String adminFile) throws Exception {
		File adFile = new File(adminFile);
		
		if(!adFile.exists()) {
			System.out.println("Administrator file not found");
			return -1;
		}
		
		String[] adminData = new String[2];
		Scanner scAdmin = new Scanner(adFile);
		scAdmin.useDelimiter(";|\n");
		
		// Read the attributes row
		scAdmin.nextLine();
		
		while(scAdmin.hasNext()) {
			adminData[0] = scAdmin.next(); //username
			adminData[1] = scAdmin.next(); //password
			
			Admin newAdmin = new Admin(
					this.getAdmins().size(),
					adminData[0], 
					adminData[1] 
			);
			
			this.getAdmins().add(newAdmin);
		}
		
		scAdmin.close();
		return 0;
	}
	
	public int login(String usernameAdmin, String passwordAdmin) {
		for(Admin admin : this.getAdmins()) {
			if(admin.getUsername().trim().equals(usernameAdmin.trim()))
				if(admin.getPassword().trim().equals(passwordAdmin.trim()))
					return admin.getId();
		}
		
		return -1;
	}
	
	public void showAdmins() {
		for(Admin admin : this.getAdmins()) {
			System.out.println(admin);
		}
	}
	
}
