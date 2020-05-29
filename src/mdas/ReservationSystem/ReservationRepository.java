package mdas.ReservationSystem;

import java.util.ArrayList;
import java.util.List;

import mdas.RoomMgr.Room;
import mdas.RoomMgr.RoomManager;

public class ReservationRepository implements IReservationRep{

	private List<Reservation> reservations;
	
	public ReservationRepository() {
		this.reservations = new ArrayList<Reservation>();
	}
	
//	public int tryToMakeReservation(int idStudent);
	
	public int bookRoom(int idStudent, ReservationDetails rd, RoomManager roomMgr) {
		List<Room> rooms = new ArrayList<Room>(roomMgr.getRooms());
		
		for(Room r : rooms) {
			if(r.getCapacity() < rd.numberStudents) {
				rooms.remove(r);
			}
		}
		
		
		
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
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public List<Reservation> getReservationsByStudent(int idStudent) {
		List<Reservation> reservationsOfStudent = new ArrayList<Reservation>();
		
		for(Reservation r : this.reservations) {
			if(r.getBookerStudent() == idStudent) {
				reservationsOfStudent.add(r);
			}
		}
		
		return reservationsOfStudent;
	}
	
	public List<Reservation> getReservationsByRoom(int idRoom) {
		List<Reservation> reservationsOfRoom = new ArrayList<Reservation>();
		
		for(Reservation r : this.reservations) {
			if(r.getRoomReserved() == idRoom) {
				reservationsOfRoom.add(r);
			}
		}
		
		return reservationsOfRoom;
	}
	
}
