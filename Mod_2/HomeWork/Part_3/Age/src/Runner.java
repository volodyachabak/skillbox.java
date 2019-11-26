import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        int[] ages =  {25, 22, 35};

        int minAge = ages[0];
        int averageAge = 0;
        int maxAge = 0;

        for (int age : ages) {
            if (age < minAge) {
                minAge = age;
            }

            if (age > maxAge) {
                maxAge = age;
            }
            averageAge += age;
        }

        System.out.println("Min age: " + minAge);
        System.out.println("Max age: " + maxAge);
        System.out.println("Average age: " + averageAge / ages.length);
    }
}
