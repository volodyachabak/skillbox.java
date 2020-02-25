import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Loader {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Please input path to folder:");
            String inputPath = scanner.nextLine().trim();

            File file = new File(inputPath);
            if(file.exists()){
                if (file.isDirectory()){
                    long sizeFolder = calculateSizeFolder(file);
                    System.out.println(convertToStringRepresentation(sizeFolder));
                } else {
                    System.out.println("Bad input. This path to file but not to folder!");
                }
            } else {
                System.out.println("Bad path!");
            }
        }
    }

    private static long calculateSizeFolder(File folder){
        long size = 0;
        File[] listFiles = folder.listFiles();
        if (listFiles != null){
            for (File file : listFiles)
                if (file.isDirectory()){
                    size += calculateSizeFolder(file);
                } else {
                    size += file.length();
                }
        }
        return size;
    }

    public static String convertToStringRepresentation(final long value){
        long k = 1024;
        long m = k * k;
        long g = m * k;
        long t = g * k;

        final long[] dividers = new long[] { t, g, m, k, 1 };
        final String[] units = new String[] { "TB", "GB", "MB", "KB", "B" };
        if(value < 1)
            throw new IllegalArgumentException("Invalid file size: " + value);
        String result = null;
        for(int i = 0; i < dividers.length; i++){
            final long divider = dividers[i];
            if(value >= divider){
                result = format(value, divider, units[i]);
                break;
            }
        }
        return result;
    }

    private static String format(final long value,
                                 final long divider,
                                 final String unit){
        final double result =
                divider > 1 ? (double) value / (double) divider : (double) value;
        return new DecimalFormat("#,##0.#").format(result) + " " + unit;
    }
}
