package mdas.RoomMgr;

import java.util.ArrayList;
import java.util.List;

public class RoomManager implements IRoomMGT{

	private List<Room> rooms;
	
	public RoomManager() {
		this.rooms = new ArrayList<Room>();
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public int registerNewRoom(RoomDetails roomDetails) {
		Room room = new Room(this.rooms.size(), roomDetails.name, roomDetails.capacity, roomDetails.location, roomDetails.resources);
		
		this.rooms.add(room);
		
		return 0;
	}

	public void showAllRooms() {
		for(Room room : this.rooms) {
			System.out.println(room);
		}
	}

}
