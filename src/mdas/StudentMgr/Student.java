package mdas.StudentMgr;

public class Student {
	
	private int id;
	
	private String name;
	
	private String username;
	
	private String email; 
	
	private String password;
	
	private String degree;
	
	public Student(int id, String name, String username, String email, String password, String degree) {
		this.setId(id);
		this.setName(name);
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
		this.setDegree(degree);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String toString() {
		String studentInfo = "Username: " + this.getUsername() + "\n";
		studentInfo += "Password: " + this.getPassword() + "\n";
		
		return studentInfo;
	}

}
