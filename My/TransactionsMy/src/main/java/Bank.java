import exeption.AccountIsBlockException;
import exeption.NoMoneyAccountException;

import java.util.HashMap;
import java.util.Random;

public class Bank
{
    private HashMap<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount)
    {
        try {
            Account fromAccount = accounts.get(fromAccountNum);
            Account toAccount = accounts.get(toAccountNum);

            if (fromAccount.isBlock() || toAccount.isBlock()){
                throw new AccountIsBlockException();
            }

            fromAccount.withDrawMoney(amount);
            toAccount.putMoney(amount);

            if (amount > 50_000){
                if (isFraud(fromAccountNum, toAccountNum , amount)){
                    toAccount.withDrawMoney(amount);
                    fromAccount.putMoney(amount);
                    fromAccount.setBlock(true);
                    toAccount.setBlock(true);
                    System.err.println("Account is BLOCK!" + fromAccount + " AND " + toAccount);
                }
            }
        } catch (NoMoneyAccountException e) {
            System.err.println("No money");
        } catch (AccountIsBlockException e){
            System.err.println("Accounts is blocked transfer is break");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum)
    {
        return accounts.get(accountNum).getBalance();
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }
}
