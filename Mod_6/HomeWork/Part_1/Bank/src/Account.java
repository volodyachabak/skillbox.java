public abstract class Account {

    private double amount;

    public void put(double value){
        amount += value;
    }

    public void withdraw(double value){
        if(value > amount){
            System.err.println("Not enough money");
        } else {
            amount -= value;
        }
    }

    public double getAmount(){
        return amount;
    }
}
