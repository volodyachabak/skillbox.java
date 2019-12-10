import java.util.Scanner;

public class Runner {

    private static final double maxBoxesInContainer = 27;
    private static final double maxContainersOnCar = 12;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество ящиков:");

        int allBoxes = scanner.nextInt();

        if (allBoxes > 0) {
            int countContainers = (int) Math.ceil(allBoxes / maxBoxesInContainer);
            int countCars = (int) Math.ceil(countContainers / maxContainersOnCar);

            int currentBox = 1;
            int currentContainer = 1;
            int currentCar = 1;

            System.out.println("Грузовик: " + currentCar++);
            System.out.println("\tКонтейнер: " + currentContainer++);

            while (currentBox <= allBoxes){
                System.out.println("\t\t" + "Ящик " + currentBox);

                if(currentBox % maxBoxesInContainer == 0){
                    System.out.println("\tКонтейнер: " + currentContainer++);
                }

                if (currentBox % (maxContainersOnCar * maxBoxesInContainer) == 0) {
                    System.out.println("Грузовик: " + currentCar++);
                }
                currentBox++;
            }

            System.err.println("Количество ящиков: " + allBoxes);
            System.err.println("Использовано " + countContainers + " контейнер(а) и " + countCars + " грозовик(а)!");
        } else {
            System.err.println("Введено неверное количество");
        }

    }
}
