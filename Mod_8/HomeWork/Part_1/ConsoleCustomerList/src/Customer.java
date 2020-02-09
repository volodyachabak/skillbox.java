import java.util.regex.Pattern;

public class Customer
{
    private String name;
    private String phone;
    private String eMail;
    private static final Pattern PATTERN_PHONE = Pattern.compile("^\\+?\\d{2,10}");
    private static final Pattern PATTERN_EMAIL = Pattern.compile("\\w+@[A-z_]+?\\.[A-z]{2,6}");


    public Customer(String name, String phone, String eMail) throws NotValidCustomerException
    {
        if (!PATTERN_EMAIL.matcher(eMail).find()){
            throw new NotValidCustomerEmailException();
        }
        if (!PATTERN_PHONE.matcher(phone).find()){
            throw new NotValidCustomerPhoneNumberException();
        }
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
    }

    public String toString()
    {
        return name + " - " + eMail + " - " + phone;
    }
}
