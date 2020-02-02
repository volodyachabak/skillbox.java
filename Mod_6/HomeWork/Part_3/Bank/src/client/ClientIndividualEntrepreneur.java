package client;

public class ClientIndividualEntrepreneur extends Client {

    private static final double BORDER_COMMISSION = 1000;
    private static final double AFTER_BORDER_COMMISSION = 0.005;
    private static final double BEFORE_BORDER_COMMISSION = 0.01;

    @Override
    public void put(double value) {
        super.put(value - value * ((value >= BORDER_COMMISSION)? AFTER_BORDER_COMMISSION : BEFORE_BORDER_COMMISSION));
    }
}
