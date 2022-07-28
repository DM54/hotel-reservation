import api.AdminResource;
import model.IRoom;
import model.Room;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static model.RoomTypeEnumeration.DOUBLE;
import static model.RoomTypeEnumeration.SINGLE;

public class AdminMenu {
    public static void main(String[] args) {

        admin();
    }
    public static void admin(){
        boolean running = true;
        try {
            Scanner scanner = new Scanner(System.in);

            while(running) {
                try {
                    System.out.println("Please select a number from the menu option");
                    System.out.println("---------------------------------------------");
                    System.out.println("1. See All Customers");
                    System.out.println("2. See All Rooms");
                    System.out.println("3. See All Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");
                    System.out.println("---------------------------------------------");
                    String userInput = scanner.nextLine();

                    switch (userInput) {

                        case "1":
                            System.out.println("All Customers: ");
                            System.out.println(AdminResource.getAllCustomers());
                            break;
                        case "2":
                            System.out.println("All Rooms: ");
                            System.out.println(AdminResource.getAllRooms());
                            break;
                        case "3":
                            System.out.println("All Reservations: ");
                            AdminResource.displayAllReservations();
                            break;
                        case "4":
                            AddRooms(scanner);
                            break;
                        case "5":
                            System.out.println(" Back to Main Menu: ");
                            MainMenu mainMenu = new MainMenu();
                            mainMenu.main();
                            running = false;
                            break;
                        default:
                            System.out.println(" Invalid input, Please choose 1 - 5 ");
                            running = true;
                            break;

                    }

                } catch (Exception exception) {
                    exception.getLocalizedMessage();
                }
            }

        }catch (Exception e){
            e.getLocalizedMessage();
        }
    }


    public static void AddRooms(Scanner scanner) {
        try {

            System.out.println("Please enter a room number, price and single or double");
            System.out.println("Please enter a room number");
            String roomNumber = scanner.nextLine();
            System.out.println("Please enter a price");
            Double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Please enter single or double");
            String rooms = scanner.nextLine();
            List<IRoom> roomsList = new ArrayList<>();
            IRoom room;

            if (rooms.equals("single")) {

                room = new Room(roomNumber, price, SINGLE);
                roomsList.add(room);

            } else if (rooms.equals("double")) {
                room = new Room(roomNumber, price, DOUBLE);
                roomsList.add(room);

            }
            AdminResource.addRoom(roomsList);


        } catch (InputMismatchException exception) {
            System.out.println("Invalid Input!");
            scanner.nextLine();
        }
    }

}