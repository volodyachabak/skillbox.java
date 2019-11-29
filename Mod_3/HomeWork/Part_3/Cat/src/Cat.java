
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private boolean live;
    private static int count;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
        live = true;
    }

    public void meow()
    {
        if (live){
            weight = weight - 1;
            System.out.println("Meow");
            changeLive();
        } else {
            getStatus();
        }
    }

    public void feed(Double amount)
    {
        if (live){
            weight += amount;
            changeLive();
        } else {
            getStatus();
        }
    }

    public void drink(Double amount)
    {
        if (live){
            weight += amount;
            changeLive();
        } else {
            getStatus();
        }
    }

    public Double getWeight()
    {
        if(!live){
            getStatus();
        }
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    private void changeLive(){
        if((weight < minWeight || weight > maxWeight) && live) {
            live = false;
            count--;
        }
    }

    public static int getCount() {
        return count;
    }
}