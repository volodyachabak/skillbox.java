import exeption.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {
    private Map<Integer, Account> accounts;
    private final Random random = new Random();
    private final int limit = 50_000;

    public synchronized boolean isFraud(int fromAccountNum, int toAccountNum, long amount)
        throws InterruptedException {
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
    public void transfer(int fromAccountNum, int toAccountNum, long amount) throws InterruptedException {
        Account from = accounts.get(fromAccountNum);
        Account to = accounts.get(toAccountNum);

        System.out.printf("Transfer from {%d} --[%d]--> {%d}\n", fromAccountNum, amount, toAccountNum);

        if (from.isBlocked() && to.isBlocked()) {
            System.out.println("Account is blocked!");
        } else {
            try {
                from.withdraw(amount);
                to.put(amount);

                if (amount > limit) {
                    if (isFraud(fromAccountNum, toAccountNum, amount)) {
                        from.setBlocked(true);
                        to.setBlocked(true);
                    }
                }
            } catch (NotEnoughMoneyException e) {
                System.err.println("Not enough money!");
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum)
    {
        return accounts.get(accountNum).getMoney();
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public long getAllMoney() {
        return accounts.values().stream().mapToLong(Account::getMoney).sum();
    }
}
