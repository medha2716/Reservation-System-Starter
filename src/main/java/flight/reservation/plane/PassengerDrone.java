package flight.reservation.plane;

public class PassengerDrone implements Aircraft {
    private final String model;
    private final int crewCapacity = 2;
    private final int passengerCapacity = 2; // Assumed capacity

    public PassengerDrone(String model) {
        if (model.equals("HypaHype")) {
            this.model = model;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public int getCrewCapacity() {
        return crewCapacity;
    }
}

