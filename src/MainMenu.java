import api.HotelResource;
import model.IRoom;
import model.Room;
import model.RoomTypeEnumeration;

import java.net.http.HttpClient;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("1. Find and Reserve a room");
            System.out.println("2. See my Reservations");
            System.out.println("3. Create an Account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            String userInput = scanner.nextLine();
            String checkInDate = scanner.nextLine();
            String checkOutDate = scanner.nextLine();
            DateFormat datein = new SimpleDateFormat("MM/dd/yyyy");
            DateFormat dateout = new SimpleDateFormat("MM/dd/yyyy");
            String dateIn = datein.format(checkInDate);
            String dateOut = dateout.format(checkOutDate);
            Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(dateIn);
            Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(dateOut);
            String roomNumber = scanner.nextLine();
            String customerEmail = scanner.nextLine();
            String firstName = scanner.nextLine();
            String lastName = scanner.nextLine();
            switch (userInput){
                case "1":
                    System.out.println("Please enter a date to CheckIn and CheckOut");
                    HotelResource.findARoom(date1,date2);
                    HotelResource.bookARoom(customerEmail,HotelResource.getRoom(roomNumber) , date1, date2);
                break;
                case "2": System.out.println("See my Reservations");
                  HotelResource.getCustomerReservations(customerEmail);
                break;
                case "3": System.out.println("Create an Account");
                    HotelResource.createACustomer(customerEmail,firstName,lastName);
                break;
                case "4": System.out.println("Admin");
                      AdminMenu adminMenu = new AdminMenu();
                     // adminMenu();
                break;
                case "5": scanner.close();
                break;
                default: System.out.println("Invalid input, Please choose 1 - 5");
                break;
            }

        }catch (Exception exception){
            exception.getLocalizedMessage();

        }
        finally {
            scanner.close();
        }

    }

}
