package designpatterns;

public class CarFactory extends VehicleFactory {

    @Override
    Car createCar(String type) {

        if(type.equalsIgnoreCase("sedan")) {
            return new Sedan();
        }

        if(type.equalsIgnoreCase("suv")) {
            return new SUV();
        }

        return null;
    }

    @Override
    Bike createBike(String type) {
        return null;
    }
}
