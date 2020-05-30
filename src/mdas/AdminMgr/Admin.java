package mdas.AdminMgr;

public class Admin {
	
	private int id;
	
	private String username;
	
	private String password;
	
	public Admin(int id, String username, String password) {
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		String adminInfo = "Username: " + this.getUsername() + "\n";
		adminInfo += "Password: " + this.getPassword() + "\n";
		
		return adminInfo;
	}

}
