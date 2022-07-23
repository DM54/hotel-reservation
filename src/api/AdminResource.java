package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class AdminResource {
    static Set<IRoom> allrooms = new HashSet<>();
    static Set<IRoom> addrooms = new HashSet<>();

    public static Customer getCustomer(String Email){
     return CustomerService.getCustomer(Email);

    }

    public static void addRoom(List<IRoom> rooms){
        for (IRoom r: rooms
             ) {
         ReservationService.addRoom(r);
         addrooms.add(r);
        }

    }

    public static Collection<IRoom> getAllRooms(){
        for (IRoom rooms: addrooms
             ) {
            allrooms.add(rooms);
            ReservationService.getARoom(rooms.getRoomNumber());
        }

     return allrooms;
    }

    public static  Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }

    public static void displayAllReservations(){
     ReservationService.PrintAllReservation();
    }
}
