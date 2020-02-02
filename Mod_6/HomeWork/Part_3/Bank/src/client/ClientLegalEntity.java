package client;

public class ClientLegalEntity extends Client {

    private final static double COMMISSION = 0.01;

    @Override
    public void withDraw(double value) {
        super.withDraw(value + value * COMMISSION);
    }
}
