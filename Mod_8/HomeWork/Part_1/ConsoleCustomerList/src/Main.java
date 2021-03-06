import java.util.Scanner;

public class Main
{
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        for(;;)
        {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            try {
                if(tokens[0].equals("add")) {
                    try {
                        executor.addCustomer(tokens[1]);
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    } catch (NotValidCustomerEmailException e){
                        System.out.println("Not valid email");
                    } catch (NotValidCustomerPhoneNumberException e){
                        System.out.println("Not valid phone number");
                    }
                }
                else if(tokens[0].equals("list")) {
                    executor.listCustomers();
                }
                else if(tokens[0].equals("remove"))
                {
                    String token = tokens[1];
                    try {
                        executor.removeCustomer(token);
                    } catch (NotFoundCustomerException e){
                        System.out.println(e.getMessage() + ": " + token);
                    }
                }
                else if(tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                }
                else if(tokens[0].equals("help")) {
                    System.out.println(helpText);
                }
                else {
                    throw new NotFoundCommandException();
                }
            } catch (NotFoundCommandException e){
                System.out.println(commandError);
            }
        }
    }
}
