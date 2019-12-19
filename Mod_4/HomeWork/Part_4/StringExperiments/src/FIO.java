import java.util.Scanner;

public class FIO {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Введите свое ФИО:");

        String fio = scanner.nextLine().trim();

        String[] fioArray = fio.split("\\s");

        if (fioArray.length == 3){
            System.out.printf("Фамилия: %s\nИмя: %s\nОтчество: %s", fioArray[0], fioArray[1], fioArray[2]);
        } else {
            System.out.println("Неверно введено ФИО!");
        }
    }
}
