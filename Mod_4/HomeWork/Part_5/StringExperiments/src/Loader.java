
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        String[] strings = text.replaceAll("\\D+", " ").trim().split("\\s+");

        int result = 0;

        for (String str : strings){
            result += Integer.parseInt(str);
        }
        System.out.println(result);
    }
}