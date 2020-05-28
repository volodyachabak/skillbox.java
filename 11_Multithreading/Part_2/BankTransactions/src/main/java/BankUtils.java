import java.util.HashMap;

public class BankUtils {

    public static HashMap<Integer, Account> generateAccounts(int count){

        HashMap<Integer, Account> accounts = new HashMap<>();
        for (int accNumber = 0; accNumber <= count; accNumber++){
            long money = (long)(10_000 + 80_000 * Math.random());
            Account account = new Account(money, accNumber);
            accounts.put(accNumber, account);
        }
        return accounts;
    }
}
