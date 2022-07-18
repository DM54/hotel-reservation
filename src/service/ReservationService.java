package service;

import model.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ReservationService {

      static Map<String, IRoom> roomMap = new HashMap<String, IRoom>();
      static Set<IRoom> roomSet = new HashSet<IRoom>();
      static Set<Reservation> reservationSet = new HashSet<>();
      static  ArrayList<Reservation> reservationArrayList = new ArrayList<>();
      static ArrayList<IRoom> roomArrayList = new ArrayList<>();
    public static void addRoom(IRoom room){
       room = new Room(room.getRoomNumber(),room.getRoomPrice(), room.getRoomType());
       roomSet.add(room);

    }

    public static IRoom getARoom(String roomId){
        System.out.println(" From getARoom method: ");
        for (IRoom room1: roomSet
        ) {
            roomMap.put(room1.getRoomNumber(), room1);
        }
        //System.out.println(roomMap);
          return roomMap.get(roomId);
    }

    static Reservation r;
   public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
          Calendar calendar = Calendar.getInstance();


       if(!(reservationSet.toString().contains(room.toString()) && reservationSet.toString().contains(checkInDate.toString())
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

        /*calendar.add(Calendar.DAY_OF_MONTH, 7);
        calendar1.add(Calendar.DAY_OF_MONTH, 7);
        Date datein = calendar.getTime();
        Date dateout = calendar1.getTime();*/

        boolean isEmpty = reservationSet.isEmpty();
       for (IRoom rooms: roomMap.values())
       {
        if (isEmpty) {
            roomArrayList.add(rooms);
        }

        else if ((reservationSet.toString().contains(rooms.toString())
                && reservationSet.toString().contains(checkInDate.toString()) && reservationSet.toString().contains(checkOutDate.toString())
        )) {
            //System.out.println(reservationSet);
            //System.out.println("Sorry, all rooms are booked in the date you chosen.");
                 /* if((reservationSet.size() == roomMap.size() && reservationSet.toString().contains(checkInDate.toString())
                          && reservationSet.toString().contains(checkOutDate.toString()) )){
                      //System.out.println("Recommend Search on: " + datein + "-" + dateout);
                      //roomMap.get(rooms.getRoomNumber());
                  }*/

        } else if (!(reservationSet.toString().contains(rooms.toString()) && reservationSet.toString().contains(checkInDate.toString()) &&
                reservationSet.toString().contains(checkOutDate.toString()))) {
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
