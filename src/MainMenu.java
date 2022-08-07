
import api.AdminResource;
import api.HotelResource;
import model.IRoom;
import model.Reservation;


import java.util.*;
import java.util.regex.Pattern;

public class MainMenu {

    public static void main(String[] args) {
        main();
    }


    public static void main() {


        try {
            boolean running = true;
            Scanner scanner = new Scanner(System.in);
            String emailregex = "^(.+)@(.+).(.+)$";
            Pattern pattern = Pattern.compile(emailregex);
              while (running){
                try {
                    System.out.println("Welcome to Hotel Reservation");
                    System.out.println("Please select a number from the menu option");
                    System.out.println("---------------------------------------------");
                    System.out.println("1. Find and Reserve a room");
                    System.out.println("2. See my Reservations");
                    System.out.println("3. Create an Account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("---------------------------------------------");
                    String userInput = scanner.nextLine();

                    switch (userInput) {
                            case "1":
                                findReserveARoom(scanner, pattern);
                                break;

                            case "2":
                                SeeMyReservations(scanner, pattern);
                                break;

                            case "3":
                                CreateCustomerAccount(scanner, pattern);
                                break;

                            case "4":
                                System.out.println(" Admin Menu: ");
                                AdminMenu adminMenu = new AdminMenu();
                                adminMenu.admin();
                                running = false;
                                break;
                            case "5":  System.out.println("Please enter q to exit");
                                 String input = scanner.nextLine();
                                 if(input.equalsIgnoreCase("q")) {
                                     System.out.println("Thank you, Goodbye!");
                                     scanner.close();
                                }
                                running = false;
                                break;
                            default:
                                System.out.println(" Invalid input, Please choose from 1-5");
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

    private static Set<IRoom>  iRooms = new HashSet<>();
    private static Set<IRoom> getiRooms = new HashSet<IRoom>();

     static boolean isreserved = false;

    static void Booked(Scanner scanner, String customerEmail1, String checkInDate, String checkOutDate){
        System.out.println("Please enter a Room Number");
        String roomNumber = scanner.nextLine();
        HotelResource.bookARoom
                (customerEmail1, HotelResource.getRoom(roomNumber), new Date(checkInDate), new Date(checkOutDate));
        for (IRoom room : AdminResource.getAllRooms()
        ) {
            if (!room.getRoomNumber().equals(roomNumber)) {
                getiRooms.add(room);
            }
        }
    }
    public static void findReserveARoom(Scanner scanner, Pattern pattern){
        try {

            System.out.println("Do you have an account with us?");
            System.out.println("Yes Or No -> y or n");
            char YesorNo = scanner.next().charAt(0);
            scanner.nextLine();
            if(YesorNo=='n') {
                CreateCustomerAccount(scanner, pattern);
                System.out.println("Please enter your email: eg. name@domain.com ");
                String customerEmail1 = scanner.nextLine();
                if (!pattern.matcher(customerEmail1).matches()) {
                    System.out.println("Invalid email, Enter the format: name@domain.com: ");
                    customerEmail1 = scanner.nextLine();
                }
                System.out.println("Please enter a date to CheckIn and CheckOut");
                System.out.println("Please enter a date to CheckIn: in the format mm/dd/yyyy ");
                String checkInDate = scanner.nextLine();
                System.out.println("Please enter a date to CheckOut: in the format mm/dd/yyyy ");
                String checkOutDate = scanner.nextLine();

                System.out.println("You may book a room:");
                HotelResource.findARoom(new Date(checkInDate), new Date(checkOutDate));
                System.out.println("The list of Rooms:");
                System.out.println(AdminResource.getAllRooms());
                System.out.println("Available Rooms:");
                System.out.println(getiRooms);
                System.out.println("Do you want to book with us?");
                System.out.println("Yes Or No -> y or n");
               char YON = scanner.next().charAt(0);
               scanner.nextLine();
               if(YON=='y') {
                   Booked(scanner,customerEmail1,checkInDate,checkOutDate);
               } else if (YON=='n') {
                    
                }
           }
            else if (YesorNo=='y') {
                System.out.println("Please enter your email: eg. name@domain.com ");
                String customerEmail1 = scanner.nextLine();
                if (!pattern.matcher(customerEmail1).matches()) {
                    System.out.println("Invalid email, Enter the format: name@domain.com: ");
                    customerEmail1 = scanner.nextLine();
                }
                System.out.println("Please enter a date to CheckIn and CheckOut");
                System.out.println("Please enter a date to CheckIn: in the format mm/dd/yyyy ");
                String checkInDate = scanner.nextLine();
                System.out.println("Please enter a date to CheckOut: in the format mm/dd/yyyy ");
                String checkOutDate = scanner.nextLine();

                System.out.println("You may book a room:");
                HotelResource.findARoom(new Date(checkInDate), new Date(checkOutDate));
                System.out.println("The list of Rooms:");
                System.out.println(AdminResource.getAllRooms());
                System.out.println("Available Rooms:");
                System.out.println(getiRooms);
                System.out.println("Do you want to book with us?");
                System.out.println("Yes Or No -> y or n");
                char YON = scanner.next().charAt(0);
                scanner.nextLine();
                if(YON=='y') {
                    Booked(scanner,customerEmail1,checkInDate,checkOutDate);
                } else if (YON=='n') {
                    
                }

            }
        }

        catch (Exception e){
           System.out.println("Invalid Input!");
        }

    }

    public static void CreateCustomerAccount(Scanner scanner, Pattern pattern){
        try {

            System.out.println("Please create an account: ");
            System.out.println("Please enter your email: eg. name@domain.com ");
            String customerEmail = scanner.nextLine();
            if(!pattern.matcher(customerEmail).matches()){
                System.out.println("Invalid email, Enter the format: name@domain.com: ");
                customerEmail = scanner.nextLine();
            }
                System.out.println("Please enter your first name: ");
                String firstName = scanner.nextLine();
                System.out.println("Please enter your last name: ");
                String lastName = scanner.nextLine();
                HotelResource.createACustomer(firstName, lastName, customerEmail);
                System.out.println("Thank you for signing up!");

        }catch (IllegalArgumentException e){
            e.getLocalizedMessage();
        }
    }



    public static void SeeMyReservations(Scanner scanner, Pattern pattern){
        try {
            System.out.println("Enter your email: eg. name@domain.com ");
            String customerEmail11 = scanner.nextLine();
            if (!pattern.matcher(customerEmail11).matches()) {
                System.out.println("Invalid email, Enter the format: name@domain.com: ");
                customerEmail11 = scanner.nextLine();
            }
            System.out.println(HotelResource.getCustomerReservations(customerEmail11));
        }catch (IllegalArgumentException e){
            e.getLocalizedMessage();
        }
    }

}



