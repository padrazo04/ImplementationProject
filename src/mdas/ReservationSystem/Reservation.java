	package mdas.ReservationSystem;

import java.util.Date;
import java.util.List;

public class Reservation {
	
	private int id;
	
	private int bookerStudent;
	
	private int roomReserved;
	
	private List<String> resourcesNeeded;
	
	private int numberStudents;
	
	private String subject;
	
	private Date dateReservation;
	
	public Reservation(int id, int bookerStudent, int roomReserved, 
			List<String> resourcesNeeded, int numberStudents, 
			String subject, Date dateReservation) {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookerStudent() {
		return bookerStudent;
	}

	public void setBookerStudent(int bookerStudent) {
		this.bookerStudent = bookerStudent;
	}
	
	public int getRoomReserved() {
		return roomReserved;
	}

	public void setRoomReserved(int roomReserved) {
		this.roomReserved = roomReserved;
	}
	
	public List<String> getResourcesNeeded() {
		return resourcesNeeded;
	}

	public void setResourcesNeeded(List<String> resourcesNeeded) {
		this.resourcesNeeded = resourcesNeeded;
	}

	public int getNumberStudents() {
		return numberStudents;
	}

	public void setNumberStudents(int numberStudents) {
		this.numberStudents = numberStudents;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	
}
