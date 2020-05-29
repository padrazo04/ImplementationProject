package mdas.ReservationSystem;

import mdas.RoomMgr.RoomManager;

public interface IReservationRep {

//	public int tryToMakeReservation(int idStudent);
	
	public int bookRoom(int idStudent, ReservationDetails rd, RoomManager roomMgr);
	
	public int modifyReservation(int idReservation, int idRoom, ReservationDetails rd);
	
//	public int deleteReservation(int idReservation, int idRoom);
	
//	public int applyForDeletion(int idReservation, int idRoom);
	
//	public void askForConfirmation();
}
