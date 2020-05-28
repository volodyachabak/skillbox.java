import java.util.HashMap;

public class BankUtils {

    public static HashMap<String, Account> generateAccounts(int count){

        HashMap<String, Account> accounts = new HashMap<>();
        for (int i = 0; i <= count; i++){
            long money = (long)(10_000 + 80_000 * Math.random());
            String accNumber = String.valueOf(i);
            Account account = new Account(money, accNumber);
            accounts.put(accNumber, account);
        }
        return accounts;
    }
}
