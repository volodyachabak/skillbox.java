import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetroParserOLD {

    public void parseURL(String url){
        try {
            Document document = Jsoup.connect(url).get();
            String selectConnectionsStationQuery = "td:nth-of-type(4) > span a";
            Elements rows = document.select("table.standard").first().select("tbody > tr");

            parseRows(rows);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parseRows(Elements rows){
        List<String> stations = new ArrayList<>();
        Set<String> lines = new TreeSet<>();

        String selectStationsQuery = "td:nth-of-type(2) a:not(small a)";
        String selectLineQuery = "td:first-child > span:nth-of-type(2)";

        Elements stationNameElements = rows.select(selectStationsQuery);
        Elements lineNameElements = rows.select(selectLineQuery);
        rows.remove(0);

        rows.forEach((row) -> {
//            System.out.println(
//                    row.select(selectLineQuery).attr("title")
//                            + ": " +
//                            row.select(selectStationsQuery).text()
//            );
//            stations.add(new Station(row.select(selectStationsQuery).text(), new Line(row.select(selectLineQuery).attr("title")), parseConnections(row)));

            String line = row.select(selectLineQuery).attr("title");
            lines.add(line.substring(0, line.lastIndexOf(" линия")));
            stations.add(row.select(selectStationsQuery).text());
            parseConnections(row).forEach(System.out::println);
        });

//        lines.forEach(System.out::println);
//        stations.forEach(System.out::println);

        System.out.println(lineNameElements.size());
        System.out.println(stationNameElements.size());
    }
    private static List<String> parseConnections(Element row){
        List<String> connections = new ArrayList<>();
        Pattern patternNameStation = Pattern.compile("/wiki/\\w+\\(");
        String selectConnectionsStationQuery = "td:nth-of-type(4) > span a";

        Elements elements = row.select(selectConnectionsStationQuery);
        elements.forEach(e -> {
            String href = e.attr("href");
            System.out.println(href);

            String afterTrim = "/wiki/";
            System.out.println(href.substring(afterTrim.length(), href.lastIndexOf("(")));
//            if (matcher.find()) {
//                connections.add(matcher.group());
//            }
        });
        return connections;
    }
}
