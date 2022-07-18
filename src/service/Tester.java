package service;

import model.Customer;
import model.Reservation;
import model.Room;
import model.RoomTypeEnumeration;

import java.text.ParseException;
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
        ReservationService.addRoom(new Room("110", 90.00, RoomTypeEnumeration.SINGLE));
        ReservationService.addRoom(new Room("101", 100.00, RoomTypeEnumeration.DOUBLE));
        ReservationService.addRoom(new Room("102", 100.00, RoomTypeEnumeration.DOUBLE));
        ReservationService.addRoom(new Room("100", 90.00, RoomTypeEnumeration.SINGLE));
        //ReservationService.addRoom(new Room("100", 90.00, RoomTypeEnumeration.SINGLE));

        System.out.println("this is the reservation: " + ReservationService.reserveARoom(
                new Customer("aa", "dm", "dm@email.com"),
                ReservationService.getARoom("104"), new Date("3/4/2022"), new Date("3/8/2022")));
       System.out.println("this is the reservation: " + ReservationService.reserveARoom(
                new Customer("a", "m", "am@email.com"),
                ReservationService.getARoom("101"), new Date("3/9/2022"), new Date("3/9/2022")));

            System.out.println(ReservationService.findRooms(new Date("3/4/2022"),new Date("3/8/2022")));



        /*ReservationService.PrintAllReservation();

       System.out.println("this is the customer reservation: " +
                ReservationService.getCustomerReservation(new Customer("d", "m", "d@email.com")));*/
    }
}
