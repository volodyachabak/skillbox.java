public abstract class Account {

    private double amount;

    public void put(double value){
        amount += value;
    }

    public void withdraw(double value){
        amount -= value;
    }

    public double getAmount(){
        return amount;
    }
}
