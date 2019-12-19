import org.w3c.dom.ls.LSOutput;

public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        String masha = text.substring(text.lastIndexOf("- ") + 2, text.lastIndexOf(" руб"));

        String vasyaSubString = text.substring(text.indexOf("Вася"), text.indexOf(" руб"));
        String vasya = vasyaSubString.substring(vasyaSubString.lastIndexOf(" ")).trim();

        System.out.println(Integer.valueOf(masha) + Integer.valueOf(vasya));
    }
}