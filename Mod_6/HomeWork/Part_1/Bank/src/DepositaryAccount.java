import java.time.LocalDate;

public class DepositaryAccount extends Account {

    private LocalDate dateOfWithdraw;
    private int monthsOfWithdraw = 1;

    @Override
    public void put(double value) {
        super.put(value);
        dateOfWithdraw = LocalDate.now().plusMonths(monthsOfWithdraw);
    }

    @Override
    public void withdraw(double value) {
        if (dateOfWithdraw.isBefore(LocalDate.now())){
            super.withdraw(value);
        } else {
            System.err.println("Sorry, it wasn't a month after the deposit was made");
        }
    }
}
