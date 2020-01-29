import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Loader {

    private static final Pattern PATTERN_LIST = Pattern.compile("^LIST");
    private static final Pattern PATTERN_EXIT = Pattern.compile("^EXIT");
    private static final Pattern PATTERN_NAME = Pattern.compile("^[^\\d]\\w{2,10}(\\s\\w{2,10})?");
    private static final Pattern PATTERN_PHONE = Pattern.compile("^\\d{2,10}");

    private static String[] params;
    private static String input;

    private static Map<String, String> phoneBook = new TreeMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        exit:
        while (true){
            System.out.println("Enter:");
            input = scanner.nextLine().trim();

            if (isCommand()){  //If input is command
                switch (params[0]){
                    case "EXIT":
                        break exit;
                    case "LIST":
                        list();
                        break;
                }
            } else if (isName(input)){ //If input is name
                String name = input;
                if (phoneBook.containsValue(name)) {
                    for (String number : phoneBook.keySet()){
                        String value = phoneBook.get(number);
                        if (value.equals(name)){
                            System.out.println(number);
                        }
                    }
                } else {
                    System.out.println("This name is unknown please enter number for save!");
                    String newNumber = scanner.nextLine().trim();
                    if (isNumber(newNumber)){
                        phoneBook.put(newNumber, name);
                        System.out.println("Successfully");
                    } else {
                        System.out.println("Invalid number. Not saved!");
                    }
                }
            } else if (isNumber(input)){    //If input is number
                String number = input;
                if (phoneBook.containsKey(input)){
                    System.out.println(phoneBook.get(input));
                } else {
                    System.out.println("This number is unknown please enter name for save!");
                    String newName = scanner.nextLine().trim();
                    if (isName(newName)){
                        phoneBook.put(number, newName);
                        System.out.println("Successfully");
                    } else {
                        System.out.println("Invalid name. Not saved!");
                    }
                }
            } else {
                System.err.println("Bad input");
            }
        }
    }

    private static boolean isCommand(){
        Matcher matcherExit = PATTERN_EXIT.matcher(Loader.input);
        Matcher matcherList = PATTERN_LIST.matcher(input);
        params = null;

        if (matcherExit.find()) {
            params = matcherExit.group().split("\\s+");
            input = matcherExit.replaceAll("");
        }
        if (matcherList.find()) {
            params = matcherList.group().split("\\s+");
            input = matcherList.replaceAll("");
        }

        return params != null;
    }

    private static boolean isName(String value){
        return PATTERN_NAME.matcher(value).find();
    }

    private static boolean isNumber(String value){
        return PATTERN_PHONE.matcher(value).find();
    }

    private static void list(){
        if (!phoneBook.isEmpty()){
            phoneBook = sortByValue(phoneBook);
            for (String number : phoneBook.keySet()){
                System.out.println(phoneBook.get(number) + " = " + number);
            }
        } else {
            System.err.println("Book is empty!");
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue( Map<K, V> map )
    {
        Map<K,V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K,V>> st = map.entrySet().stream();

        st.sorted(Comparator.comparing(e -> e.getValue()))
                .forEach(e ->result.put(e.getKey(),e.getValue()));

        return result;
    }
}
