package service;

import model.Customer;
import model.Reservation;
import model.Room;
import model.RoomTypeEnumeration;

import java.util.Date;

public class Tester {
    public static void main(String [] args){


        /*CustomerService.addCustomer("D", "M", "D@email.com");
        CustomerService.addCustomer("A", "C", "AC@email.com");
       // CustomerService.addCustomer("C", "C", "CCemail");

        System.out.println(CustomerService.getCustomer("D@email.com"));
        System.out.println(CustomerService.getCustomer("AC@email.com"));
        System.out.println(CustomerService.getAllCustomers());*/


        ReservationService.addRoom(new Room("104", 90.00, RoomTypeEnumeration.SINGLE));
        ReservationService.addRoom(new Room("101", 100.00, RoomTypeEnumeration.DOUBLE));
        ReservationService.addRoom(new Room("102", 100.00, RoomTypeEnumeration.DOUBLE));
        ReservationService.addRoom(new Room("103", 90.00, RoomTypeEnumeration.SINGLE));


        System.out.println("this is the reservation: " + ReservationService.reserveARoom(
                new Customer("d", "m", "d@email.com"),
                ReservationService.getARoom("104"), new Date(22,2,5), new Date(22,2,6)));

        System.out.println("this is the reservation: " + ReservationService.reserveARoom(
                new Customer("a", "m", "am@email.com"),
                ReservationService.getARoom("103"), new Date(22,2,3), new Date(22,2,4)));

        System.out.println(ReservationService.findRooms(new Date(22,2,3),new Date(22,2,6)));
        /*ReservationService.PrintAllReservation();

       System.out.println("this is the customer reservation: " +
                ReservationService.getCustomerReservation(new Customer("d", "m", "d@email.com")));*/
    }
}
