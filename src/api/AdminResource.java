package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class AdminResource {
    static Set<IRoom> allrooms = new HashSet<>();

    public static Customer getCustomer(String Email){
     return CustomerService.getCustomer(Email);

    }

    public static void addRoom(List<IRoom> rooms){
        for (IRoom r: rooms
             ) {
            ReservationService.addRoom(r);
        }
    }

    public static Collection<IRoom> getAllRooms(){
        String id = null;
        allrooms.add(ReservationService.getARoom(id));
     return allrooms;
    }

    public static  Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }

    public static void displayAllReservations(){
     ReservationService.PrintAllReservation();
    }
}
