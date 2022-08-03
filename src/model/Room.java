package model;

/**
 * This is Room Class implementing IRoom Interface and its methods
 * @author Dyana Monroy
 */
public class Room implements IRoom{

    private String RoomNumber;
    private Double price;
    private RoomTypeEnumeration enumeration;


    public Room(){}

    public Room(String RoomNumber, Double price, RoomTypeEnumeration enumeration){
        this.RoomNumber = RoomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }


    @Override
    public String getRoomNumber() {
        return RoomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomTypeEnumeration getRoomType() {
        return enumeration;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setEnumeration(RoomTypeEnumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
        return "" + RoomNumber + " Price: $" + price +" price per night " +" Room Type: " + enumeration;
    }

   @Override
   public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }else if(obj.equals(this)){
            return true;
        }
        return getRoomNumber().equals(this.getRoomNumber());
    }
    @Override
    public int hashCode() {
        return (int) RoomNumber.hashCode();
    }
}
