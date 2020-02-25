import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Loader {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Please input path from folder:");
            File fromDir = new File(scanner.nextLine().trim());

            System.out.println("Please input path to folder:");
            File toDir = new File(scanner.nextLine().trim());

            try {
                copyDirToDir(fromDir, toDir);
            } catch (IOException e) {
                System.err.println("Error");
            }
        }
    }

    private static void copyDirToDir(File src, File dst) throws IOException {
        if(src.isDirectory() && dst.isDirectory()){
            File newDir = new File(dst.getPath() + "/" + src.getName());
            Files.copy(src.toPath(), newDir.toPath());
            File[] srcListFiles = src.listFiles();

            if (srcListFiles != null){
                for (File srcFile : srcListFiles){
                    if (srcFile.isDirectory()){
                        copyDirToDir(srcFile, newDir);
                    } else {
                        Files.copy(srcFile.toPath(), new File(newDir.toPath() + "/" + srcFile.getName()).toPath());
                    }
                }
            }
        } else {
            System.out.println("Bad folder!");
        }
    }
}
