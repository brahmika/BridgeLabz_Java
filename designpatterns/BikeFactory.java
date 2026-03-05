package designpatterns;

public class BikeFactory extends VehicleFactory {

    @Override
    Car createCar(String type) {
        return null;
    }

    @Override
    Bike createBike(String type) {

        if(type.equalsIgnoreCase("sports")) {
            return new SportsBike();
        }

        if(type.equalsIgnoreCase("normal")) {
            return new NormalBike();
        }

        return null;
    }
}