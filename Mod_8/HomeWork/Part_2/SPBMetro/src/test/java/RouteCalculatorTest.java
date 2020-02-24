import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    StationIndex stationIndex;
    RouteCalculator calculator;

    @Override
    protected void setUp() throws Exception {
        stationIndex = new StationIndex();
        calculator = new RouteCalculator(stationIndex);

        //Init lines
        Line redLine = new Line(1, "Красная");
        Line blueLine = new Line(2, "Синяя");
        Line yellowLine = new Line(3, "Жолтая");

        stationIndex.addLine(redLine);
        stationIndex.addLine(blueLine);
        stationIndex.addLine(yellowLine);

        //Stations for red line
        List<Station> redLineStations = new ArrayList<Station>(){{
            add(new Station("Петровская", redLine));
            add(new Station("Центральная красная", redLine));
            add(new Station("Арбузная", redLine));
        }};

        //Stations for blue line
        List<Station> blueLineStations = new ArrayList<Station>(){{
            add(new Station("Морковная", blueLine));
            add(new Station("Центральная синяя", blueLine));
            add(new Station("Кловська", blueLine));
            add(new Station("Яблочная", blueLine));
        }};

        //Stations for yellow line
        List<Station> yellowLineStations = new ArrayList<Station>(){{
            add(new Station("Нивки", yellowLine));
            add(new Station("Вокзальная", yellowLine));
        }};

        redLineStations.forEach((s)-> {
            stationIndex.addStation(s);
            redLine.addStation(s);
        });

        blueLineStations.forEach((s)-> {
            stationIndex.addStation(s);
            blueLine.addStation(s);
        });

        yellowLineStations.forEach((s)-> {
            stationIndex.addStation(s);
            yellowLine.addStation(s);
        });

        //Add connection red and blue lines
        stationIndex.addConnection(new ArrayList<Station>() {{
            add(stationIndex.getStation("Центральная красная"));
            add(stationIndex.getStation("Центральная синяя"));
        }});

        //Add connection blue and yellow lines
        stationIndex.addConnection(new ArrayList<Station>() {{
            add(stationIndex.getStation("Кловська"));
            add(stationIndex.getStation("Нивки"));
        }});
    }

    public void testCalculateDurationWithoutConnection(){
        List<Station> route = calculator.getShortestRoute(stationIndex.getStation("Центральная синяя"), stationIndex.getStation("Яблочная"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationWithOneConnection(){
        List<Station> route = calculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Яблочная"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 11;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationWithTwoConnection(){
        List<Station> route = calculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Вокзальная"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testShortestRouteWithoutConnection(){
        List<Station> expectedRoute = new ArrayList<Station>(){{
            add(stationIndex.getStation("Центральная синяя"));
            add(stationIndex.getStation("Кловська"));
            add(stationIndex.getStation("Яблочная"));
        }};
        List<Station> actualRoute = calculator.getShortestRoute(stationIndex.getStation("Центральная синяя"), stationIndex.getStation("Яблочная"));
        assertEquals(expectedRoute, actualRoute);
    }

    public void testShortestRouteWithOneConnection(){
        List<Station> expectedRoute = new ArrayList<Station>(){{
            add(stationIndex.getStation("Петровская"));
            add(stationIndex.getStation("Центральная красная"));
            add(stationIndex.getStation("Центральная синяя"));
            add(stationIndex.getStation("Кловська"));
            add(stationIndex.getStation("Яблочная"));
        }};
        List<Station> actualRoute = calculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Яблочная"));
        assertEquals(expectedRoute, actualRoute);
    }

    public void testShortestRouteWithTwoConnection(){
        List<Station> expectedRoute = new ArrayList<Station>(){{
            add(stationIndex.getStation("Петровская"));
            add(stationIndex.getStation("Центральная красная"));
            add(stationIndex.getStation("Центральная синяя"));
            add(stationIndex.getStation("Кловська"));
            add(stationIndex.getStation("Нивки"));
            add(stationIndex.getStation("Вокзальная"));
        }};
        List<Station> actualRoute = calculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Вокзальная"));
        assertEquals(expectedRoute, actualRoute);
    }

    @Override
    protected void tearDown() throws Exception {
        stationIndex = null;
        calculator = null;
    }
}
