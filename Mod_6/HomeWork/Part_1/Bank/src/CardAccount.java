public class CardAccount extends Account {

    private static final double COMMISSION = 0.01;

    @Override
    public void withdraw(double value) {
        super.withdraw(value + (value * COMMISSION));
    }
}