
public class Loader
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();

        System.out.println(cat.getWeight());
        System.out.println(cat.getEat());
        cat.feed(145.);
        System.out.println(cat.getWeight());
        System.out.println(cat.getEat());
        cat.toToilet();
        System.out.println(cat.getWeight());

        System.out.println(cat.getStatus());
    }
}