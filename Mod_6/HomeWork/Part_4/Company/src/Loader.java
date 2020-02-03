
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.*;

public class Loader {

    public static void main(String[] args) {
        Company company = new Company();
        double topManagerBonus = 1.5;
        double managerBonus = 0.05;
        int countOperators = 180;
        int countManagers = 80;
        int countTopManagers = 10;
        List<Employee> operators = new ArrayList<>();
        List<Employee> managers = new ArrayList<>();

        for(int i = 0; i < countOperators; i++) {
            operators.add(new Operator(2000 + Math.random() * 3000));
        }

        company.hireAll(operators);

        for(int i = 0; i < countManagers; i++) {
            Manager manager = new Manager(4000 + Math.random() * 4000);
            manager.setMadeMoney(1000 + Math.random() * 25000);
            manager.setBonus(managerBonus);
            managers.add(manager);
        }

        company.hireAll(managers);

        for(var i = 0; i < countTopManagers; i++) {
            TopManager topManager = new TopManager(6000 + Math.random() * 6000);
            topManager.setBonus(topManagerBonus);
            topManager.setCompany(company);
            company.hire(topManager);
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

        System.out.println("Company income " + company.getIncome());
    }
}
