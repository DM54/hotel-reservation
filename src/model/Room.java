package model;

/**
 * This is Room Class implementing IRoom Interface and its methods
 * @author Dyana Monroy
 */
public class Room implements IRoom{

    private String RoomNumber;
    private Double price;
    private RoomTypeEnumeration enumeration;

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

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
        return "" + RoomNumber + " Price: " + price + " Room Type: " + enumeration;
    }
}
