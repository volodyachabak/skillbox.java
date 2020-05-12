import org.w3c.dom.ls.LSOutput;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        String srcFolder = "/Volumes/HARD/src";
        String dstFolder = "/Volumes/HARD/dst";
        int newWidth = 300;

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();

        int processors = Runtime.getRuntime().availableProcessors();
//        int processors = 1;
        int partSize = files.length / processors;
        int remainder = files.length % processors;

        int beginIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < processors; i++){

            int currentPartSize = (remainder-- > 0)? partSize + 1: partSize;
            endIndex += currentPartSize;

            File[] files1 = new File[currentPartSize];
            System.arraycopy(files, beginIndex, files1, 0, currentPartSize);
            new Thread(new ImageResizer(files1, newWidth, dstFolder, start)).start();

            System.out.printf("BeginIndex = %d; EndIndex = %d; Part = %d; \n", beginIndex, endIndex, currentPartSize);

            beginIndex = endIndex;
        }
    }
}
