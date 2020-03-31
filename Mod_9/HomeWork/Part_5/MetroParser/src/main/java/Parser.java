import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Line;
import model.Metro;
import model.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Parser {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static String dataFile = "src/main/resources/map.json";

    public static void parseURL(String url){
        try {
            Document page = Jsoup.connect(url).get();
            Elements rowElements = page.select("table").get(3).select("tbody > tr");
            createJsonFile(parseRows(rowElements));
            printJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Metro parseRows(Elements rows){
        Metro metro = new Metro();
        String selectStationNameQuery = "td:nth-of-type(2) a:not(small a)";
        String selectLineNameQuery = "td:first-child > span:nth-of-type(2)";
        String selectLineNumberQuery = "td:first-child > span";

        rows.stream().skip(1).forEach((row) -> {
            String lineName = row.select(selectLineNameQuery).attr("title");
            lineName = lineName.substring(0, lineName.lastIndexOf(" линия"));

            String lineId = row.select(selectLineNumberQuery).get(0).text();
            String stationName = row.select(selectStationNameQuery).text();

            metro.addLine(new Line(lineId, lineName));
            metro.addStation(new Station(lineId, stationName));
        });
        return metro;
    }

    private static void createJsonFile(Metro metro) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(dataFile);
        printWriter.write(gson.toJson(metro));
        printWriter.flush();
        printWriter.close();
    }

    private static void printJsonFile(){
        Metro metro = gson.fromJson(readJsonFile(), Metro.class);
        metro.getLines().forEach((line -> {
            System.out.println(line.getName() + " линия содержит " + metro.getStations().get(line.getNumber()).size() + " станций");
        }));
    }
    private static String readJsonFile()
    {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(line -> builder.append(line));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
