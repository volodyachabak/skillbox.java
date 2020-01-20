import java.util.Scanner;

public class Loader {

    private static final int GOOD_LENGTH = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите свое ФИО:");

        String[] fioArray = scanner.nextLine().trim().split("\\s+");

        if (fioArray.length == GOOD_LENGTH){
            System.out.printf("Фамилия: %s\nИмя: %s\nОтчество: %s", fioArray[0], fioArray[1], fioArray[2]);
        } else {
            System.out.println("Неверно введено ФИО!");
        }
    }
}
