import core.Line;
import core.Station;

import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static void main(String[] args) {
        StationIndex stationIndex = new StationIndex();
        RouteCalculator calculator;

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

        calculator = new RouteCalculator(stationIndex);
        calculator.getShortestRoute(stationIndex.getStation("Петровская"), stationIndex.getStation("Вокзальная")).forEach(System.out::println);
    }
}
