package flight.reservation.factory;

import flight.reservation.plane.Aircraft;
import flight.reservation.plane.Helicopter;

public class HelicopterFactory implements AircraftFactory {
    @Override
    public Aircraft createAircraft(String model) {
        return new Helicopter(model);
    }
}