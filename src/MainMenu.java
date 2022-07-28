import api.AdminResource;
import api.HotelResource;
import model.Customer;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
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
                                 if(input.equals("q")) {
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

    public static void findReserveARoom(Scanner scanner, Pattern pattern){
        try {
            System.out.println("Please enter a date to CheckIn and CheckOut");
            System.out.println("Please enter a date to CheckIn: in the format mm/dd/yyyy ");
            String checkInDate = scanner.nextLine();
            System.out.println("Please enter a date to CheckOut: in the format mm/dd/yyyy ");
            String checkOutDate = scanner.nextLine();

            System.out.println(HotelResource.findARoom(new Date(checkInDate), new Date(checkOutDate)));

            System.out.println("Do you have an account with us?");
            System.out.println("Please enter y or n");
            char YesorNo = scanner.next().charAt(0);
            scanner.nextLine();
            if (YesorNo == 'n') {
                CreateCustomerAccount(scanner, pattern);
                BookARoom(scanner, pattern);

            } else if (YesorNo == 'y') {
                BookARoom(scanner, pattern);

            }
        }catch (Exception e){
           System.out.println("Invalid Input!");
        }

    }

    public static void CreateCustomerAccount(Scanner scanner, Pattern pattern){
        try {

            System.out.println("Please create an account: ");
            System.out.println("Please enter your email: ");
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

    public static void BookARoom(Scanner scanner, Pattern pattern){
        try{

            System.out.println("You may book a room:");
            System.out.println("Please enter your email: ");
            String customerEmail1 = scanner.nextLine();
            if(!pattern.matcher(customerEmail1).matches()){
                System.out.println("Invalid email, Enter the format: name@domain.com: ");
               customerEmail1 = scanner.nextLine();
            }
            System.out.println("Please enter the room number: ");
            String roomNumber = scanner.nextLine();
            System.out.println("Please enter a date to CheckIn: in the format mm/dd/yyyy ");
            String checkInDate1 = scanner.nextLine();
            System.out.println("Please enter a date to CheckOut: in the format mm/dd/yyyy ");
            String checkOutDate1 = scanner.nextLine();
            HotelResource.bookARoom
                    (customerEmail1, HotelResource.getRoom(roomNumber),new Date(checkInDate1), new Date(checkOutDate1));

        }catch (IllegalArgumentException exception){
            exception.getLocalizedMessage();
        }
    }

    public static void SeeMyReservations(Scanner scanner, Pattern pattern){
        try {
            System.out.println("Enter your email: ");
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



