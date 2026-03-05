package designpatterns;

public class FactoryMain {

    public static void main(String[] args) {

        VehicleFactory carFactory = new CarFactory();
        Car car = carFactory.createCar("sedan");
        car.createCar();

        VehicleFactory bikeFactory = new BikeFactory();
        Bike bike = bikeFactory.createBike("sports");
        bike.createBike();
    }
}