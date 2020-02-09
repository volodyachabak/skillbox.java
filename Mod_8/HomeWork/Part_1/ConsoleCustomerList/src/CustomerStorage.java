import java.util.HashMap;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws NotValidCustomerException
    {
        String[] components = data.split("\\s+");
        if(components.length != 4){
            throw new IllegalArgumentException("Wrong format: add command");
        }

        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        if (!storage.containsKey(name)){
            throw new NotFoundCustomerException("Not found customer");
        }
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}