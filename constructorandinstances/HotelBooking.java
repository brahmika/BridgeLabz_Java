//This class holds the attributes regarding a Hotel Room and the guest in that room. We use three different types of constructors in this, defualt, parameterised and copy.

public class HotelBooking{
    String guestName;
    String roomType;
    int nights;

    //default constructor
    public HotelBooking(){
        guestName = "Guest";
        roomType = "Suite";
        nights = 1;
    }

    //parameterised constructor
    public HotelBooking(String guestName, String roomType, int nights){
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    //copy constructor
    public HotelBooking(HotelBooking hotel1){
        this.guestName = hotel1.guestName;
        this.roomType = hotel1.roomType;
        this.nights = hotel1.nights;
    }
    public void displayDetails(){
        System.out.println(guestName + roomType + nights);
    }
    public static void main(String[] args){

        //calling the default constructor
        HotelBooking hotela = new HotelBooking();
        hotela.displayDetails();

        //calling the parameterised contructor
        HotelBooking hotelb = new HotelBooking("ABC", "Deulxe", 2);
        hotelb.displayDetails();

        //calling the copy constructor
        HotelBooking hotelc = new HotelBooking(hotela);
        HotelBooking hoteld = new HotelBooking(hotelb);
        hotelc.displayDetails();
        hoteld.displayDetails();

    }
}