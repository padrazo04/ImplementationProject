package mdas.ReservationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import mdas.RoomMgr.Room;
import mdas.RoomMgr.RoomManager;

public class ReservationRepository implements IReservationRep{

	private List<Reservation> reservations;
	
	public ReservationRepository() {
		this.reservations = new ArrayList<Reservation>();
	}
	
//	public int tryToMakeReservation(int idStudent);
	
	public int bookRoom(int idStudent, ReservationDetails rd, RoomManager roomMgr) {
		if(roomMgr.getRooms().isEmpty()) {
			return -1;
		}
		
		List<Room> rooms = new ArrayList<Room>(roomMgr.getRooms());
		ListIterator<Room> iter = rooms.listIterator();
		
		while(iter.hasNext()) {
			if(iter.next().getCapacity() < rd.numberStudents) {
				iter.remove();
			}
		}
		
		if(rooms.isEmpty()) {
			return -1;
		}
			
		iter = rooms.listIterator();
		
		while(iter.hasNext()) {
			for(Reservation rev : this.getReservationsByRoom(iter.next().getId())) {
				if(rev.getDateReservation().equals(rd.dateOfReservation)) {
					iter.remove();
					break;
				}
			}
		}
		
		if(rooms.isEmpty()) {
			return -1;
		}
		
		int roomReserved = rooms.get(0).getId();
		/*
		iter = rooms.listIterator();
		int roomReserved = rooms.get(0).getId();
		int matchedResources = 0;
		
		for(Room r : rooms) {
			int matchedAux = 0;
			for(int i=0; i<r.getResources().size(); i++) {
				for(int j=0; i<rd.resourcesNeeded.size(); j++) {
					if(r.getResources().get(i).trim().equals(rd.resourcesNeeded.get(j).trim())) {
						matchedAux++;
					}
				}
			}
			if(matchedAux > matchedResources) {
				matchedResources = matchedAux;
				roomReserved = r.getId();
			}
		}
		*/
	
		Reservation reservation = new Reservation(
				this.reservations.size(),
				idStudent,
				roomReserved,
				rd.resourcesNeeded,
				rd.numberStudents,
				rd.subject,
				rd.dateOfReservation
		);
		
		this.reservations.add(reservation);
		
		return 0;
	}
	
	public int modifyReservation(int idReservation, int idRoom, ReservationDetails rd) {
		// TODO
		
		return 0;
	}
	
//	public int deleteReservation(int idReservation, int idRoom);
	
//	public int applyForDeletion(int idReservation, int idRoom);
	
//	public void askForConfirmation();

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void addReservation(Reservation r) {
		this.reservations.add(r);
	}
	
	public List<Reservation> getReservationsByStudent(int idStudent) {
		List<Reservation> reservationsOfStudent = new ArrayList<Reservation>();
		
		for(Reservation r : this.getReservations()) {
			if(r.getBookerStudent() == idStudent) {
				reservationsOfStudent.add(r);
			}
		}
		
		return reservationsOfStudent;
	}
	
	public List<Reservation> getReservationsByRoom(int idRoom) {
		List<Reservation> reservationsOfRoom = new ArrayList<Reservation>();
		
		for(Reservation r : this.getReservations()) {
			if(r.getRoomReserved() == idRoom) {
				reservationsOfRoom.add(r);
			}
		}
		
		return reservationsOfRoom;
	}
	
	public void showAllReservations() {
		for (Reservation r : this.getReservations()) {
			System.out.println(r);
		}
	}
	
}
