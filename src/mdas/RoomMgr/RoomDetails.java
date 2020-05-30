package mdas.RoomMgr;

import java.util.ArrayList;
import java.util.List;

public class RoomDetails {
	
	public String name;
	
	public int capacity; 
	
	public String location;
	
	public List<String> resources;
	
	public RoomDetails() {
		this.resources = new ArrayList<String>();
	}
	
	public RoomDetails(RoomDetails rd) {
		this.name = rd.name;
		this.capacity = rd.capacity;
		this.location = rd.location;
		this.resources = rd.resources;
	}
	
//	public String getName() {
//		return this.name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public int getCapacity() {
//		return this.capacity;
//	}
//	
//	public void setCapacity(int capacity) {
//		this.capacity = capacity;
//	}
//	
//	public String getLocation() {
//		return this.location;
//	}
//	
//	public void setLocation(String location) {
//		this.name = location;
//	}
	
	public List<String> getResources() {
		return this.resources;
	}
	
	public void setResources(List<String> resources) {
		this.resources = resources;
	}
	
	public void addResource(String resource) {
		this.resources.add(resource);
	}
}
