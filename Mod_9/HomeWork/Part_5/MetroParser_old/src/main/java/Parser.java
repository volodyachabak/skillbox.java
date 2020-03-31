import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Parser {

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

    private static void parseRows(Elements rows) {
        List<String> stations = new ArrayList<>();
        Set<String> lines = new TreeSet<>();

        String selectStation = "td:nth-of-type(2) a:not(small a)";
        String selectLine = "td:first-child > span:nth-of-type(2)";
        String selectLineNumbers = "td:first-child > span";

        rows.stream().skip(1).forEach((row) -> {

            Elements cols = row.select("td");
            String stationName = cols.get(1).text();
            String lineName = cols.get(0).child(1).attr("title");
            List<String> lineNumbers = cols.get(0).children().eachText();
            List<String> connectionsLineName = cols.get(0).children().eachAttr("title");
            List<String> connectionsNumber = cols.get(3).children().eachText();

            Parser.parseStation(stationName, lineNumbers, connectionsLineName);
            Parser.parseLines(lineName, lineNumbers);
            if (connectionsNumber.size() != 0) Parser.parseConnections(cols, stationName);
//            System.out.println(
//                    row.select(selectLine).attr("title")
//                            + ": " +
//                            row.select(selectStation).text()
//            );
//            stations.add(new Station(row.select(selectStation).text(), new Line(row.select(selectLine).attr("title")), parseConnections(row)));

//            List<String> numbers = row.select(selectLineNumbers).eachAttr("title");
//
//            numbers.forEach(System.out::println);
//            String line = row.select(selectLine).attr("title");
//            lines.add(line.substring(0, line.lastIndexOf(" линия")));
//            stations.add(row.select(selectStation).text());
//            parseConnections(row).forEach(System.out::println);
        });
    }
}
