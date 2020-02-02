package client;

public abstract class Client {
    private double amount;

    public double getBalance(){
        return amount;
    }

    public void put(double value) {
        amount += value;
    }

    public void withDraw(double value) {
        if(value > amount){
            System.err.println("Not enough money");
        } else {
            amount -= value;
        }
    }
}
