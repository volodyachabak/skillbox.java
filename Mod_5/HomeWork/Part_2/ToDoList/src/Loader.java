import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

    private static final String PATTERN_LIST = "^LIST";
    private static final String PATTERN_EXIT = "^EXIT";
    private static final String PATTERN_ADD = "^ADD\\s+";
    private static final String PATTERN_ADD_WITH_DIGITS = "^ADD\\s+\\d+\\s+";
    private static final String PATTERN_EDIT_WITH_DIGITS = "^EDIT\\s+\\d+\\s+";
    private static final String PATTERN_DELETE_WITH_DIGITS = "^DELETE\\s+\\d+";
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
        Matcher matcherExit = Pattern.compile(PATTERN_EXIT).matcher(Loader.input);
        Matcher matcherList = Pattern.compile(PATTERN_LIST).matcher(input);
        Matcher matcherAddWithDigits = Pattern.compile(PATTERN_ADD_WITH_DIGITS).matcher(input);
        Matcher matcherAdd = Pattern.compile(PATTERN_ADD).matcher(input);
        Matcher matcherEditWithDigits = Pattern.compile(PATTERN_EDIT_WITH_DIGITS).matcher(input);
        Matcher matcherDeleteWithDigits = Pattern.compile(PATTERN_DELETE_WITH_DIGITS).matcher(input);
        params = null;

        if (matcherExit.find()) {
            params = matcherExit.group().split("\\s+");
            input = input.replaceAll(PATTERN_EXIT, "");
        }
        if (matcherList.find()) {
            params = matcherList.group().split("\\s+");
            input = input.replaceAll(PATTERN_LIST, "");
        }
        if (matcherAdd.find() && !Pattern.compile(PATTERN_ADD_WITH_DIGITS).matcher(input).find()) {
            params = matcherAdd.group().split("\\s+");
            input = input.replaceAll(PATTERN_ADD, "");
        }
        if (matcherAddWithDigits.find()) {
            params = matcherAddWithDigits.group().split("\\s+");
            input = input.replaceAll(PATTERN_ADD_WITH_DIGITS, "");
        }
        if (matcherEditWithDigits.find()) {
            params = matcherEditWithDigits.group().split("\\s+");
            input = input.replaceAll(PATTERN_EDIT_WITH_DIGITS, "");
        }
        if (matcherDeleteWithDigits.find()) {
            params = matcherDeleteWithDigits.group().split("\\s+");
            input = input.replaceAll(PATTERN_DELETE_WITH_DIGITS, "");
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
