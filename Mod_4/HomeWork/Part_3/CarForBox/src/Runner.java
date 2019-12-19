import java.util.Scanner;

public class Runner {

    private static final double MAX_BOXES_IN_CONTAINER = 27;
    private static final double MAX_CONTAINERS_ON_CAR = 12;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество ящиков:");

        int allBoxes = scanner.nextInt();
//        int allBoxes = 54;
//        int allBoxes = 325;

        if (allBoxes > 0) {
            int countContainers = (int) Math.ceil(allBoxes / MAX_BOXES_IN_CONTAINER);
            int countCars = (int) Math.ceil(countContainers / MAX_CONTAINERS_ON_CAR);

            int currentContainer = 1;
            int currentCar = 1;

            System.out.println("Грузовик: " + currentCar++);
            System.out.println("\tКонтейнер: " + currentContainer++);

            for (int currentBox = 1; currentBox <= allBoxes; currentBox++) {
                System.out.println("\t\t" + "Ящик " + currentBox);

                if (currentBox != allBoxes) {
                    if (currentBox % (MAX_CONTAINERS_ON_CAR * MAX_BOXES_IN_CONTAINER) == 0) {
                        System.out.println("Грузовик: " + currentCar++);
                    }

                    if(currentBox % MAX_BOXES_IN_CONTAINER == 0){
                        System.out.println("\tКонтейнер: " + currentContainer++);
                    }
                }
            }
            System.err.println("Количество ящиков: " + allBoxes);
            System.err.println("Использовано " + countContainers + " контейнер(а) и " + countCars + " грозовик(а)!");
        } else {
            System.err.println("Введено неверное количество");
        }
    }
}
