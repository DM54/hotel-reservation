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
            IRoom room = new Room(r.getRoomNumber(), r.getRoomPrice(), r.getRoomType());
            ReservationService.addRoom(room);
            addrooms.add(room);
        }

    }

    public static Collection<IRoom> getAllRooms(){

        for (IRoom rooms: addrooms
             ) {
            IRoom room = new Room(rooms.getRoomNumber(), rooms.getRoomPrice(), rooms.getRoomType());
            allrooms.add( ReservationService.getARoom(room.getRoomNumber()));

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
