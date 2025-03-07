package flight.reservation.flight;

import flight.reservation.plane.Aircraft;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule {
    private static Schedule instance;
    private List<ScheduledFlight> scheduledFlights;

    private Schedule() {
        scheduledFlights = new ArrayList<>();
    }

    public static Schedule getInstance() {
        if (instance == null) {
            synchronized (Schedule.class) {
                if (instance == null) {
                    instance = new Schedule();
                }
            }
        }
        return instance;
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return scheduledFlights;
    }

    public void scheduleFlight(Flight flight, Date date) {
        ScheduledFlight scheduledFlight = new ScheduledFlight(flight.getNumber(), flight.getDeparture(), flight.getArrival(), (Aircraft) flight.getAircraft(), date);
        scheduledFlights.add(scheduledFlight);
    }

    public void removeFlight(Flight flight) {
        List<ScheduledFlight> tbr = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlights) {
            if (scheduledFlight == flight ||
                    (flight.getArrival() == scheduledFlight.getArrival() &&
                            flight.getDeparture() == scheduledFlight.getDeparture() &&
                            flight.getNumber() == scheduledFlight.getNumber())) {
                tbr.add(scheduledFlight);
            }
        }
        scheduledFlights.removeAll(tbr);
    }

    public void removeScheduledFlight(ScheduledFlight flight) {
        scheduledFlights.remove(flight);
    }

    public ScheduledFlight searchScheduledFlight(int flightNumber) {
        return scheduledFlights.stream()
                .filter(f -> f.getNumber() == flightNumber)
                .findFirst()
                .orElse(null);
    }

    public void clear() {
        scheduledFlights.clear();
    }
}
