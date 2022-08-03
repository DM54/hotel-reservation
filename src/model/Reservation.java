package model;

import java.util.Date;
import java.util.Objects;

/**
 * This is Reservation Class
 * @author Dyana Monroy
 */
public class Reservation {

    private Customer customer;
   private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;


    public Reservation(){

    }

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkOutDate =checkOutDate;
        this.checkInDate = checkInDate;

    }

    public Customer getCustomer() {

        return customer;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return " Customer" + customer + " Room: " + room + " CheckIn Date: " + checkInDate + " CheckOut Date: " + checkOutDate;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.equals(null)){
            return false;
        }else if(obj.equals(this)){
            return true;
        }
        Customer customer1 = (Customer) obj;
        Room room1 = (Room) obj;
        return customer.equals(customer1.getEmail()) && customer.equals(customer1.getFirstName())
                && customer.equals(customer1.getLastName()) && room.equals(room1.getRoomNumber())
                && room.equals(room1.getRoomPrice()) && room.equals(room1.getRoomType())
                && checkInDate.equals(this.getCheckInDate()) && checkOutDate.equals(this.getCheckOutDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer,room,checkInDate,checkOutDate);
    }
}
