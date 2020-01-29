import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

    private static final Pattern PATTERN_LIST = Pattern.compile("^LIST");
    private static final Pattern PATTERN_EXIT = Pattern.compile("^EXIT");
    private static final Pattern PATTERN_ADD = Pattern.compile("^ADD\\s+");
    private static final Pattern PATTERN_ADD_WITH_DIGITS = Pattern.compile("^ADD\\s+\\d+\\s+");
    private static final Pattern PATTERN_EDIT_WITH_DIGITS = Pattern.compile("^EDIT\\s+\\d+\\s+");
    private static final Pattern PATTERN_DELETE_WITH_DIGITS = Pattern.compile("^DELETE\\s+\\d+");
    private static String[] params;
    private static String input;

    private static List<String> toDoList = new ArrayList<>();

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
                        add();
                        break;
                    case "EDIT":
                        edit();
                        break;
                    case "DELETE":
                        toDoList.remove(Integer.parseInt(params[1]));
                        break;
                }
            } else {
                System.err.println("Unknown command");
            }
        }
    }

    private static boolean isCommand(){
        Matcher matcherExit = PATTERN_EXIT.matcher(input);
        Matcher matcherList = PATTERN_LIST.matcher(input);
        Matcher matcherAddWithDigits = PATTERN_ADD_WITH_DIGITS.matcher(input);
        Matcher matcherAdd = PATTERN_ADD.matcher(input);
        Matcher matcherEditWithDigits = PATTERN_EDIT_WITH_DIGITS.matcher(input);
        Matcher matcherDeleteWithDigits = PATTERN_DELETE_WITH_DIGITS.matcher(input);
        params = null;

        if (matcherExit.find()) {
            params = matcherExit.group().split("\\s+");
            input = matcherExit.replaceAll("");
        }
        if (matcherList.find()) {
            params = matcherList.group().split("\\s+");
            input = matcherList.replaceAll("");

        }
        if (matcherAdd.find() && !PATTERN_ADD_WITH_DIGITS.matcher(input).find()) {
            params = matcherAdd.group().split("\\s+");
            input = matcherAdd.replaceAll("");
        }
        if (matcherAddWithDigits.find()) {
            params = matcherAddWithDigits.group().split("\\s+");
            input = matcherAddWithDigits.replaceAll("");
        }
        if (matcherEditWithDigits.find()) {
            params = matcherEditWithDigits.group().split("\\s+");
            input = matcherEditWithDigits.replaceAll( "");
        }
        if (matcherDeleteWithDigits.find()) {
            params = matcherDeleteWithDigits.group().split("\\s+");
            input = matcherDeleteWithDigits.replaceAll( "");
        }
        return params != null;
    }

    private static void add(){
        if (params.length == 2){
            if (Integer.parseInt(params[1]) < toDoList.size()){
                toDoList.add(Integer.parseInt(params[1]), input);
            } else {
                System.err.println("Bad Index");
            }
        } else {
            toDoList.add(input);
        }
    }

    private static void edit(){
        if (Integer.parseInt(params[1]) < toDoList.size()){
            toDoList.set(Integer.parseInt(params[1]), input);
        } else {
            System.err.println("Bad Index");
        }
    }

    private static void list(){
        if (!toDoList.isEmpty()){
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println(i + " " + toDoList.get(i));
            }
        } else {
            System.err.println("To do list is empty!");
        }
    }
}
