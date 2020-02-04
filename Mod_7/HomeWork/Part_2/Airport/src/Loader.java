import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR, 2);

        airport.getTerminals()
                .forEach((t)-> t.getFlights()
                        .stream()
                        .filter((f) -> f.getType().equals(Flight.Type.DEPARTURE))
                        .filter((f) -> f.getDate().after(new Date()))
                        .filter((f) -> f.getDate().before(calendar.getTime()))
                        .sorted(Comparator.comparing(Flight::getDate))
                        .forEach(System.out::println));
    }
}
