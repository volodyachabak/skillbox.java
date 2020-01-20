import java.util.Scanner;

public class FIO {

    private static final int START_STRING = 0;
    private static final String POINT = " ";
    private static final int GOOD_LENGHT = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите свое ФИО:");

        String fio = scanner.nextLine().trim() + " ";
        String [] fioArray = new String [GOOD_LENGHT];

        int nextIndex = 0;
        while(!fio.isEmpty()) {
            int indexPoint = fio.indexOf(POINT);
            if (nextIndex < GOOD_LENGHT) {
                fioArray[nextIndex] = fio.substring(START_STRING, indexPoint);
            }
            fio = fio.substring(indexPoint + POINT.length());
            nextIndex++;
        }

        if (nextIndex == 3){
            System.out.printf("Фамилия: %s\nИмя: %s\nОтчество: %s", fioArray[0], fioArray[1], fioArray[2]);
        } else {
            System.out.println("Неверно введено ФИО!");
        }
    }
}
