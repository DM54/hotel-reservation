package model;

import java.util.Date;

/**
 * This is Reservation Class
 * @author Dyana Monroy
 */
public class Reservation {

    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkOutDate =checkOutDate;
        this.checkInDate = checkInDate;

    }

    @Override
    public String toString() {
        return " Customer" + customer + " Room: " + room + " CheckIn Date: " + checkInDate + " CheckOut Date: " + checkOutDate;
    }
}
