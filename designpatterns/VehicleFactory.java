package designpatterns;

public abstract class VehicleFactory {

    abstract Car createCar(String type);

    abstract Bike createBike(String type);
}