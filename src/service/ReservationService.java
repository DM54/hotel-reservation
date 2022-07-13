package service;

import model.*;

import java.util.*;

public class ReservationService {

      static Map<String, IRoom> roomMap = new HashMap<String, IRoom>();
      static Set<IRoom> roomSet = new HashSet<IRoom>();
      static Set<Reservation> reservationSet = new HashSet<>();
      static  ArrayList<Reservation> reservationArrayList = new ArrayList<>();
    public static void addRoom(IRoom room){
       roomSet.add(room);
    }

    public static IRoom getARoom(String roomId){
        System.out.println(" From getARoom method: ");
        for (IRoom room1: roomSet
        ) {
            roomMap.put(room1.getRoomNumber(), room1);
        }
          return roomMap.get(roomId);
    }

   public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
          Calendar calendar = Calendar.getInstance();

          Reservation r = new Reservation(customer, room, checkInDate, checkOutDate);

          reservationSet.add(r);

       return r;
    }

    /*public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate ){
       Calendar calendar = Calendar.getInstance();
       String roomid = null;

         if(roomMap.keySet().equals(roomid)) {
             System.out.println(" It is Booked! ");
             calendar.add(Calendar.DATE, 7);
         }
         Customer customer = new Customer(customer.getFirstName(),customer.getLastName(), customer.getEmail());
         Room r = new Room(r.getRoomNumber(), r.getRoomPrice(), r.getRoomType());
         reserveARoom(CustomerService.getCustomer(customer.getEmail()), getARoom(r.getRoomNumber()), checkInDate, checkOutDate);

        return roomMap.values();
    }*/

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
