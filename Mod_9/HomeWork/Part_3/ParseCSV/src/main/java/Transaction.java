import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private String accountType;
    private String number;
    private String currency;
    private String dateOperation;
    private String reference;
    private String description;
    private double coming;
    private double spending;
}
