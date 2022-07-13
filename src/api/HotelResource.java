package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName){
        CustomerService.addCustomer(firstName,lastName,email);
    }

    public static IRoom getRoom(String roomNumber){
        return ReservationService.getARoom(roomNumber);
    }

   /* public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
       // return ReservationService.reserveARoom(customerEmail,room,checkInDate,checkOutDate);

    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail){
        //return ReservationService.getCustomerReservation(customerEmail);
    }*/

    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return ReservationService.findRooms(checkInDate,checkOutDate);
    }

}
