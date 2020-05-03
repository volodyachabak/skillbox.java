import java.sql.*;

public class Runner {

    private static final String URL = "jdbc:mysql://localhost:3306/skillbox";
    private static final String USER = "root";
    private static final String PASSWORD = "test";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, (COUNT(MONTH(subscription_date)) / COUNT(DISTINCT MONTH(subscription_date))) AS count_per_month FROM PurchaseList GROUP BY course_name;");

            while(resultSet.next()){
                System.out.printf("Course %s average number of purchases per month: %s\n", resultSet.getString("course_name"), resultSet.getDouble("count_per_month"));
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
