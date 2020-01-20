import java.util.Scanner;

public class Loader {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер:");

        String number = scanner.nextLine().trim().replaceAll("\\D+", "");

        System.out.println(number);
    }
}
