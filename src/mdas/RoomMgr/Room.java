package mdas.RoomMgr;

import java.util.List;

public class Room {
	
	private int id;
	
	private String name;
	
	private int capacity; 
	
	private String location;
	
	private List<String> resources;
	
	public Room(int id, String name, int capacity, String location, List<String> resources) {
		this.setId(id);
		this.setName(name);
		this.setCapacity(capacity);
		this.setLocation(location);
		this.setResources(resources);
	}
	
//	public Room(Room room) {
//		this(room.getId(), room.getName(), room.get)
//	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<String> getResources() {
		return this.resources;
	}
	
	public void setResources(List<String> resources) {
		this.resources = resources;
	}
	
	public String toString() {
		String infoRoom = "ID: " + this.getId() + "\n";
		infoRoom += "Name: " + this.getName() + "\n";
		infoRoom += "Capacity: " + this.getCapacity() + "\n";
		infoRoom += "Location: " + this.getLocation() + "\n";
		infoRoom += "Resources: " + this.getResources() + "\n";
		
		return infoRoom;
	}
}
