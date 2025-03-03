package flight.reservation.factory;

public class FactoryProvider {
    public static AircraftFactory getFactory(String factoryType) {
        if (factoryType == null) {
            return null;
        }
        
        if (factoryType.equalsIgnoreCase("PLANE")) {
            return new PassengerPlaneFactory();
        } else if (factoryType.equalsIgnoreCase("HELICOPTER")) {
            return new HelicopterFactory();
        } else if (factoryType.equalsIgnoreCase("DRONE")) {
            return new PassengerDroneFactory();
        }
        
        return null;
    }
}
