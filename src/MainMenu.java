import api.HotelResource;
import model.IRoom;
import model.Room;
import model.RoomTypeEnumeration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

                   switch (scanner.nextLine()){
                       case "1":
                           System.out.println("Please enter a date to CheckIn and CheckOut");
                           System.out.println("Please enter a date to CheckIn: ");
                           String checkInDate = scanner.nextLine();
                           System.out.println("Please enter a date to CheckOut: ");
                           String checkOutDate = scanner.nextLine();
                          /* DateFormat datein = new SimpleDateFormat("MM/dd/yyyy");
                           DateFormat dateout = new SimpleDateFormat("MM/dd/yyyy");
                           String dateIn = datein.format(checkInDate);
                           String dateOut = dateout.format(checkOutDate);
                           Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(dateIn);
                           Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(dateOut);*/


                           System.out.println(HotelResource.findARoom(new Date(checkInDate), new Date(checkOutDate)));

                           System.out.println("Please create an account first: ");
                           System.out.println("Please enter your email, first name and last name. ");
                           System.out.println("Please enter your email: ");
                           String customerEmail = scanner.nextLine();
                           System.out.println("Please enter your first name: ");
                           String firstName = scanner.nextLine();
                           System.out.println("Please enter your last name: ");
                           String lastName = scanner.nextLine();
                           HotelResource.createACustomer(customerEmail, firstName, lastName);
                           System.out.println("Please enter your email, room number and your CheckIn and Checkout dates: ");
                           System.out.println("Please enter your email: ");
                           String customerEmail1 = scanner.nextLine();
                           System.out.println("Please enter the room number: ");
                           String roomNumber = scanner.nextLine();
                           System.out.println("Please enter a date to CheckIn: ");
                           String checkInDate1 = scanner.nextLine();
                           System.out.println("Please enter a date to CheckOut: ");
                           String checkOutDate1 = scanner.nextLine();
                          /* String dateIn1 = datein.format(checkInDate1);
                           String dateOut1 = dateout.format(checkOutDate1);
                           Date date11 = new SimpleDateFormat("MM/dd/yyyy").parse(dateIn1);
                           Date date21 = new SimpleDateFormat("MM/dd/yyyy").parse(dateOut1);*/
                           System.out.println(HotelResource.bookARoom
                                   (customerEmail1, HotelResource.getRoom(roomNumber), new Date(checkInDate1), new Date(checkOutDate1)));
                           break;

                       case "2":

                           System.out.println("Enter your email: ");
                           String customerEmail11 = scanner.nextLine();
                           System.out.println(HotelResource.getCustomerReservations(customerEmail11));

                           break;

                       case "3":

                           System.out.println("Please create an account");
                           System.out.println("Please enter your email: ");
                           String customerEmail12 = scanner.nextLine();
                           System.out.println("Please enter your first name: ");
                           String firstName1 = scanner.nextLine();
                           System.out.println("Please enter your last name: ");
                           String lastName1 = scanner.nextLine();
                           HotelResource.createACustomer(customerEmail12, firstName1, lastName1);

                           break;

                       case "4":
                           System.out.println(" Admin Menu: ");
                           AdminMenu adminMenu = new AdminMenu();
                           adminMenu.admin();

                           break;

                       case "5": scanner.close();
                           break;

                       default:
                           System.out.println(" Invalid input, Please choose 1 - 5 ");
                           running = true;
                           break;

                   }

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
}



