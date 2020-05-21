package mdas.RoomMgr;

import java.util.Date;

public class IncidenceDetails {
	
	private int student;
	
	private String description;
	
	private Date timeOfIncidence;
	
	private boolean status;

	public int getStudent() {
		return this.student;
	}

	public void setStudent(int student) {
		this.student = student;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimeOfIncidence() {
		return this.timeOfIncidence;
	}

	public void setTimeOfIncidence(Date timeOfIncidence) {
		this.timeOfIncidence = timeOfIncidence;
	}

	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
