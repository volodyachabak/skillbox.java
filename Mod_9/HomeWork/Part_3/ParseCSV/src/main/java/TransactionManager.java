import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionManager {

    private List<Transaction> transactions;

    public TransactionManager(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Double getAllComing(){
        return transactions.stream()
                .map(Transaction::getComing)
                .reduce(Double::sum).orElse(null);
    }

    public Double getAllSpending(){
        return transactions.stream()
                .map(Transaction::getSpending)
                .reduce(Double::sum).orElse(null);
    }

    public Map<String, Double> getAllSpendingWithRoutes(){
        Map<String, Double> mapSpending = new HashMap<>();

        transactions.stream()
                .filter((t)-> t.getSpending() > 0)
                .forEach((t)-> {
                    String key = parseRoute(t.getDescription());
                    double tmpValue = t.getSpending();
                    if (mapSpending.containsKey(key)){
                        tmpValue += mapSpending.get(key);
                    }
                    mapSpending.put(key, tmpValue);
                });

        return mapSpending;
    }

    private static String parseRoute(String str){
        String[] split = str.split(" {3,}")[1].split("[\\\\\\/]");
        return split[split.length - 1].trim();
    }

    public static List<Transaction> parseCSV(List<List<String>> dataCSV) {
        List<Transaction> transactionList = new ArrayList<>();
        for (List<String> row : dataCSV){
            Transaction transaction = new Transaction(row.get(0),
                    row.get(1),
                    row.get(2),
                    row.get(3),
                    row.get(4),
                    row.get(5),
                    Double.parseDouble(row.get(6).replaceAll(",", ".")),
                    Double.parseDouble(row.get(7).replaceAll(",", ".")));
            transactionList.add(transaction);
        }
        return transactionList;
    }
}
