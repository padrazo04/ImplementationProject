package mdas.MainMenu;

import java.util.Scanner;

import mdas.RoomMgr.*;

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
		System.out.println("2. Amend study room");
		System.out.println("3. Delete study room");
//		System.out.println("4. Amend Incidence");
//		System.out.println("5. Delete Incidence");
		System.out.println("4. Close application\n");
	}
	
	/**
	 * Print the options of the student menu
	 */
	public void showStudentOptions() {
//		System.out.println("\n1. Make reservation");
//		System.out.println("2. Modify reservation");
//		System.out.println("3. Delete reservation");
		System.out.println("4. Close application\n");
	}
	
	public static void main(String[] args) {
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
						
						System.out.println("Capacity of the room: ");
						rd.capacity = sc.nextInt();
						sc.nextLine();
						
						System.out.print("Location of the room: ");
						rd.location = sc.nextLine();
						
						int moreResources;
						
						do {
							System.out.println("Do you want to add some resources to the room?");
							System.out.println("1. YES");
							System.out.println("0. NO");
							System.out.print("Option: ");
							moreResources = sc.nextInt();
							sc.nextLine();
						} while(moreResources!=1 && moreResources!=0);
						
						while(moreResources!=0) {
							System.out.print("New resource name: ");
							rd.addResource(sc.nextLine());
							
							do {
								System.out.println("Do you want to add one more resource?");
								System.out.println("1. YES");
								System.out.println("0. NO");
								System.out.print("Option: ");
								moreResources = sc.nextInt();
								sc.nextLine();
							} while(moreResources!=1 && moreResources!=0);
						}
						
						roomMgr.registerNewRoom(rd);
						
					} break;
					case 2: { // AMEND STUDY ROOM
					} break;
					case 3: { // DELETE STUDY ROOM
					} break;
					case 4: { // CLOSE APPLICATION
						System.out.println("Bye!");
						sc.close();
					} break;
					default: System.out.println("\nInvalid option"); // INVALID OPTION
				}
			} while (option != 4);
		}
		
		if(option == 2) {
			do {
				menu.showStudentOptions();
				
				System.out.print("Enter option: ");
				option = sc.nextInt();
				sc.nextLine();
				
				switch(option) {
					case 1: { // MAKE RESERVATION
					} break;
					case 2: { // MODIFY RESERVATION
					} break;
					case 3: { // DELETE RESERVATION
					} break;
					case 4: { // CLOSE APPLICATION
						System.out.println("Bye!");
						sc.close();
					} break;
					default: System.out.println("\nInvalid option"); // INVALID OPTION
				}
			} while (option != 4);
		}
	}
}
