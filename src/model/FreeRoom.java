package model;

/**
 * This is FreeRoom Class inheriting from the Room Super Class
 * @author Dyana Monroy
 */
public class FreeRoom extends Room{

    public FreeRoom(String RoomNumber, Double price, RoomTypeEnumeration enumeration){
        super(RoomNumber, price, enumeration);
        price = Double.valueOf(0);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
