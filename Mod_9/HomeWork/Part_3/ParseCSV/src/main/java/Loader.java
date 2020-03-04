import java.io.IOException;
import java.util.Map;

public class Loader {

    public static void main(String[] args) throws IOException {

        String path = "data/movementList.csv";
        TransactionManager transactionManager = new TransactionManager(TransactionManager.parseCSV(CSVParser.parseFile(path)));
        System.out.printf("Общий доход: %.2f \n", transactionManager.getAllComing());
        System.out.printf("Общий расход: %.2f \n", transactionManager.getAllSpending());

        System.out.println("Роспечатка росходов");
        printSpendingWithRoutes(transactionManager.getAllSpendingWithRoutes());
    }

    private static void printSpendingWithRoutes(Map<String, Double> spending){
        for (String s : spending.keySet()) {
            System.out.printf("[%30s] -----> %.2f\n", s, spending.get(s));
        }
    }
}
