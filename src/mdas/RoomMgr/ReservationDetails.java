package mdas.RoomMgr;

import java.util.Date;

public class ReservationDetails {
	
	private String resourcesNeeded;
	
	private int numberOfStudents;
	
	private String subject;
	
	private Date dateOfReservation;

	public String getResourcesNeeded() {
		return this.resourcesNeeded;
	}

	public void setResourcesNeeded(String resourcesNeeded) {
		this.resourcesNeeded = resourcesNeeded;
	}

	public int getNumberOfStudents() {
		return this.numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getDateOfReservation() {
		return this.dateOfReservation;
	}

	public void setDateOfReservation(Date dateOfReservation) {
		this.dateOfReservation = dateOfReservation;
	}
}
