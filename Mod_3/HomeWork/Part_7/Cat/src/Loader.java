
public class Loader
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();
        Cat cat1 = Cat.copy(cat);

        System.out.println("Cat: " + cat.getStatus());
        System.out.println("Cat weight = " + cat.getWeight());

        System.out.println("Cat 1: " + cat1.getStatus());
        System.out.println("Cat 1 weight = " + cat1.getWeight());

        System.out.println("Hash cat: " + cat.hashCode());
        System.out.println("Hash cat 1: " + cat1.hashCode());
    }
}