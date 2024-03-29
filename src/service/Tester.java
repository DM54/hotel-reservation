package service;

import model.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Tester {
    public static void main(String [] args){


        /*CustomerService.addCustomer("D", "M", "D@email.com");
        CustomerService.addCustomer("A", "C", "AC@email.com");
       // CustomerService.addCustomer("C", "C", "CCemail");

        System.out.println(CustomerService.getCustomer("D@email.com"));
        System.out.println(CustomerService.getCustomer("AC@email.com"));
        System.out.println(CustomerService.getAllCustomers());*/
        Set<Reservation> reservationSet = new HashSet<>();
        Set<IRoom> roomSet = new HashSet<>();
        ReservationService.addRoom(new Room("104", 90.00, RoomTypeEnumeration.SINGLE));
        ReservationService.addRoom(new Room("110", 90.00, RoomTypeEnumeration.SINGLE));
        ReservationService.addRoom(new Room("101", 100.00, RoomTypeEnumeration.DOUBLE));
        ReservationService.addRoom(new Room("102", 100.00, RoomTypeEnumeration.DOUBLE));
        ReservationService.addRoom(new Room("100", 90.00, RoomTypeEnumeration.SINGLE));
        //ReservationService.addRoom(new Room("120", 0.00, RoomTypeEnumeration.SINGLE));

      //  System.out.println(ReservationService.findRooms(new Date("3/19/2022"),new Date("3/20/2022")));
        /* Reservation reservation;
        reservation =ReservationService.reserveARoom(
                new Customer("g", "t", "gt@email.com"),
                ReservationService.getARoom("102"), new Date("3/19/2022"), new Date("3/20/2022"));

        for (IRoom r:ReservationService.findRooms(new Date("3/19/2022"),new Date("3/20/2022"))
             ) {
                if(reservation.getRoom().equals(r.toString())){
                    roomSet.add(r);
                }
        }*/
       // System.out.println(roomSet);

              // reservationSet.add(reservation);
       ReservationService.reserveARoom(
                new Customer("a", "mm", "m@email.com"),
                ReservationService.getARoom("104"), new Date("3/28/2022"), new Date("3/28/2022"));
        ReservationService.reserveARoom(
                new Customer("aa", "dm", "dm@email.com"),
                ReservationService.getARoom("110"), new Date("3/26/2022"), new Date("3/27/2022"));
      System.out.println(ReservationService.reserveARoom(
                new Customer("a", "m", "am@email.com"),
                ReservationService.getARoom("101"), new Date("3/26/2022"), new Date("3/27/2022")));
       System.out.println( ReservationService.reserveARoom(
                new Customer("e", "l", "el@email.com"),
                ReservationService.getARoom("100"), new Date("3/26/2022"), new Date("3/27/2022")));
       System.out.println(ReservationService.reserveARoom(
                new Customer("g", "t", "gt@email.com"),
                ReservationService.getARoom("102"), new Date("3/26/2022"), new Date("3/27/2022")));

        System.out.println(ReservationService.findRooms(new Date("3/26/2022"),new Date("3/27/2022")));


       /* ReservationService.PrintAllReservation();

       System.out.println("this is the customer reservation: " +
                ReservationService.getCustomerReservation(new Customer("aa", "dm", "dm@email.com")));*/
    }
}
