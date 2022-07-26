package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HotelResource {
    static Set<Customer> customerSet = new HashSet<>();
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static void createACustomer(String firstName, String lastName, String email){
       // Customer customer = new Customer(firstName,lastName,email);
        //customerSet.add(customer);
        CustomerService.addCustomer(firstName,lastName,email);


    }

    public static IRoom getRoom(String roomNumber){
        return ReservationService.getARoom(roomNumber);
    }

   public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
       return ReservationService.reserveARoom(getCustomer(customerEmail),room,checkInDate,checkOutDate);

    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail){
        return ReservationService.getCustomerReservation(getCustomer(customerEmail));
    }

   public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){

        return ReservationService.findRooms(checkInDate,checkOutDate);

    }

}
