package service;

import model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ReservationService {

      private static Map<String, IRoom> roomMap = new HashMap<String, IRoom>();
      private static Set<IRoom> roomSet = new HashSet<IRoom>();
      private static Map<IRoom,Date> reservationMap = new HashMap<>();
      private static Map<IRoom,Date> reservationMap2 = new HashMap<>();
      private static  Set<Reservation> reservationSet = new HashSet<>();
      private static Set<IRoom> roomArraySet = new HashSet<>();

      private static ReservationService Instance;

      private ReservationService(){

      }

      public static synchronized ReservationService getInstance(){
          if(Instance.equals(null)) {
              Instance = new ReservationService();

          }
          return Instance;
      }
    public static void addRoom(IRoom room){
       room = new Room(room.getRoomNumber(),room.getRoomPrice(), room.getRoomType());
       roomSet.add(room);
    }

    public static IRoom getARoom(String roomId){
        for (IRoom room1: roomSet
        ) {
            roomMap.put(room1.getRoomNumber(), room1);
        }
          return roomMap.get(roomId);
    }

      static Reservation r;

     static boolean isreserved = false;
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Calendar calendar = Calendar.getInstance();
        DateFormat datein = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat dateout = new SimpleDateFormat("MM/dd/yyyy");
        String dateIn = datein.format(checkInDate);
        String dateOut = dateout.format(checkOutDate);

        try {
            Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(dateIn);
            Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(dateOut);

            if((!(reservationSet.toString().contains(room.toString()) && reservationSet.toString().contains(date1.toString())
                    && reservationSet.toString().contains(date2.toString())))){

                r = new Reservation(customer,room,date1,date2);
                reservationMap.put(room,date1);
                reservationMap2.put(room,date2);
                reservationSet.add(r);
               // reservation =reserveARoom(r.getCustomer(), r.getRoom(), checkInDate, checkOutDate);
                  System.out.println("Thank you for booking with us!");
                  System.out.println(getCustomerReservation(customer));
                  isreserved = true;
            }
            else {
                System.out.println("Sorry the room is booked, try again.");
            }


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

       return r;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate ){
                 if(isreserved==false) {
                     AvailableRooms(checkInDate, checkOutDate);
                 }else {
                     checkreserved(checkInDate, checkOutDate);
                     recommendRooms(checkInDate, checkOutDate);
                 }

        return roomArraySet;
    }
    static  void checkreserved(Date checkInDate, Date checkOutDate){

            for (IRoom room11 : reservationMap.keySet()) {
                if (!reservationMap.get(room11).equals(checkInDate) && !reservationMap2.get(room11).equals(checkOutDate)) {

                    roomArraySet.add(room11);
                }
            }
            for (IRoom room2 : roomMap.values()) {

                if (!reservationSet.toString().contains(room2.toString())) {

                    roomArraySet.add(room2);
                }
        }


    }

    static void AvailableRooms(Date checkInDate, Date checkOutDate) {

        if(reservationSet.size()==0){
            for (IRoom room: roomSet
                 ) {

                if(!reservationSet.toString().contains(room.toString())){
                    roomArraySet.add(getARoom(room.getRoomNumber()));
                }
            }
        }



    }



   private static void recommendRooms(Date checkInDate, Date checkOutDate){
       Calendar calendar = Calendar.getInstance();
       Calendar calendar1 = Calendar.getInstance();
       DateFormat datein = new SimpleDateFormat("MM/dd/yyyy");
       DateFormat dateout = new SimpleDateFormat("MM/dd/yyyy");
       String dateIn1 = datein.format(checkInDate);
       String dateOut2 = dateout.format(checkOutDate);
       calendar.setTime(checkInDate);
       calendar1.setTime(checkOutDate);

       calendar.add(Calendar.DAY_OF_MONTH, 7);
       calendar1.add(Calendar.DAY_OF_MONTH, 7);
       Date in = calendar.getTime();
       Date out = calendar1.getTime();
       String dateIn = datein.format(in);
       String dateOut = dateout.format(out);

       Date r1 = new Date();
       Date r2 = new Date();
       for (IRoom r: reservationMap.keySet()
       ) {
           r1 = reservationMap.get(r);
           r2 = reservationMap2.get(r);
       }
           if (reservationSet.size() == roomMap.size() && r1.equals(checkInDate)
                   && r2.equals(checkOutDate)) {
               System.out.println("All Rooms are booked!");
               System.out.println("Recommend on: " + dateIn + "-" + dateOut);
               for (IRoom room : reservationMap.keySet()) {
                   if (!reservationMap.get(room).equals(checkInDate) && !reservationMap2.get(room).equals(checkOutDate)) {
                       roomArraySet.add(room);
                   } else {
                       roomArraySet.add(room);
                   }
               }
       }
   }

   public static Collection<Reservation> getCustomerReservation(Customer customer){
       Collection<Reservation> reservationArrayList = new ArrayList<>();
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
