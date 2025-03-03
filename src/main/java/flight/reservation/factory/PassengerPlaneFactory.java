package flight.reservation.factory;

import flight.reservation.plane.Aircraft;
import flight.reservation.plane.PassengerPlane;

public class PassengerPlaneFactory implements AircraftFactory {
    @Override
    public Aircraft createAircraft(String model) {
        return new PassengerPlane(model);
    }
}

