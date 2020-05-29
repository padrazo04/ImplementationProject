package mdas.ReservationSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationDetails {
	
	public int idStudent;
	
	public List<String> resourcesNeeded;
	
	public int numberStudents;
	
	public String subject;
	
	public Date dateOfReservation;

	public ReservationDetails() {
		this.resourcesNeeded = new ArrayList<String>();
	}
	
	public List<String> getResourcesNeeded() {
		return this.resourcesNeeded;
	}

	public void setResourcesNeeded(List<String> resourcesNeeded) {
		this.resourcesNeeded = resourcesNeeded;
	}
	
	public void addResource(String resource) {
		this.resourcesNeeded.add(resource);
	}

//	public int getNumberStudents() {
//		return this.numberStudents;
//	}
//
//	public void setNumberStudents(int numberStudents) {
//		this.numberStudents = numberStudents;
//	}
//
//	public String getSubject() {
//		return this.subject;
//	}
//
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//
//	public Date getDateOfReservation() {
//		return this.dateOfReservation;
//	}
//
//	public void setDateOfReservation(Date dateOfReservation) {
//		this.dateOfReservation = dateOfReservation;
//	}
}
