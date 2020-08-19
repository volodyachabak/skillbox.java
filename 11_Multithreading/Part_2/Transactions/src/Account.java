import exeption.NotEnoughMoneyException;

public class Account
{
    private long money;
    private int accNumber;
    private boolean blocked = false;

    public Account(long money, int accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void withdraw(long amount)  {
        if (money >= amount) {
            money -= amount;
        } else {
            throw new NotEnoughMoneyException();
        }
    }

    public void put(long amount) {
        money += amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", accNumber='" + accNumber + '\'' +
                ", blocked=" + blocked +
                '}';
    }
}
