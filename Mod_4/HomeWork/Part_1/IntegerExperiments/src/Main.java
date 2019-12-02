public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigits(container.count));
    }

    public static int sumDigits(Integer number)
    {
        //@TODO: write code here

        int value = 0;
        //Мне так больше нравится
        for (char symb : number.toString().toCharArray()){
            value += Integer.parseInt("" + symb);
        }

//        String str = number.toString();
//        for (int i = 0; i < str.length(); i++) {
//            value += Integer.parseInt(String.valueOf(str.charAt(i)));
//        }

        return value;
    }
}
