import com.skillbox.airport.Airport;

public class Runner {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        airport.getAllAircrafts().forEach(aircraft -> System.out.println(aircraft));
    }
}
