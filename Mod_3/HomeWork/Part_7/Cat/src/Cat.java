
public class Cat
{
    private double originWeight;
    private double weight;

    private final static double minWeight = 1000.0;
    private final static double maxWeight = 9000.0;
    private boolean live;
    private static int count;
    private final static int numberEyes = 2;
    private CatColor color;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
        live = true;
    }

    public Cat(double weight)
    {
        this();
        this.weight = weight;
        originWeight = weight;
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

    public CatColor getColor() {
        return color;
    }

    public void setColor(CatColor color) {
        this.color = color;
    }

    public static Cat copy(Cat originCat) {
        Cat copy = new Cat();
        copy.color = originCat.color;
        copy.live = originCat.live;
        copy.originWeight = originCat.originWeight;
        copy.weight = originCat.weight;
        return copy;
    }
}