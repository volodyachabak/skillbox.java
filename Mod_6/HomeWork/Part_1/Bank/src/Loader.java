public class Loader {

    public static void main(String[] args) {
        CardAccount cardAccount = new CardAccount();
        cardAccount.put(1000);
        cardAccount.withdraw(100);
        System.out.println(cardAccount.getAmount());

        DepositaryAccount depositaryAccount = new DepositaryAccount();
        depositaryAccount.put(1000);
        depositaryAccount.withdraw(100);
    }
}
