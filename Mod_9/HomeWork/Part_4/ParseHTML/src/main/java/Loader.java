import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Loader {
    public static void main(String[] args) {
        String rootPath = "data/";
        String url = "http://lenta.ru";

        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("img");

            elements.stream()
                    .filter(e -> e.attr("src").contains("https://"))
                    .forEach(element -> {
                        String src = element.attr("src");
                        downloadImg(rootPath, src);
                    });
            System.out.println("Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadImg(String rootPath, String value){
        try {
            File newDir = new File(rootPath);
            if(!newDir.exists()){
                newDir.mkdir();
            }

            URL url = new URL(value);
            String fileName = value.substring(value.lastIndexOf("/") + 1);
            InputStream in = new BufferedInputStream(url.openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(rootPath + fileName));

            for ( int i; (i = in.read()) != -1; ) {
                out.write(i);
            }
            in.close();
            out.close();
        } catch (Exception e){
            e.getStackTrace();
        }
    }
}
