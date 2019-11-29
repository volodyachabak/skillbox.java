
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

        System.out.println("Count cat " + Cat.getCount());
        
        System.out.println("Cat1: " + cat1.getStatus());
        System.out.println("Cat1 weight = " + cat1.getWeight());

        while (!cat1.getStatus().equals("Exploded")){
            System.out.println("Cat1 feed 100!");
            cat1.feed(100.);
        }

        System.err.println("Cat1: " + cat1.getStatus());
        System.out.println("Count cat " + Cat.getCount());

        System.out.println("Cat2: " + cat2.getStatus());
        System.out.println("Cat2 weight = " + cat2.getWeight());

        while (!cat2.getStatus().equals("Dead")){
            cat2.meow();
        }

        System.err.println("Cat2: " + cat2.getStatus());
        System.out.println("Count cat " + Cat.getCount());
    }
}