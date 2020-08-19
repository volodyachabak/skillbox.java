
public class Runner {

    private static final Bank bank;

    private static final int ACCOUNT_COUNT = 100;
    private static final int THREAD_COUNT = 10;
    private static final int TRANSFER_COUNT = ACCOUNT_COUNT;


    static {
        bank = new Bank();
        bank.setAccounts(BankUtils.generateAccounts(ACCOUNT_COUNT));
    }

    public static void main(String[] args) throws InterruptedException {
//        bank.getAccounts().forEach((k, v) -> System.out.println(v));

//        System.out.println(bank.getAllMoney());
        run();
    }

    private static void run() throws InterruptedException {
        long allMoney = bank.getAllMoney();

        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                for (int j = 0; j < TRANSFER_COUNT; j++) {
                    int amount = (int) (52500 * Math.random());
                    try {
                        bank.transfer(j, TRANSFER_COUNT - j, amount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.sleep(20000);
        System.out.println(allMoney);
        System.out.println(bank.getAllMoney());
    }
}
