package model;

/**
 * This IRoom Interface which later it will be implemented in Room Class
 * @author Dyana Monroy
 */
public interface IRoom {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomTypeEnumeration getRoomType();
    public boolean isFree();
}
