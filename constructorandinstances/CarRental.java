//This class stores the attributes such as the customer name, model of car and the rental days.

public class CarRental{
    String customerName;
    String carModel;
    int rentalDays;
    int costPerDay = 300;

    public CarRental(){
        this.customerName = "customer";
        this.carModel = "Honda Jazz";
        this.rentalDays = 1;
    }
    //Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays){
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    //Method to find the total cost
    public int calculatePrice(){
        int totalCost = costPerDay * rentalDays;
        return totalCost;
    }
    //Method to display the details
    public void displayDetails(){
        System.out.println(customerName);
        System.out.println(carModel);
        System.out.println(rentalDays);
        System.out.println(calculatePrice());
    }

    public static void main(String[] args){
        CarRental car1 = new CarRental();
        car1.displayDetails();

        CarRental car2 = new CarRental("Bob", "GoodCar",3);
        car2.displayDetails();

    }
}