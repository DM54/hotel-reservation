import api.AdminResource;
import model.IRoom;
import model.Room;
import model.RoomTypeEnumeration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("1. See All Customers");
            System.out.println("2. See All Rooms");
            System.out.println("3. See All Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main Menu");
            String userInput = scanner.nextLine();
            String roomNumber = scanner.nextLine();
            Double price = scanner.nextDouble();
            RoomTypeEnumeration enumeration = RoomTypeEnumeration.valueOf(scanner.nextLine());
            switch (userInput){

                case "1":   System.out.println("1. See All Customers");
                    AdminResource.getAllCustomers();
                break;
                case "2":  System.out.println("2. See All Rooms");
                    AdminResource.getAllRooms();
                break;
                case "3":  System.out.println("3. See All Reservations");
                    AdminResource.displayAllReservations();
                break;
                case "4": System.out.println("4. Add a Room");
                    List<IRoom> roomsList = new ArrayList<>();
                    IRoom room = new Room(roomNumber,price,enumeration);
                    roomsList.add(room);
                   AdminResource.addRoom(roomsList);
                break;
                case "5":   System.out.println("5. Back to Main Menu");
                   MainMenu mainMenu = new MainMenu();
                      // mainMenu();
                break;
                default: System.out.println("Invalid input, Please choose 1 - 5");
                break;

            }

        }catch (Exception exception){
            exception.getLocalizedMessage();
        }finally {
            scanner.close();
        }


    }
}
