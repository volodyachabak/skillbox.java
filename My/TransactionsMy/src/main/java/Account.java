import exeption.NoMoneyAccountException;

public class Account
{
    private long money;
    private String accNumber;
    private volatile boolean block = false;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public void withDrawMoney(long amount) throws NoMoneyAccountException {
        if (money >= amount){
            money -= amount;
        } else {
            throw new NoMoneyAccountException();
        }
    }

    public void putMoney(long amount){
        money += amount;
    }

    public long getBalance(){
        return money;
    }

    public void setBlock(boolean block){
        this.block = block;
    }

    public boolean isBlock() {
        return block;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", accNumber='" + accNumber + '\'' +
                ", block=" + block +
                '}';
    }
}
