import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public static List<List<String>> parseFile(String path){
        List<List<String>> rows = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines){
                rows.add(parseRow(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    private static List<String> parseRow(String str) throws Exception {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        boolean found = false;

        for (char s : str.toCharArray()){
            switch (s){
                case ',':
                    if (found){
                        builder.append(s);
                    } else {
                        list.add(builder.toString());
                        builder.setLength(0);
                    }
                    break;
                case '"':
                    found = !found;
                    break;
                default:
                    builder.append(s);
            }
        }
        if (found){
            throw new Exception("Bad row");
        }
        list.add(builder.toString());
        return list;
    }
}
