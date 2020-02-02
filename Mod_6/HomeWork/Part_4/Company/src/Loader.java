
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.*;

public class Loader {

    public static void main(String[] args) {
        Company company = new Company(10_000_000);
        Operator.setSalary(4000);
        Manager.setBonus(0.05);
        Manager.setSalary(8000);
        TopManager.setBonus(1.5);
        TopManager.setSalary(10000);
        TopManager.setIncomeCompany(company.getIncome());
        int countOperators = 180;
        int countManagers = 80;
        int countTopManagers = 10;
        List<Employee> operators = new ArrayList<>();
        List<Employee> managers = new ArrayList<>();

        for(int i = 0; i < countOperators; i++) {
            operators.add(new Operator());
        }

        company.hireAll(operators);

        for(int i = 0; i < countManagers; i++) {
            managers.add(new Manager(1000 + Math.random() * 25000));
        }

        company.hireAll(managers);

        for(var i = 0; i < countTopManagers; i++) {
            company.hire(new TopManager());
        }

        System.out.println("Top salary");
        for (Employee employee : company.getTopSalaryStaff(15)){
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("Top lowest salary");
        for (Employee employee : company.getLowestSalaryStaff(30)){
            System.out.println(employee.getMonthSalary());
        }

        company.fire((countOperators + countManagers + countTopManagers) / 2);

        System.out.println("After fire 50% staff");

        System.out.println("Top salary");

        for (Employee employee : company.getTopSalaryStaff(15)){
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("Top lowest salary");

        for (Employee employee : company.getLowestSalaryStaff(30)){
            System.out.println(employee.getMonthSalary());
        }
    }
}
