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
        boolean running = true;
        try {
            Scanner scanner = new Scanner(System.in);


            while(running) {
                try {
                    System.out.println("1. Find and Reserve a room");
                    System.out.println("2. See my Reservations");
                    System.out.println("3. Create an Account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                   while (scanner.hasNextLine()) {
                        switch (scanner.nextLine()) {
                            case "1":
                                findReserveARoom(scanner);
                               //running = true;
                                break;

                            case "2":
                                SeeMyReservations(scanner);
                                //running = false;
                                break;

                            case "3":
                                CreateCustomerAccount(scanner);
                                // running = true;
                                break;

                            case "4":
                                System.out.println(" Admin Menu: ");
                                AdminMenu adminMenu = new AdminMenu();
                                adminMenu.admin();

                                break;

                            case "5":
                                exit(scanner);
                                break;

                            default:
                                System.out.println(" Invalid input, Please choose from 1-5");
                                running = true;
                                break;

                        }
                   }
                    scanner.close();

                } catch (Exception exception) {
                    exception.getLocalizedMessage();

                }finally {
                    scanner.close();
                }
            }
        }catch (Exception e){
            e.getLocalizedMessage();
        }

    }

    public static void findReserveARoom(Scanner scanner){
        System.out.println("Please enter a date to CheckIn and CheckOut");
        System.out.println("Please enter a date to CheckIn: ");
        String checkInDate = scanner.nextLine();
        System.out.println("Please enter a date to CheckOut: ");
        String checkOutDate = scanner.nextLine();

        System.out.println(HotelResource.findARoom(new Date(checkInDate), new Date(checkOutDate)));

        System.out.println("Do you have an account with us?");
        System.out.println("Yes Or No -> y or n");
        char YesorNo = scanner.next().charAt(0);
        scanner.nextLine();
        if(YesorNo=='n') {
            CreateCustomerAccount(scanner);
            BookARoom(scanner);


        } else if (YesorNo=='y') {
            BookARoom(scanner);

        }

    }

    public static void CreateCustomerAccount(Scanner scanner){
        try {
            String emailregex = "^(.+)@(.+).(.+)$";
            Pattern pattern = Pattern.compile(emailregex);
            System.out.println("Please create an account: ");

            System.out.println("Please enter your email: ");
            String customerEmail = scanner.nextLine();
            if(!pattern.matcher(customerEmail).matches()){
                System.out.println("Invalid email, Enter the format: name@domain.com: ");
                scanner.nextLine();
               // running = true;

            }
                System.out.println("Please enter your first name: ");
                String firstName = scanner.nextLine();
                System.out.println("Please enter your last name: ");
                String lastName = scanner.nextLine();
                //Customer c1 = new Customer(firstName, lastName, customerEmail);
                HotelResource.createACustomer(firstName, lastName, customerEmail);
                //running = true;


        }catch (IllegalArgumentException e){
            e.getLocalizedMessage();
        }
    }

    public static void BookARoom(Scanner scanner){
        try{
            String emailregex = "^(.+)@(.+).(.+)$";
            Pattern pattern = Pattern.compile(emailregex);

            System.out.println("You may book a room:");
            System.out.println("Please enter your email: ");
            String customerEmail1 = scanner.nextLine();
            if(!pattern.matcher(customerEmail1).matches()){
                System.out.println("Invalid email, Enter the format: name@domain.com: ");
               customerEmail1 = scanner.nextLine();
            }
            System.out.println("Please enter the room number: ");
            String roomNumber = scanner.nextLine();
            System.out.println("Please enter a date to CheckIn: ");
            String checkInDate1 = scanner.nextLine();
            System.out.println("Please enter a date to CheckOut: ");
            String checkOutDate1 = scanner.nextLine();
            System.out.println(HotelResource.bookARoom
                    (customerEmail1, HotelResource.getRoom(roomNumber),new Date(checkInDate1), new Date(checkOutDate1)));

        }catch (IllegalArgumentException exception){
            exception.getLocalizedMessage();
        }
    }

    public static void SeeMyReservations(Scanner scanner){
        try {
            String emailregex = "^(.+)@(.+).(.+)$";
            Pattern pattern = Pattern.compile(emailregex);
            System.out.println("Enter your email: ");
            String customerEmail11 = scanner.nextLine();
            if (!pattern.matcher(customerEmail11).matches()) {
                System.out.println("Invalid email, Enter the format: name@domain.com: ");
                scanner.nextLine();
                //running = true;
            }
            System.out.println(HotelResource.getCustomerReservations(customerEmail11));
        }catch (InputMismatchException e){
            e.getLocalizedMessage();
        }
    }

    public static void exit(Scanner scanner){
        try {
            System.out.println("Do you want to exit?");
            System.out.println("Yes Or No -> y or n");
            String YesOrNo = scanner.next();
            scanner.nextLine();
            if(YesOrNo.equals("y")){
                scanner.close();
            }else if(YesOrNo.equals("n")){

            }
        }catch (InputMismatchException e){
            e.getLocalizedMessage();
        }

}
}



