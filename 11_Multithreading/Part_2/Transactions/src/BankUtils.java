
import java.util.HashMap;
import java.util.Map;

public class BankUtils {

    public static Map<Integer, Account> generateAccounts(int count){

        Map<Integer, Account> accounts = new HashMap<>();
        for (int accNumber = 0; accNumber <= count; accNumber++){
            long money = (long)(10_000 + 100_000 * Math.random());
            Account account = new Account(money, accNumber);
            accounts.put(accNumber, account);
        }
        return accounts;
    }
}
