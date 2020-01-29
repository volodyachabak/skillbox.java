import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

    private static final Pattern PATTERN_LIST = Pattern.compile("^LIST");
    private static final Pattern PATTERN_EXIT = Pattern.compile("^EXIT");
    private static final Pattern PATTERN_ADD = Pattern.compile("^ADD\\s+");
    private static final Pattern PATTERN_EMAIL = Pattern.compile("\\w+@[A-z_]+?\\.[A-z]{2,6}");

    private static String[] params;
    private static String input;

    private static List<String> emailsList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        exit:
        while (true){
            System.out.println("Enter:");
            input = scanner.nextLine().trim();
            if (isCommand()){
                String command = params[0];
                switch (command){
                    case "EXIT":
                        break exit;
                    case "LIST":
                        list();
                        break;
                    case "ADD":
                        if (isValidEmail(input)){
                            emailsList.add(input);
                            System.out.println("Successfully");
                        } else {
                            System.err.println("Email is not valid");
                        }
                        break;
                }
            } else {
                System.err.println("Unknown command");
            }
        }
    }

    private static boolean isCommand(){
        Matcher matcherExit = PATTERN_EXIT.matcher(Loader.input);
        Matcher matcherList = PATTERN_LIST.matcher(input);
        Matcher matcherAdd = PATTERN_ADD.matcher(input);
        params = null;

        if (matcherExit.find()) {
            params = matcherExit.group().split("\\s+");
            input = matcherExit.replaceAll("");
        }
        if (matcherList.find()) {
            params = matcherList.group().split("\\s+");
            input = matcherList.replaceAll("");
        }
        if (matcherAdd.find()) {
            params = matcherAdd.group().split("\\s+");
            input = matcherAdd.replaceAll("");
        }

        return params != null;
    }

    private static boolean isValidEmail(String value){
        return PATTERN_EMAIL.matcher(value).find();
    }

    private static void list(){
        if (!emailsList.isEmpty()){
            for (int i = 0; i < emailsList.size(); i++) {
                System.out.println(i + " " + emailsList.get(i));
            }
        } else {
            System.err.println("List is empty!");
        }
    }
}
