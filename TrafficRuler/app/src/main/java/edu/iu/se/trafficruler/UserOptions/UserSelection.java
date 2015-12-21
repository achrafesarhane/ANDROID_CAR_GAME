package edu.iu.se.trafficruler.UserOptions;

/**
 * Created by sagar on 11/4/2015.
 */
public class UserSelection {

    public enum VehicleType {Car, Cycle, Bike, Ambulance}

    private static VehicleType vehicleType = VehicleType.Car;

    public static VehicleType getVehicleType() {
        return vehicleType;
    }

    public static void setVehicleType(VehicleType vehicleType) {
        UserSelection.vehicleType = vehicleType;
    }

    public static String getVehicleImageName()
    {
        String imageName = "vehicles.png";

        switch (vehicleType) {
            case Car:
                imageName = "car.png";
                break;
            case Cycle:
                imageName = "bicycle.png";
                break;
            case Bike:
                imageName = "bike.png";
                break;
            case Ambulance:
                imageName = "ambulance.png";
                break;
        }
        return imageName;
    }
}
