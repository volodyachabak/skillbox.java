
public class Loader
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();


        System.out.println("Cat: " + cat.getStatus());
        System.out.println("Cat weight = " + cat.getWeight());
        cat.meow();
        System.out.println("Cat weight = " + cat.getWeight());
        System.out.println("Cat feed 180!");
        cat.feed(180.);
        System.out.println("Cat: " + cat.getStatus());
        cat.meow();
        System.out.println("Cat weight = " + cat.getWeight());
        System.out.println(cat.getStatus());

        System.out.println("Cat1: " + cat1.getStatus());
        System.out.println("Cat1 weight = " + cat1.getWeight());

        while (!cat1.getStatus().equals("Exploded")){
            System.out.println("Cat1 feed 100!");
            cat1.feed(100.);
        }

        System.out.println("Cat1: " + cat1.getStatus());

        System.out.println("Cat2: " + cat2.getStatus());
        System.out.println("Cat2 weight = " + cat2.getWeight());

        while (!cat2.getStatus().equals("Dead")){
            cat2.meow();
        }

        System.out.println("Cat2: " + cat2.getStatus());
    }
}