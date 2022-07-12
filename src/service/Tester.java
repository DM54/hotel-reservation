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


        ReservationService.addRoom(new Room("100", 90.00, RoomTypeEnumeration.SINGLE));
        ReservationService.addRoom(new Room("101", 100.00, RoomTypeEnumeration.DOUBLE));
       // System.out.println(ReservationService.getARoom("100"));
        //System.out.println(ReservationService.findRooms(new Date(1-1-22),new Date(1-2-22)));
        System.out.println("this is the reservation: " + ReservationService.reserveARoom(
                new Customer("d", "m", "d@email.com"),
                ReservationService.getARoom("101"), new Date(1,2,33), new Date(1,2,45)));

        System.out.println("this is the reservation: " + ReservationService.reserveARoom(
                new Customer("auytyu", "kjoopm", "am@email.com"),
                ReservationService.getARoom("100"), new Date(1,3,3), new Date(1,2,4)));


        //ReservationService.PrintAllReservation();

       System.out.println("this is the customer reservation: " +
                ReservationService.getCustomerReservation(new Customer("d", "m", "d@email.com")));
    }
}
