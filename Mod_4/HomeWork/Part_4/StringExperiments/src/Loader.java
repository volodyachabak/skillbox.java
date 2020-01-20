public class Loader
{
    private static final int START_STRING = 0;
    private static final String POINT = " руб";

    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        if(!text.isEmpty()){
            while (text.contains(POINT)) {
                int indexPoint = text.indexOf(POINT);
                String tempStr = text.substring(START_STRING, indexPoint);
                System.out.println(Integer.parseInt(tempStr.substring(tempStr.lastIndexOf(" ")).trim()));
                text = text.substring(indexPoint + POINT.length());
            }
        } else {
            System.err.println("Text is empty");
        }
    }
}