package mdas.MainMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		System.out.println("3. Show all reservations");
//		System.out.println("3. Amend study room");
//		System.out.println("4. Delete study room");
//		System.out.println("5. Amend Incidence");
//		System.out.println("6. Delete Incidence");
		System.out.println("4. Close admin system\n");
	}
	
	/**
	 * Print the options of the student menu
	 */
	public void showStudentOptions() {
		System.out.println("\n1. Make reservation");
		System.out.println("2. See my reservations");
//		System.out.println("3. Modify reservation");
//		System.out.println("4. Delete reservation");
		System.out.println("5. Close student system\n");
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
		//LOADING DATA//
		AdminManager adminMgr = new AdminManager();
		StudentManager studentMgr = new StudentManager();
		try {
			adminMgr.loadAdmins("assets\\admins.csv");
			studentMgr.loadStudents("assets\\students.csv");
		} catch(Exception e) {
			System.out.println("Error loading admin or student file");
		}
		//LOADING DATA//
		//adminMgr.showAdmins();
		//studentMgr.showStudents();
		
		MainMenu menu = new MainMenu();
		RoomManager roomMgr = new RoomManager();
		ReservationRepository reservationRep = new ReservationRepository();
		
		Scanner sc = new Scanner(System.in);
		int optionMenu, optionSubMenu = 0;
		
		menu.showWelcome();
		
		do {
			
			do {
				optionMenu = 0;
				System.out.println("Enter 1 to show the Admin menu");
				System.out.println("Enter 2 to show the Student menu");
				System.out.println("Enter 3 to close the system");
				System.out.print("Option: ");
				optionMenu = sc.nextInt();
				sc.nextLine();
			} while(optionMenu!=1 && optionMenu!=2 && optionMenu!=3);
			
			if(optionMenu == 1) {
				int adminLogged = -1;
				System.out.print("Admin username: ");
				String usernameAdmin = sc.nextLine();
				System.out.print("Admin password: ");
				String passwordAdmin = sc.nextLine();
				
				if((adminLogged = adminMgr.login(usernameAdmin, passwordAdmin)) == -1) {
					System.out.println("Incorrect Data");
				}
				
				while (optionSubMenu != 4 && adminLogged != -1) {
					menu.showAdminOptions();
					
					System.out.print("Enter option: ");
					optionSubMenu = sc.nextInt();
					sc.nextLine();
					
					switch(optionSubMenu) {
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
						case 3: { // SHOW ALL RESERVATIONS
							reservationRep.showAllReservations();
						} break;
						case 4: { // CLOSE APPLICATION
							System.out.println("Bye!");
							//sc.close();
						} break;
						default: System.out.println("\nInvalid option"); // INVALID OPTION
					}
				};
			}
			
			if(optionMenu == 2) {
				int studentLogged = -1;
				System.out.print("Admin username: ");
				String usernameStudent = sc.nextLine();
				System.out.print("Admin password: ");
				String passwordStudent = sc.nextLine();
				
				if((studentLogged = studentMgr.login(usernameStudent, passwordStudent)) == -1) {
					System.out.println("Incorrect Data");
				}
				
				while(optionSubMenu != 5 && studentLogged != -1) {
					menu.showStudentOptions();
					
					System.out.print("Enter option: ");
					optionSubMenu = sc.nextInt();
					sc.nextLine();
										
					switch(optionSubMenu) {
						case 1: { // MAKE RESERVATION
							ReservationDetails rd = new ReservationDetails();
							
							System.out.print("Number of students: ");
							rd.numberStudents= sc.nextInt();
							sc.nextLine();
							
							System.out.print("Subject: ");
							rd.subject = sc.nextLine();

							System.out.println("Date of the reservation: (dd-MM):");
							String dateString = sc.nextLine();
							rd.dateOfReservation = new SimpleDateFormat("dd-MM").parse(dateString);
							
							//rd.resourcesNeeded = menu.addResources("Reservation");
															
							if(reservationRep.bookRoom(studentLogged, rd, roomMgr) == -1) {
								System.out.println("No rooms available");
							}
							
						} break;
						case 2: { // SEE MY RESERVATIONS
							List<Reservation> repStud = reservationRep.getReservationsByStudent(studentLogged);
							
							for(Reservation r : repStud) {
								System.out.println(r);
							}
						} break;
						case 3: { // MODIFY RESERVATION
						} break;
						case 4: { // DELETE RESERVATION
						} break;
						case 5: { // CLOSE APPLICATION
							System.out.println("Bye!");
							//sc.close();
						} break;
						default: System.out.println("\nInvalid option"); // INVALID OPTION
					}
				}
			}
			
		} while(optionMenu!=3);
		
		System.out.println("Bye!");
		sc.close();
	}
}
