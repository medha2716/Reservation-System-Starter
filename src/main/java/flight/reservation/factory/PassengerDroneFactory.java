package flight.reservation.factory;

import flight.reservation.plane.Aircraft;
import flight.reservation.plane.PassengerDrone;

public class PassengerDroneFactory implements AircraftFactory {
    @Override
    public Aircraft createAircraft(String model) {
        return new PassengerDrone(model);
    }
}