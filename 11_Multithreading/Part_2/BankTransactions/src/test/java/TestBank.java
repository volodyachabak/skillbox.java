import exeption.AccountIsBlockException;
import exeption.NoMoneyAccountException;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThrows;

public class TestBank extends TestCase {

    private static final Bank BANK = new Bank();
    private static final int ACCOUNT_COUNT = 1000;
//    private static final int LIMIT = 50_000;
    private static final int THREAD_COUNT = 100;
    private static final int TRANSFER_COUNT = ACCOUNT_COUNT;

    @After
    public void setUp(){
        BANK.setAccounts(BankUtils.generateAccounts(ACCOUNT_COUNT));
    }

    @Test
    public void testOneTransaction(){
        int accountNumberFrom = 0;
        int accountNumberTo = 1;
        Account accountFrom = BANK.getAccounts().get(accountNumberFrom);
        Account accountTo = BANK.getAccounts().get(accountNumberTo);

        long amount = 2750;
        long expectedFrom = accountFrom.getBalance() - amount;
        long expectedTo = accountTo.getBalance() + amount;

        BANK.transfer(accountNumberFrom, accountNumberTo, amount);

        assertEquals(expectedFrom, accountFrom.getBalance());
        assertEquals(expectedTo, accountTo.getBalance());
    }

    @Test
    public void testTransactionWithNoMoney(){
        int accountNumberFrom = 2;
        int accountNumberTo = 3;

        NoMoneyAccountException thrown = assertThrows(
                NoMoneyAccountException.class, () -> {
                    BANK.transfer(accountNumberFrom, accountNumberTo, 1_000_000);
                });
    }

    @Test
    public void testAccountIsBlock() {
        int accountNumberFrom = 4;
        int accountNumberTo = 5;
        Account accountFrom = BANK.getAccounts().get(accountNumberFrom);
        accountFrom.setBlock(true);

        AccountIsBlockException thrown = assertThrows(
                AccountIsBlockException.class, () -> {
                    BANK.transfer(accountNumberFrom, accountNumberTo, 1);
                });
    }

    @Test
    public void testOneThread(){
        Account accountFrom = BANK.getAccounts().get(0);
        Account accountTo = BANK.getAccounts().get(ACCOUNT_COUNT);

        long amount = 5760;
        long expectedFrom = accountFrom.getBalance() - amount;
        long expectedTo = accountTo.getBalance() + amount;

        for (int j = 0; j < ACCOUNT_COUNT; j++) {
            BANK.transfer(j, ACCOUNT_COUNT - j, amount);
        }

        assertEquals(expectedFrom, accountFrom.getBalance());
        assertEquals(expectedTo, accountTo.getBalance());
    }
    
    @Test
    public void testManyThreads(){
        Account accountFrom = BANK.getAccounts().get(0);
        Account accountTo = BANK.getAccounts().get(7);

        long amount = 1000;
        long expectedFrom = accountFrom.getBalance();
        long expectedTo = accountTo.getBalance();

        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(()->{
                for (int j = 0; j < TRANSFER_COUNT; j++) {
                    BANK.transfer(j, ACCOUNT_COUNT - j, amount);
                    BANK.transfer(ACCOUNT_COUNT - j, j, amount);
                }
            }).start();

            assertEquals(expectedFrom, accountFrom.getBalance());
            assertEquals(expectedTo, accountTo.getBalance());
        }
    }
}
