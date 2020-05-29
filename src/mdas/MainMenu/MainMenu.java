package mdas.MainMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import mdas.ReservationSystem.*;
import mdas.RoomMgr.*;
import mdas.AdminMgr.*;
import mdas.StudentMgr.*;

public class MainMenu {
	
	/**
	 * Print a unique message when the user enters in the application
	 */
	public void showWelcome() {
		System.out.println("=========================================");
		System.out.println("WELCOME TO THE BOOKING SYSTEM APPLICATION");
		System.out.println("=========================================");
	}
	
	/**
	 * Print the options of the administrator menu
	 */
	public void showAdminOptions() {
		System.out.println("\n1. Register new study room");
		System.out.println("2. Show all rooms");
//		System.out.println("3. Amend study room");
//		System.out.println("4. Delete study room");
//		System.out.println("5. Amend Incidence");
//		System.out.println("6. Delete Incidence");
		System.out.println("3. Close application\n");
	}
	
	/**
	 * Print the options of the student menu
	 */
	public void showStudentOptions() {
		System.out.println("\n1. Make reservation");
		System.out.println("\n2. See my reservations");
//		System.out.println("3. Modify reservation");
//		System.out.println("4. Delete reservation");
		System.out.println("5. Close application\n");
	}
	
	public List<String> addResources(String owner) {
		List<String> resources = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		int moreResources;
		
		do {
			System.out.println("Do you want to add some resources to the " + owner + "?");
			System.out.println("1. YES");
			System.out.println("0. NO");
			System.out.print("Option: ");
			moreResources = sc.nextInt();
			sc.nextLine();
		} while(moreResources!=1 && moreResources!=0);
		
		while(moreResources!=0) {
			System.out.print("New resource name: ");
			resources.add(sc.nextLine());
			
			do {
				System.out.println("Do you want to add one more resource?");
				System.out.println("1. YES");
				System.out.println("0. NO");
				System.out.print("Option: ");
				moreResources = sc.nextInt();
				sc.nextLine();
			} while(moreResources!=1 && moreResources!=0);
		}
		
		return resources;
	}
	
	public static void main(String[] args) throws ParseException {
		MainMenu menu = new MainMenu();
		RoomManager roomMgr = new RoomManager();
		
		Scanner sc = new Scanner(System.in);
		int option;
		
		menu.showWelcome();
		
		///////////////
		//TODO: LOGIN//
		///////////////
		
		do {
			System.out.println("Enter 1 to show the Admin menu");
			System.out.println("Enter 2 to show the Student menu");
			System.out.print("Option: ");
			option = sc.nextInt();
			sc.nextLine();
		} while(option!=1 && option!=2);
		
		///////////////
		
		if(option == 1) {
			do {
				menu.showAdminOptions();
				
				System.out.print("Enter option: ");
				option = sc.nextInt();
				sc.nextLine();
				
				switch(option) {
					case 1: { // REGISTER NEW STUDY ROOM
						RoomDetails rd = new RoomDetails();
						
						System.out.print("Name of the room: ");
						rd.name = sc.nextLine();
						
						System.out.print("Capacity of the room: ");
						rd.capacity = sc.nextInt();
						sc.nextLine();
						
						System.out.print("Location of the room: ");
						rd.location = sc.nextLine();
						
						rd.resources = menu.addResources("Room");
						
						roomMgr.registerNewRoom(rd);
						
					} break;
					case 2: { // SHOW ALL ROOMS
						roomMgr.showAllRooms();
					} break;
					case 3: { // CLOSE APPLICATION
						System.out.println("Bye!");
						sc.close();
					} break;
					default: System.out.println("\nInvalid option"); // INVALID OPTION
				}
			} while (option != 3);
		}
		
		if(option == 2) {
			do {
				menu.showStudentOptions();
				ReservationRepository reservationRep = new ReservationRepository();
				
				System.out.print("Enter option: ");
				option = sc.nextInt();
				sc.nextLine();
				
				switch(option) {
					case 1: { // MAKE RESERVATION
						ReservationDetails rd = new ReservationDetails();
						
						System.out.print("Number of students: ");
						rd.numberStudents= sc.nextInt();
						sc.nextLine();
						
						System.out.print("Subject: ");
						rd.subject = sc.nextLine();
						
						//System.out.println("Date of the reservation: (dd-MM-yyyy--HH:mm):");
						System.out.println("Date of the reservation: (dd-MM-yyyy):");
						String dateString = sc.nextLine();
						//rd.dateOfReservation = new SimpleDateFormat("dd-MM-yyyy--HH:mm").parse(dateString); //THROWS EXCEPTION
						rd.dateOfReservation = new SimpleDateFormat("dd-MM-yyyy").parse(dateString); //THROWS EXCEPTION
						
						rd.resourcesNeeded = menu.addResources("Reservation");
												
						System.out.println("Number of students: " + rd.numberStudents);
						System.out.println("Subject: " + rd.subject);
						System.out.println("Date String: " + dateString);
						System.out.println("Date of Reservation: " + rd.dateOfReservation);
						System.out.println("Resources needed: " + rd.resourcesNeeded);
						
						reservationRep.bookRoom(1, rd, roomMgr);
						
					} break;
					case 2: { // SEE ALL RESERVATIONS
						reservationRep.getReservationsByStudent(1);
					} break;
					case 3: { // MODIFY RESERVATION
					} break;
					case 4: { // DELETE RESERVATION
					} break;
					case 5: { // CLOSE APPLICATION
						System.out.println("Bye!");
						sc.close();
					} break;
					default: System.out.println("\nInvalid option"); // INVALID OPTION
				}
			} while (option != 5);
		}
	}
}
