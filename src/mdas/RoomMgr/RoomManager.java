package mdas.RoomMgr;

import java.util.List;

public class RoomManager implements IRoomMGT{

	private List<Room> rooms;
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public int registerNewRoom(RoomDetails roomDetails) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int amendRoom(int idRoom, RoomDetails roomDetails) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteRoom(int idRoom) {
		// TODO Auto-generated method stub
		return 0;
	}

}
