
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loader {

    public static void main(String[] args) {

        LocalDate birthDay = LocalDate.of(1995, 6, 24);
        LocalDate curDate = LocalDate.now();

        for (int i = 0; i < curDate.getYear() - birthDay.getYear(); i++) {
            System.out.println(i + " - " + birthDay.plusYears(i).format(DateTimeFormatter.ofPattern("dd.MM.yyyy - E")));
        }
    }
}
