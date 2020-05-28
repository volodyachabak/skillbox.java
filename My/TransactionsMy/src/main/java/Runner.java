public class Runner {

    private static Bank bank = new Bank();
    private static final int COUNT_ACCOUNTS = 1000;
    private static final int LIMIT = 50_000;
    private static final double PER_CENT = 0.05;
    private static final int POOL_COUNT = 8;
    private static final int BORDER = COUNT_ACCOUNTS - (int)(COUNT_ACCOUNTS * PER_CENT);
    private static final int COUNT_TRANSFERS = COUNT_ACCOUNTS;

    public static void main(String[] args) {

        bank.setAccounts(BankUtils.generateAccounts(COUNT_ACCOUNTS));

        for (int i = 0; i < POOL_COUNT; i++) {
            new Thread(()->{
                for (int j = 0; j < COUNT_TRANSFERS; j++) {
                    long  amount;
                    if (j > BORDER){
                        amount = (long)(LIMIT + LIMIT * Math.random());
                    } else {
                        amount = (long)(LIMIT * Math.random());
                    }
                    bank.transfer(String.valueOf(j), String.valueOf(COUNT_ACCOUNTS - j), amount);
                }
            }).start();
        }

        long count = bank.getAccounts().values().stream().filter((v) -> v.getBalance() > 50000).count();
        System.out.println(count);
    }

}
