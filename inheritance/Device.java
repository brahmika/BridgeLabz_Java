/*
 Sample Problem 2: Smart Home Devices
 Description: Demonstrates single inheritance where Thermostat extends Device
 Goal: Understand how a subclass adds specific attributes while inheriting common ones
*/

public class Device {
    int deviceId;
    String status;

    // Constructor to initialize device details
    Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display basic device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    // Constructor to initialize thermostat details
    Thermostat(int deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    // Method to display thermostat status
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

class Technology {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat(101, "ON", 24.5);
        thermostat.displayStatus();
    }
}
