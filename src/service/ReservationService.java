package service;

import model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationService {

      static Map<String, IRoom> roomMap = new HashMap<String, IRoom>();
      static Set<IRoom> roomSet = new HashSet<IRoom>();
      static Set<Reservation> reservationSet = new HashSet<>();
      static  ArrayList<Reservation> reservationArrayList = new ArrayList<>();
      static ArrayList<IRoom> roomArrayList = new ArrayList<>();
    public static void addRoom(IRoom room){
        if(!roomSet.toString().contains(room.getRoomNumber())){
            roomSet.add(room);
        }
       // System.out.println(roomSet);
    }

    public static IRoom getARoom(String roomId){
        System.out.println(" From getARoom method: ");
        for (IRoom room1: roomSet
        ) {
            roomMap.put(room1.getRoomNumber(), room1);
        }
          return roomMap.get(roomId);
    }
    static Reservation r;
   public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
           Calendar calendar = Calendar.getInstance();

       if(!(reservationSet.toString().contains(room.getRoomNumber()) && reservationSet.toString().contains(checkInDate.toString())
          && reservationSet.toString().contains(checkOutDate.toString()))){
               r = new Reservation(customer, room, checkInDate, checkOutDate);
             reservationSet.add(r);
       }
          else {
              System.out.println("Sorry the room is booked, please choose another room");
          }

       return r;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate ){
       Calendar calendar = Calendar.getInstance();

         for (IRoom rooms: roomMap.values()) {
              if(reservationSet.toString().contains(checkInDate.toString())
                 && reservationSet.toString().contains(checkOutDate.toString())
                      && reservationSet.toString().contains(rooms.getRoomNumber())){
                  System.out.println(" Sorry, it is Booked! Please Choose another date. ");
                  //calendar.add(Calendar.DATE, 7);
              }
              else {
                  roomArrayList.add(rooms);
              }
         }

        return roomArrayList;
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer){
        for (Reservation reservation : reservationSet){
              if((reservation.toString().contains(customer.getEmail()) && reservation.toString().contains(customer.getFirstName())
              && reservation.toString().contains(customer.getLastName()))){
                  reservationArrayList.add(reservation);
              }
        }

         return reservationArrayList;
    }

    public static void PrintAllReservation(){
        for (Reservation allreservations: reservationSet
             ) {
            System.out.println(allreservations);
        }
       
    }
      
}
