public class Runner {

    private static final Bank BANK = new Bank();
    private static final int ACCOUNT_COUNT = 1000;
    private static final int THREAD_COUNT = 10;
    private static final int TRANSFER_COUNT = ACCOUNT_COUNT;


    public static void main(String[] args) {
        BANK.setAccounts(BankUtils.generateAccounts(ACCOUNT_COUNT));

        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(()->{
                for (int j = 0; j < TRANSFER_COUNT; j++) {
                    int amount = (int) (52500 * Math.random());
                    BANK.transfer(j, ACCOUNT_COUNT - j, amount);
                }
            }).start();
        }

        long count = BANK.getAccounts().values().stream().filter((v) -> v.getBalance() > 50000).count();
        System.out.println(count);
    }

}
