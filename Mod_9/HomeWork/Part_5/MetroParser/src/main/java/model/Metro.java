package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
public class Metro {
    private Map<String, List<String>> stations = new HashMap<>();
    private List<Line> lines = new ArrayList<>();

    public void addLine(Line line){
        if (!lines.contains(line)){
            lines.add(line);
        }
    }

    public void addStation(Station station){
        if (!stations.containsKey(station.getLineId())){
            stations.put(station.getLineId(), new ArrayList<>());
        }
        stations.get(station.getLineId()).add(station.getName());
    }
}
