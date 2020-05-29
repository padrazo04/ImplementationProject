package mdas.StudentMgr;

import java.util.List;

public class StudentManager implements IStudentMGT {
	
	private List<Student> students;
	
//	public int checkPenalties(int idStudent);
	
//	public int createPenalty(int idStudent, int idIncidence);
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public int loadStudents(String studentFile) {
		
		return 0;
	}
}
